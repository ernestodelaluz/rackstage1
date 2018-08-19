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
		System.out.println(vehicle + " flying forward (Air)");		
	}

	@Override
	public void moveBackwards() {
		System.out.println(vehicle + " Backwards - Invalid operation for flying");		
	}

	@Override
	public void moveUp() {
		System.out.println(vehicle + " flying up (Air)");		
	}

	@Override
	public void moveDown() {
		System.out.println(vehicle + " flying down (Air)");		
	}
 
	
}