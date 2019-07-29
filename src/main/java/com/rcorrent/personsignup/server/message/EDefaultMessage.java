package com.rcorrent.personsignup.server.message;


/**
 * Enumerator that defines default messages which can be used for innumerable purposes.
 *
 * <p>
 * For example, if you want to return the default message for a instruction that validates the nullability of an object,
 * you might need to use:
 * </p>
 *
 * <pre>
 *      Objects.requireNonNull(value, EDefaultMessage.PARAMETER_CANNOT_BE_NULL.getMessage("object"));
 * </pre>
 *
 * <p>
 * This will return a message like 'The <b>object</b> parameter cannot be null', since the parameter passed in the call
 * is 'object'.
 * </p>
 *
 */
public enum EDefaultMessage implements IFormattedMessage {

    /**
     * Unformatted message: The {0} parameter cannot be null.
     */
    PARAMETER_CANNOT_BE_NULL("The {0} parameter cannot be null."),

    /**
     * Unformatted message: The {0} value cannot be null.
     */
    VALUE_CANNOT_BE_NULL("The {0} value cannot be null."),

    /**
     * Unformatted message: The {0} parameter cannot be empty.
     */
    PARAMETER_CANNOT_BE_EMPTY("The {0} parameter cannot be empty."),

    /**
     * Unformatted message: The {0} parameter must be positive.
     */
    PARAMETER_MUST_BE_POSITIVE("The {0} parameter must be positive."),

    /**
     * Unformatted message: The {0} array contain a null value at position {1}.
     */
    ARRAY_CONTAIN_NULL_VALUE_AT("The {0} array contain a null value at position {1}."),

    /**
     * Unformatted message: The {0} was not defined to {1}.
     */
    ELEMENT_NOT_DEFINED_IN_CLASS("The {0} is not defined in {1}."),

    /**
     * Unformatted message: Transaction must be active
     */
    TRANSACTION_MUST_BE_ACTIVE("Transaction must be active");

    private String unformattedMessage;

    EDefaultMessage(final String key) {
        this.unformattedMessage = key;
    }

    /**
     * @see com.ws.commons.message.IFormattedMessage#getUnformattedMessage()
     */
    @Override
    public String getUnformattedMessage() {
        return unformattedMessage;
    }
}
