package com.rackspace.services;

import org.springframework.stereotype.Service;

 
import com.rackspace.domain.Vehicle;
import com.rackspace.strategy.*;


/**
 * Context for strategy pattern
 * @author Ernesto
 *
 */
@Service
public class VehicleBehaviorServiceImpl implements VehicleBehaviorService{
	
	
	@Override
	public void moveVehicle(Moveable moveable) {		 
		moveable.moveBackwards();
		moveable.moveForward();
		moveable.moveUp();
		moveable.moveDown();
 
		if(moveable instanceof Switchable) {
			System.out.println("Switching mode");
			Switchable switchable =  (Switchable)moveable;
			switchable.switchMode();
			moveable.moveBackwards();
			moveable.moveForward();
			moveable.moveUp();
			moveable.moveDown();
		}else {
			System.out.println("Switch mode is not allowed");
		}		
		
	}
}
