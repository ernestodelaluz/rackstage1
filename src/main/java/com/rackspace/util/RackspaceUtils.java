package com.rackspace.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public interface RackspaceUtils {

	/*
	 * Format a date according to the format "yyyy-MM-dd HH:mm:ss.SSS"
	 */
	static String formatLocaltime(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		String formatDateTime = date.format(formatter);
		return formatDateTime;
	}
	
	 
}
