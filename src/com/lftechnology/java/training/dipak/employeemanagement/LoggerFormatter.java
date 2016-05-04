
package com.lftechnology.java.training.dipak.employeemanagement;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * <p>
 * This class extends the Formatter class and is used to format the logger in order to display only the messages excluding the dates and the
 * origin of logger.
 * </p>
 * 
 * @author Dipak Thapa<dipakthapa@lftechnology.com>
 */
public class LoggerFormatter extends Formatter {

    /**
     * <p>
     * This method overrides the abstract method in Formatter class and is used to format only the logger message.
     * </p>
     * 
     * @author Dipak Thapa<dipakthapa@lftechnology.com>
     */
    @Override
    public String format(LogRecord record) {

        StringBuilder builder = new StringBuilder();
        builder.append(formatMessage(record));
        builder.append("\n");
        return builder.toString();

    }
}
