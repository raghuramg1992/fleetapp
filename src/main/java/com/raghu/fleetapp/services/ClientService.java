package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.Client;
import com.raghu.fleetapp.repositories.ClientRepository;

@Service
public class ClientService 
{

	@Autowired
	private ClientRepository clientRepository;
	
	//returns the list of clients
	public List<Client> getClients(){
		return clientRepository.findAll();
	}

	//add a new client
	public void save(Client client)
	{
		clientRepository.save(client);
	}
	
	//find by id
	
	public Optional<Client> findById(int id)
	{
		return clientRepository.findById(id);
	}

	public void delete(Integer id) {
		
		clientRepository.deleteById(id);
	}
}
