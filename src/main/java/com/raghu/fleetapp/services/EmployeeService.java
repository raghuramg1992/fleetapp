package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.Employee;
import com.raghu.fleetapp.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired private EmployeeRepository employeeRepository;

	public Employee findByUsername(String un) {
		// TODO Auto-generated method stub
		return employeeRepository.findByUsername(un);
	}

	//returns the list of employees
		public List<Employee> getEmployees(){
			return employeeRepository.findAll();
		}

		//add a new employee
		public void save(Employee employee)
		{
			employeeRepository.save(employee);
		}
		
		//find by id
		
		public Optional<Employee> findById(int id)
		{
			return employeeRepository.findById(id);
		}

		public void delete(Integer id) {
			
			employeeRepository.deleteById(id);
		}

}
