package com.rackspace.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
@Table(name="VEHICLE")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id;
	
	/**
	 * validation API
	 */
	@NotNull
	@Size(min=2, max=20)
	private String brand;
	@NotNull
	@Size(min=2, max=50)
	private String model;
	
	private Integer year;
	@Enumerated(EnumType.STRING)
	@Column(name="TYPE_VEHICLE")	 
	private VehicleType type;
	
	
	public Vehicle() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Vehicle(int id,  String brand, String model, Integer year, VehicleType type) {
	 
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.type = type;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Vehicle[" + id + " " + brand + " " + model + " " + type+  "]";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}	 

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
  