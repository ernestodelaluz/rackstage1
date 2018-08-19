package com.rackspace.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

 
import com.rackspace.domain.Vehicle;
import com.rackspace.domain.VehicleType;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Vehicle> getAllVehicles() {
		TypedQuery<Vehicle> typedQuery = entityManager.createNamedQuery("Vehicle.findAll" , Vehicle.class);	    
	    List<Vehicle> all = typedQuery.getResultList();
	    
		return all;
	}
	
	@Override
	public Vehicle getVehicleById(int id) {
		TypedQuery<Vehicle> typedQuery = entityManager.createQuery(
				"Select v from Vehicle v WHERE v.id = :id", Vehicle.class);
	    typedQuery.setParameter("id", id);
	    return typedQuery.getSingleResult();
		 
	}
	@Override
	public List<Vehicle> searchVehicles(String brand, String model, Integer year, VehicleType type) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Vehicle> cq = cb.createQuery(Vehicle.class);
		Root<Vehicle> vehicle = cq.from(Vehicle.class);
		Predicate p = null;
		if(brand!=null) {
			p =cb.equal( vehicle.get("brand"), brand);
		}
		if(model!=null) {
			if(p!=null) {
				p = cb.and( p, cb.equal( vehicle.get("model"), model) ) ;
			}else {
				p = cb.equal( vehicle.get("model"), model);
			}
			
		}
		if(year!=null) {
			if(p!=null) {
				p = cb.and(p,   cb.equal( vehicle.get("year"), year) ) ;
			}else {
				p =cb.equal( vehicle.get("year"), year);
			}
			
		}
		if(type!=null) {
			if(p!=null) {
				p = cb.and(p,  cb.equal( vehicle.get("type"), type) ) ;
			}else {
				p = cb.equal( vehicle.get("type"), type);
			}
			
		}
				
		if(p!=null) {
			cq.where(p);
		}
		
		cq.select(vehicle);
		TypedQuery<Vehicle> tq = entityManager.createQuery(cq);
		List<Vehicle> list = tq.getResultList();

		return list;
	}
	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		entityManager.persist(vehicle);
		return vehicle;
		 
	}
	
	@Override
	public void removeVehicle(Vehicle vehicle) {
		entityManager.remove(vehicle);
	}
	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		Vehicle v = entityManager.merge(vehicle);
		return v;
	}
}
