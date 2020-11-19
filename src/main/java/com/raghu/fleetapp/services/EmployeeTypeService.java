package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.EmployeeType;
import com.raghu.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	//returns the list of employeeTypes
	public List<EmployeeType> getEmployeeTypes(){
		return employeeTypeRepository.findAll();
	}

	//add a new employeeType
	public void save(EmployeeType employeeType)
	{
		employeeTypeRepository.save(employeeType);
	}
	
	//find by id
	
	public Optional<EmployeeType> findById(int id)
	{
		return employeeTypeRepository.findById(id);
	}

	public void delete(Integer id) {
		
		employeeTypeRepository.deleteById(id);
	}

}
