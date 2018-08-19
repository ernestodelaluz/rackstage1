package com.rackspace.util;

public class DuplicateObjectException extends RuntimeException {
	public DuplicateObjectException() {
		super("Object found: This object cannot be inserted twice");
	}
}
