package com.rcorrent.personsignup.auth;

import com.rcorrent.personsignup.security.AccountCredentialsVO;
import com.rcorrent.personsignup.security.jwt.JwtTokenProvider;
import com.rcorrent.personsignup.user.User;
import com.rcorrent.personsignup.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider tokenProvider;

    private final UserRepository repository;

    public AuthController(final AuthenticationManager authenticationManager,
                          final JwtTokenProvider tokenProvider,
                          final UserRepository repository) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.repository = repository;
    }

    @SuppressWarnings("rawtypes")
    @PostMapping(value = "/signin", produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    public ResponseEntity signin(@RequestBody AccountCredentialsVO data) {
        try {
            final String username = data.getUserName();
            final String pasword = data.getPassword();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, pasword));

            final User user = repository.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("Username " + username + " not found!");
            }

            final String token = tokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (final AuthenticationException error) {
            throw new BadCredentialsException("Invalid username/password supplied!", error);
        }
    }
}