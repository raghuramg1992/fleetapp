package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.VehicleMake;
import com.raghu.fleetapp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {

	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	//returns the list of vehicleMakes
	public List<VehicleMake> getVehicleMakes(){
		return vehicleMakeRepository.findAll();
	}

	//add a new vehicleMake
	public void save(VehicleMake vehicleMake)
	{
		vehicleMakeRepository.save(vehicleMake);
	}
	
	//find by id
	
	public Optional<VehicleMake> findById(int id)
	{
		return vehicleMakeRepository.findById(id);
	}

	public void delete(Integer id) {
		
		vehicleMakeRepository.deleteById(id);
	}


}
