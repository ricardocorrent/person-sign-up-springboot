package com.ws.expenses.gateway;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ws.commons.integration.proxytextension.InjectProxy;
import com.ws.commons.server.json.ObjectMapperResolver;
import com.ws.expenses.tripservice.ServiceTO;
import com.ws.service.service.ServiceResource;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import org.apache.http.HttpStatus;

/**
 * @author Eduardo Squisatti
 * @since 2018-06-25.
 */
public class ServiceGateway {

    @InjectProxy
    private ServiceResource resource;

    private final ObjectMapper mapper = ObjectMapperResolver.getInstance().createMapper();

    public ServiceGateway() {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public ServiceTO findServiceById(final UUID serviceId) throws IOException {
        if (serviceId != null) {

            final Response response = resource.get(serviceId.toString());

            if (response.getStatus() == HttpStatus.SC_OK) {
                return mapper.readValue((InputStream) response.getEntity(), ServiceTO.class);
            }
        }
        return null;
    }
}
