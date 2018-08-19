package com.rackspace.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rackspace.domain.Vehicle;
import com.rackspace.domain.VehicleType;
import com.rackspace.repositories.VehicleRepository;

/**
 * Service facade that contains CRUD operations to the Vehicle
 * @author Ernesto
 *
 */
@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
	private static final Logger LOGGER = LogManager.getLogger(VehicleServiceImpl.class);

	@Autowired
	private VehicleRepository vehicleRepository;

	

	@Override
	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.getAllVehicles();
	}

	@Override
	public Vehicle getVehicleById(int id) {
		return vehicleRepository.getVehicleById(id);
	}
	@Override
	public List<Vehicle> searchVehicles(String brand, String model, Integer year, VehicleType type) {
		return vehicleRepository.searchVehicles(brand, model, year, type);
	}
	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		Vehicle v =  vehicleRepository.addVehicle(vehicle);		 
		return v;
		
	}
	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		Vehicle v =  vehicleRepository.updateVehicle(vehicle);		
		return v;
	}
	@Override
	public Vehicle removeVehicle(int id) {
		Vehicle v =  vehicleRepository.getVehicleById(id);
		if(v!=null) {
			vehicleRepository.removeVehicle(v);
		}
		return v;
	}
	 

}
