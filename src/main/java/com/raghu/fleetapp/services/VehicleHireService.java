package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.VehicleHire;
import com.raghu.fleetapp.repositories.VehicleHireRepository;

@Service
public class VehicleHireService 
{

	@Autowired
	private VehicleHireRepository vehicleHireRepository;
	
	//returns the list of vehicleHires
	public List<VehicleHire> getVehicleHires(){
		return vehicleHireRepository.findAll();
	}

	//add a new vehicleHire
	public void save(VehicleHire vehicleHire)
	{
		vehicleHireRepository.save(vehicleHire);
	}
	
	//find by id
	
	public Optional<VehicleHire> findById(int id)
	{
		return vehicleHireRepository.findById(id);
	}

	public void delete(Integer id) {
		
		vehicleHireRepository.deleteById(id);
	}
}
