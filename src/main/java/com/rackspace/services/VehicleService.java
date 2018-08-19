package com.rackspace.services;

import java.util.List;

 
import com.rackspace.domain.Vehicle;
import com.rackspace.domain.VehicleType;

public interface VehicleService {
	List<Vehicle> getAllVehicles();
	Vehicle getVehicleById(int id);
	List<Vehicle> searchVehicles(String brand, String model, Integer year, VehicleType type);
	
	Vehicle addVehicle(Vehicle vehicle);
	Vehicle removeVehicle(int id);
	Vehicle updateVehicle(Vehicle vehicle);
	
}
