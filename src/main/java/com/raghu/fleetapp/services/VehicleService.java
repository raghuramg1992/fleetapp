package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.Vehicle;
import com.raghu.fleetapp.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	//returns the list of vehicles
	public List<Vehicle> getVehicles(){
		return vehicleRepository.findAll();
	}

	//add a new vehicle
	public void save(Vehicle vehicle)
	{
		vehicleRepository.save(vehicle);
	}
	
	//find by id
	
	public Optional<Vehicle> findById(int id)
	{
		return vehicleRepository.findById(id);
	}

	public void delete(Integer id) {
		
		vehicleRepository.deleteById(id);
	}
}
