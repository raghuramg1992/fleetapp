package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.VehicleStatus;
import com.raghu.fleetapp.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {

	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;
	
	//returns the list of vehicleStatuss
	public List<VehicleStatus> getVehicleStatuss(){
		return vehicleStatusRepository.findAll();
	}

	//add a new vehicleStatus
	public void save(VehicleStatus vehicleStatus)
	{
		vehicleStatusRepository.save(vehicleStatus);
	}
	
	//find by id
	
	public Optional<VehicleStatus> findById(int id)
	{
		return vehicleStatusRepository.findById(id);
	}

	public void delete(Integer id) {
		
		vehicleStatusRepository.deleteById(id);
	}

}
