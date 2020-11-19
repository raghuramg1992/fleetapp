package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.VehicleType;
import com.raghu.fleetapp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {

	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	//returns the list of vehicleTypes
	public List<VehicleType> getVehicleTypes(){
		return vehicleTypeRepository.findAll();
	}

	//add a new vehicleType
	public void save(VehicleType vehicleType)
	{
		vehicleTypeRepository.save(vehicleType);
	}
	
	//find by id
	
	public Optional<VehicleType> findById(int id)
	{
		return vehicleTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		
		vehicleTypeRepository.deleteById(id);
	}

}
