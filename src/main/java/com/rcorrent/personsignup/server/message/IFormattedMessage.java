package com.rcorrent.personsignup.server.message;

import java.text.MessageFormat;

/**
 * This interface represents the minimal structure representation of an artifact message formatting.
 *
 * <p>
 * It provides methods to retrieve both an unformatted message and a formatted one.
 * </p>
 * <pre>
 * A message that is defined by
 *
 *      "The parameter {0} could not be null"
 *
 * could easily be formatted through the {@link #getMessage(Object...)} implementation of this class, when you provide
 * the desired parameter to format it.
 *
 * With the argument "sale", the result of the call should be
 *
 *      "The parameter sale could not be null"
 *
 * which has the correctly format.
 * </pre>
 *
 * <p>
 * This interface uses {@link MessageFormat} strategies to format messages properly, but its methods can be overridden
 * to get the desired behaviour.
 * </p>
 */
public interface IFormattedMessage {
    /**
     * Retrieves an unformatted message.
     *
     * @return the unformatted message
     */
    String getUnformattedMessage();

    /**
     * Retrieves a formatted message.
     *
     * @param parameters to format the message
     * @return           the formatted message
     */
    default String getMessage(final Object... parameters) {
        return MessageFormat.format(getUnformattedMessage(), parameters);
    }
}
