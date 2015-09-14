
package com.lftechnology.java.training.dipak.employeemanagement;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LoggerFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {

		// The following code removes all the fields except the message

		StringBuilder builder = new StringBuilder();
		builder.append(formatMessage(record));
		builder.append("\n");
		return builder.toString();

	}
}
