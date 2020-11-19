package com.raghu.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.fleetapp.models.JobTitle;
import com.raghu.fleetapp.repositories.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	//returns the list of jobTitles
	public List<JobTitle> getJobTitles(){
		return jobTitleRepository.findAll();
	}

	//add a new jobTitle
	public void save(JobTitle jobTitle)
	{
		jobTitleRepository.save(jobTitle);
	}
	
	//find by id
	
	public Optional<JobTitle> findById(int id)
	{
		return jobTitleRepository.findById(id);
	}

	public void delete(Integer id) {
		
		jobTitleRepository.deleteById(id);
	}

}
