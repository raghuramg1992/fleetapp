package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.VehicleMovement;
import com.raghu.fleetapp.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService 
{
	
	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
	//returns the list of vehicleMovements
	public List<VehicleMovement> getVehicleMovements(){
		return vehicleMovementRepository.findAll();
	}

	//add a new vehicleMovement
	public void save(VehicleMovement vehicleMovement)
	{
		vehicleMovementRepository.save(vehicleMovement);
	}
	
	//find by id
	
	public Optional<VehicleMovement> findById(int id)
	{
		return vehicleMovementRepository.findById(id);
	}

	public void delete(Integer id) {
		
		vehicleMovementRepository.deleteById(id);
	}


}
