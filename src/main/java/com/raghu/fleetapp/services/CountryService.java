package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.Country;
import com.raghu.fleetapp.repositories.CountryRepository;

@Service
public class CountryService 
{
	@Autowired
	private CountryRepository countryRepository;
	
	//returns the list of countries
	public List<Country> getCountries(){
		return countryRepository.findAll();
	}

	//add a new country
	public void save(Country country)
	{
		countryRepository.save(country);
	}
	
	//find by id
	
	public Optional<Country> findById(int id)
	{
		return countryRepository.findById(id);
	}

	public void delete(Integer id) {
		
		countryRepository.deleteById(id);
	}
}
