package com.rackspace.util;

public class ObjectNotFoundException extends RuntimeException{
	public ObjectNotFoundException(int id) {
		super("Object not found Exception, ID = " + id);
	}
}
