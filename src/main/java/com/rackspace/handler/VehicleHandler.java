package com.rackspace.handler;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rackspace.domain.Vehicle;
import com.rackspace.domain.VehicleType;
import com.rackspace.repositories.VehicleRepository;
import com.rackspace.services.VehicleBehaviorService;
import com.rackspace.services.VehicleService;
import com.rackspace.strategy.Aircraft;
import com.rackspace.strategy.Amphibious;
import com.rackspace.strategy.Moveable;
import com.rackspace.strategy.Terrestrial;
import com.rackspace.strategy.Watercraft;
import com.rackspace.util.GenericPatchObject;
import com.rackspace.util.ObjectNotFoundException;

@RestController
@RequestMapping("/mvcrest")
public class VehicleHandler {
	private static final Logger LOGGER = LogManager.getLogger(VehicleHandler.class);
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private VehicleBehaviorService behaviorService;
	
	@GetMapping("/vehicles")
	public List<Vehicle> getAllVehicles(){
		List<Vehicle> list = vehicleService.getAllVehicles();
		
		//Code for testing behaviour using Strategy pattern
		list.forEach(v -> {
				Moveable moveable = null;
				switch (v.getType()) {
				case TERRESTRIAL:
					moveable = new Terrestrial(v);
					break;
				case WATERCRAFT:
					moveable = new Watercraft(v);
					break;
				case AIRCRAFT:
					moveable = new Aircraft(v);
					break;
				case AMPHIBIOUS:
					moveable = new Amphibious(v);
					break;
				}
				behaviorService.moveVehicle(moveable);
			}

		);

		 
		
		
		
		return list;
	}
	
	@GetMapping("/vehicles/{id}")
	public Vehicle getVehicleById(@PathVariable int id) {
		Vehicle v = vehicleService.getVehicleById(id);
		if(v==null) {
			throw new ObjectNotFoundException(id);
		}		
		return v;
	}
	@DeleteMapping("/vehicles/{id}")
	public void removeVehicle(@PathVariable int id) {
		Vehicle v = vehicleService.removeVehicle(id);
		if(v==null) {
			throw new ObjectNotFoundException(id);
		}		
	}
	
	@GetMapping("/vehicles/search")
	public List<Vehicle> searchVehicles(
			@RequestParam(name="brand", required=false) String brand
			,@RequestParam(name="model", required=false) String model
			,@RequestParam(name="year", required=false) Integer year
			,@RequestParam(name="type", required=false) VehicleType type
			){
		System.out.println(year + " " + type);
		return vehicleService.searchVehicles(brand, model, year, type);
	}
	
	
	@PostMapping("/vehicles")
	public ResponseEntity<Object> addVehicle(@Valid @RequestBody Vehicle vehicle) {
		Vehicle savedObject = vehicleService.addVehicle(vehicle);
		 URI location =  ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedObject.getId())
				.toUri();
		LOGGER.info("Department created");
		return ResponseEntity.created(location).build(); 
		 
	}
	

	@PatchMapping("/vehicles/{id}")
	public ResponseEntity<Object> partialDepartmentUpdate(@RequestBody GenericPatchObject  patchObject
			, @PathVariable int id ){
		Vehicle vehicle = vehicleService.getVehicleById(id);
		if(vehicle==null) {
			throw new ObjectNotFoundException(id);
		}	
 		
		switch (patchObject.getPatch()) {
		case "brand":
			vehicle.setBrand(patchObject.getValue());
			break;
		case "model":
			vehicle.setModel(patchObject.getValue());
			break;
		case "year":
			vehicle.setYear(Integer.parseInt(patchObject.getValue()));
			break;
		case "type":
			vehicle.setType(VehicleType.valueOf(patchObject.getValue()));
			break;

		default:
			return ResponseEntity.badRequest().build();
		}
		vehicleService.updateVehicle(vehicle);
		LOGGER.info("vehicle updated: " + patchObject.getPatch());
		Map<String, String> response = new HashMap<>();
		response.put("message", "Resource '"+ patchObject.getPatch() +"' updated");
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/test")
	public String testWebService() {
		LOGGER.info("Testing logs ");		 
		return "Spring MVC RESTful is working... " + LocalDateTime.now().toString();
		
	}
}
