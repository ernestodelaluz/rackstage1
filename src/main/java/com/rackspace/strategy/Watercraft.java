package com.rackspace.strategy;

 
import com.rackspace.domain.Vehicle;
/**
 * Concrete strategy for Watercraft vehicles
 * @author Ernesto
 *
 */

public class Watercraft  implements Moveable{
	private Vehicle vehicle;
	
	public Watercraft(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	@Override
	public void moveForward() {
		System.out.println(vehicle + " sailing forward ");		
	}

	@Override
	public void moveBackwards() {
		System.out.println("Invalid operation for sailing");		
	}

	@Override
	public void moveUp() {
		System.out.println("Invalid operation for sailing");		
	}

	@Override
	public void moveDown() {
		System.out.println("Invalid operation for sailing");	
	}
 
}
