package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.VehicleMaintenance;
import com.raghu.fleetapp.repositories.VehicleMaintenanceRepository;

@Service
public class VehicleMaintenanceService 
{

	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;
	
	//returns the list of vehicleMaintenances
	public List<VehicleMaintenance> getVehicleMaintenances(){
		return vehicleMaintenanceRepository.findAll();
	}

	//add a new vehicleMaintenance
	public void save(VehicleMaintenance vehicleMaintenance)
	{
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}
	
	//find by id
	
	public Optional<VehicleMaintenance> findById(int id)
	{
		return vehicleMaintenanceRepository.findById(id);
	}

	public void delete(Integer id) {
		
		vehicleMaintenanceRepository.deleteById(id);
	}
}
