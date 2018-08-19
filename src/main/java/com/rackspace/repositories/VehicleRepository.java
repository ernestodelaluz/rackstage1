package com.rackspace.repositories;

import java.util.List;

import com.rackspace.domain.Vehicle;
import com.rackspace.domain.VehicleType;

public interface VehicleRepository {
	/**
	 * get all vehicles using Named query
	 * @return
	 */
	List<Vehicle> getAllVehicles();
	
	/**
	 * find vehicle using typed query JPQL
	 * @param id
	 * @return
	 */
	Vehicle getVehicleById(int id);
	
	Vehicle addVehicle(Vehicle vehicle);
	
	void removeVehicle(Vehicle vehicle);
	Vehicle updateVehicle(Vehicle vehicle);

	/**
	 * search vehicles using Criteria API
	 * @return
	 */
	List<Vehicle> searchVehicles(String brand, String model, Integer year, VehicleType type);
	
 
}
