package com.rackspace.strategy;

 
import com.rackspace.domain.Vehicle;
/**
 * Concrete strategy for Aircraft vehicles
 * @author Ernesto
 *
 */
public class Aircraft  implements Moveable{
	private Vehicle vehicle;
	
	public Aircraft(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	@Override
	public void moveForward() {
		System.out.println(vehicle + " flying forward ");		
	}

	@Override
	public void moveBackwards() {
		System.out.println("Backwards - Invalid operation for flying");		
	}

	@Override
	public void moveUp() {
		System.out.println(vehicle + " flying up ");		
	}

	@Override
	public void moveDown() {
		System.out.println(vehicle + " flying down ");		
	}
 
	
}