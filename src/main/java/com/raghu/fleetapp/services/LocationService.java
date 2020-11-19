package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.Location;
import com.raghu.fleetapp.repositories.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	//returns the list of locations
	public List<Location> getLocations(){
		return locationRepository.findAll();
	}

	//add a new location
	public void save(Location location)
	{
		locationRepository.save(location);
	}
	
	//find by id
	
	public Optional<Location> findById(int id)
	{
		return locationRepository.findById(id);
	}

	public void delete(Integer id) {
		
		locationRepository.deleteById(id);
	}

}
