package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.Contact;
import com.raghu.fleetapp.repositories.ContactRepository;

@Service
public class ContactService 
{
	@Autowired
	private ContactRepository contactRepository;
	
	//returns the list of contacts
	public List<Contact> getContacts(){
		return contactRepository.findAll();
	}

	//add a new contact
	public void save(Contact contact)
	{
		contactRepository.save(contact);
	}
	
	//find by id
	
	public Optional<Contact> findById(int id)
	{
		return contactRepository.findById(id);
	}

	public void delete(Integer id) {
		
		contactRepository.deleteById(id);
	}
}
