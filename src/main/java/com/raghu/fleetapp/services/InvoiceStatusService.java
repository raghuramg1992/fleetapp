package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.InvoiceStatus;
import com.raghu.fleetapp.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {
	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	//returns the list of invoiceStatuss
	public List<InvoiceStatus> getInvoiceStatuses(){
		return invoiceStatusRepository.findAll();
	}

	//add a new invoiceStatus
	public void save(InvoiceStatus invoiceStatus)
	{
		invoiceStatusRepository.save(invoiceStatus);
	}
	
	//find by id
	
	public Optional<InvoiceStatus> findById(int id)
	{
		return invoiceStatusRepository.findById(id);
	}

	public void delete(Integer id) {
		
		invoiceStatusRepository.deleteById(id);
	}

}
