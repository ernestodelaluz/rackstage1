package com.rackspace.strategy;

 
import com.rackspace.domain.Vehicle;
 
/**
 * Concrete strategy for Amphibious vehicles
 * @author Ernesto
 *
 */

public class Amphibious implements Moveable, Switchable {
	private Terrestrial terrestrial;
	private Watercraft watercraft;
	private Moveable activeMode;

	private Vehicle vehicle;

	public Amphibious(Vehicle vehicle) {
		this.vehicle = vehicle;
		terrestrial = new Terrestrial(vehicle);
		watercraft = new Watercraft(vehicle);
		activeMode = terrestrial;
	}

	@Override
	public void switchMode() {
		if (activeMode == terrestrial) {
			activeMode = watercraft;
		} else {
			activeMode = terrestrial;
		}

	}

	@Override
	public void moveForward() {
		activeMode.moveForward();
	}

	@Override
	public void moveBackwards() {
		activeMode.moveBackwards();
	}

	@Override
	public void moveUp() {
		activeMode.moveUp();
	}

	@Override
	public void moveDown() {
		activeMode.moveDown();
	}

}