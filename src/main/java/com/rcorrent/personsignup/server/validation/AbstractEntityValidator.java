package com.rcorrent.personsignup.server.validation;

import com.rcorrent.personsignup.persistence.model.BaseModel;
import com.rcorrent.personsignup.server.message.EDefaultMessage;
import com.rcorrent.personsignup.server.validation.exception.IndexedLogicError;
import com.rcorrent.personsignup.server.validation.exception.LogicError;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public abstract class AbstractEntityValidator<T extends BaseModel> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractEntityValidator.class);
    private static final String ENTITY = "entity";
    private String indexDescriptor;


    private final Set<ConstraintViolation<BaseModel>> constraintViolations = new LinkedHashSet<>();

    /**
     * Default validation method for objects. Performs bean validations and calls the entity validator implementation.
     *
     * @param object to be validated
     * @param filter to perform isolated validations
     */
    @SuppressWarnings("unchecked")
    public void validate(final Object object, final IValidationFilter... filter) {
        Objects.requireNonNull(object, "The entity parameter cannot be null.");
        final T entity = (T) object;

        LOGGER.debug("Validating entity {} with ID {}", entity.getClass().getSimpleName(), entity.getId());

        validate(entity, filter);
    }

    protected abstract void validate(final T entity, final IValidationFilter... filter);

    public <L extends LogicError> void addError(final L logicError, final BaseModel entity) {
        Objects.requireNonNull(logicError, EDefaultMessage.PARAMETER_CANNOT_BE_NULL.getMessage("logicError"));
        Objects.requireNonNull(entity, EDefaultMessage.PARAMETER_CANNOT_BE_NULL.getMessage(ENTITY));

        constraintViolations.add(new ConstraintViolationAdapter<>(handleIndexDescriptor(logicError), entity));
    }

    private LogicError handleIndexDescriptor(final LogicError logicError) {
        if (indexDescriptor != null) {
            final IndexedLogicError indexedError = (IndexedLogicError) logicError;

            return new IndexedLogicError(
                    composeIndexDescriptor(indexedError),
                    indexedError.getField(),
                    indexedError.getMessageTemplate(),
                    indexedError.getMessage(),
                    indexedError.getValue(),
                    indexedError.getParams()
            );
        }

        return logicError;
    }

    private String composeIndexDescriptor(final IndexedLogicError indexedLogicError) {
        Objects.requireNonNull(indexedLogicError, EDefaultMessage.PARAMETER_CANNOT_BE_NULL.getMessage("indexedLogicError"));
        return StringUtils.join(indexDescriptor, "_", indexedLogicError.getIndex());
    }

    public void throwFoundErrors() {
        if (CollectionUtils.isNotEmpty(constraintViolations)) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
    /**
     * Defines a descriptor that will follows the index composition of the validated entity.
     * <p>Composition: index_descriptor</p>
     * <p>Given an index 0 with the descriptor "entity", the index composition will be 0_entity.</p>
     *
     * @param indexDescriptor to compose the index.
     */
    public void setIndexDescriptor(String indexDescriptor) {
        this.indexDescriptor = indexDescriptor;
    }

    /**
     * Retrieves the errors found due to validations performing.
     *
     * @return the errors found
     */
    public Set<ConstraintViolation<BaseModel>> getConstraintViolations() {
        return Collections.unmodifiableSet(constraintViolations);
    }

}
