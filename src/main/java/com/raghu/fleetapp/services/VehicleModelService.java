package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.VehicleModel;
import com.raghu.fleetapp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	//returns the list of vehicleModels
	public List<VehicleModel> getVehicleModels(){
		return vehicleModelRepository.findAll();
	}

	//add a new vehicleModel
	public void save(VehicleModel vehicleModel)
	{
		vehicleModelRepository.save(vehicleModel);
	}
	
	//find by id
	
	public Optional<VehicleModel> findById(int id)
	{
		return vehicleModelRepository.findById(id);
	}

	public void delete(Integer id) {
		
		vehicleModelRepository.deleteById(id);
	}

}
