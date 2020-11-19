package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.Supplier;
import com.raghu.fleetapp.repositories.SupplierRepository;

@Service
public class SupplierService
{

	@Autowired
	private SupplierRepository supplierRepository;
	
	//returns the list of suppliers
	public List<Supplier> getSuppliers(){
		return supplierRepository.findAll();
	}

	//add a new supplier
	public void save(Supplier supplier)
	{
		supplierRepository.save(supplier);
	}
	
	//find by id
	
	public Optional<Supplier> findById(int id)
	{
		return supplierRepository.findById(id);
	}

	public void delete(Integer id) {
		
		supplierRepository.deleteById(id);
	}

}
