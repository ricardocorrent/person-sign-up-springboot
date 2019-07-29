package com.rcorrent.personsignup.server.validation.exception;

import java.util.Map;

public interface ILogicError {

    String getField();

    /**
     * @return The message key to perform internationalization.
     */
    String getMessageTemplate();

    /**
     * @return The final message for validation.
     */
    String getMessage();

    /**
     * @param message as final message for validation.
     */
    void setMessage(String message);

    /**
     * @return The rejected value.
     */
    String getValue();

    /**
     * @return The error code.
     */
    String getCode();

    /**
     * @param value that was rejected by validation.
     */
    void setValue(String value);

    /**
     * @param code to identify the error.
     */
    void setCode(String code);

    /**
     * @return The parameter to compose the final message.
     */
    Map<String, Object> getParams();

    /**
     * @param params to compose the final message.
     */
    void setParams(Map<String, Object> params);
}
