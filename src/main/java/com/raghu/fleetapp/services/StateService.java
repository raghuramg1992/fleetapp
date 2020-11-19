package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.State;
import com.raghu.fleetapp.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	//returns the list of states
	public List<State> getStates(){
		return stateRepository.findAll();
	}

	//add a new state
	public void save(State state)
	{
		stateRepository.save(state);
	}
	
	//find by id
	
	public Optional<State> findById(int id)
	{
		return stateRepository.findById(id);
	}

	public void delete(Integer id) {
		
		stateRepository.deleteById(id);
	}
}
