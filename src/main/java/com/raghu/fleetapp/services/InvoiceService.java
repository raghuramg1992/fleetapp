package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.Invoice;
import com.raghu.fleetapp.repositories.InvoiceRepository;

@Service
public class InvoiceService 
{
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	//returns the list of invoices
	public List<Invoice> getInvoices(){
		return invoiceRepository.findAll();
	}

	//add a new invoice
	public void save(Invoice invoice)
	{
		invoiceRepository.save(invoice);
	}
	
	//find by id
	
	public Optional<Invoice> findById(int id)
	{
		return invoiceRepository.findById(id);
	}

	public void delete(Integer id) {
		
		invoiceRepository.deleteById(id);
	}

}
