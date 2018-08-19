package com.rackspace.handler;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.rackspace.domain.Vehicle;
import com.rackspace.domain.VehicleType;
import com.rackspace.services.VehicleService;
import com.rackspace.services.VehicleServiceImpl;


public class VehicleHandlerTest {
	private static final  Logger LOGGER = LogManager.getLogger(VehicleHandlerTest.class);
	
	private MockMvc mockMvc;
	private VehicleHandler vehicleHandler;
	private VehicleService vehicleService;
	
	@Before
	public void setUp() throws Exception {
		vehicleHandler = new VehicleHandler();		
		vehicleService = mock(VehicleServiceImpl.class);
 
		ReflectionTestUtils.setField(
				vehicleHandler
				, "vehicleService"
				, vehicleService
				, VehicleService.class);
		//build mock
		mockMvc = MockMvcBuilders.standaloneSetup(vehicleHandler).build();
		
		//set data 
		Vehicle v1 = new Vehicle(1,"Sea-Doo","RXP-X",2018,VehicleType.WATERCRAFT);
		Vehicle v2 = new Vehicle(2,"Nissan",  "Altima",  2018,  VehicleType.TERRESTRIAL);
	       	     		 
		when(vehicleService.getVehicleById(1)).thenReturn(v1);
		when(vehicleService.getVehicleById(2)).thenReturn(v2);
		
		 
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Only one test was done to show the way I do the tests, 
	 * Test are done before implementing code (Test driven development)
	 * at least 80% of the code must be covered in testing 
	 * 
	 * @throws Exception
	 */
	@Test
	public void test()throws Exception {
		ResultActions result =  mockMvc
				.perform(
						get("/mvcrest/vehicles/{id}", 2)	
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						);
		
		result.andExpect(status().isOk());
		result.andExpect(jsonPath("$.brand").value("Nissan") );
	}

}
