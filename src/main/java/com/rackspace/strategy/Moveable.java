package com.rackspace.strategy;

import com.rackspace.domain.Vehicle;

public interface Moveable {
	void moveForward();
	void moveBackwards();
	void moveUp();
	void moveDown();
 
	default void stop(Vehicle vehicle) {
		System.out.println(vehicle + " is stopping");
	}
}
