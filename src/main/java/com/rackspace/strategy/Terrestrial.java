package com.rackspace.strategy;

 
import com.rackspace.domain.Vehicle;

/**
 * Concrete strategy for Terrestrial vehicles
 * @author Ernesto
 *
 */


public class Terrestrial implements Moveable{
	private Vehicle vehicle;
	
	public Terrestrial(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	@Override
	public void moveForward() {
		System.out.println(vehicle + " driving forward ");		
	}

	@Override
	public void moveBackwards() {
		System.out.println(vehicle + " driving backwards ");		
	}

	@Override
	public void moveUp() {
		System.out.println("Move up - Invalid operation for terrestrial");		
	}

	@Override
	public void moveDown() {
		System.out.println("Move down - Invalid operation for terrestrial");	
	}
 
}