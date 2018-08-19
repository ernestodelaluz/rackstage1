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
		System.out.println(vehicle + " sailing forward (Water)");		
	}

	@Override
	public void moveBackwards() {
		System.out.println(vehicle + " sailing Backwards (Water)");		
	}

	@Override
	public void moveUp() {
		System.out.println(vehicle + " Move up - Invalid operation for sailing");		
	}

	@Override
	public void moveDown() {
		System.out.println(vehicle + " Move Down - Invalid operation for sailing");	
	}
 
}
