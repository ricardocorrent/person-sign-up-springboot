package com.rcorrent.personsignup.person;

import com.rcorrent.personsignup.server.validation.AbstractEntityValidator;
import com.rcorrent.personsignup.server.validation.IValidationFilter;
import com.rcorrent.personsignup.server.validation.exception.LogicError;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonValidator extends AbstractEntityValidator<Person> {
    @Override
    protected void validate(final Person entity, final IValidationFilter... filter) {
        this.doValidateIfEmailAlreadyExists(entity);
        throwFoundErrors();
    }

    private void doValidateIfEmailAlreadyExists(final Person entity) {
        if(entity.getEmail().compareToIgnoreCase("ricardo@corrent.com.br") == 0) {
            addError(new LogicError("email", "Already exists"), entity);
        }
    }
}
