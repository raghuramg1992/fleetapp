package com.raghu.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raghu.fleetapp.models.Contact;
import com.raghu.fleetapp.models.Country;
import com.raghu.fleetapp.models.State;
import com.raghu.fleetapp.services.ContactService;
import com.raghu.fleetapp.services.CountryService;
import com.raghu.fleetapp.services.StateService;

@Controller
public class ContactController {

	@Autowired
	private StateService stateService;
	@Autowired
	private ContactService contactService;
	@Autowired
	private CountryService countryService;
	@GetMapping("/contacts")
	public String getContacts(Model model)
	{
		List<Contact> contactList=contactService.getContacts();
		model.addAttribute("contacts",contactList);
		
		List<State> stateList=stateService.getStates();
		model.addAttribute("states",stateList);
		
		List<Country> countryList=countryService.getCountries();
		model.addAttribute("countries",countryList);
		
		return "Contact";
	}
	
	@PostMapping("/contacts/addNew")
	public String addNew(Contact contact)
	{
		contactService.save(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping("contacts/findById")
	@ResponseBody
	public Optional<Contact> findById(int id)
	{
		return contactService.findById(id);
	}

	@RequestMapping(value="/contacts/update",method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Contact contact)
	{
		contactService.save(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping(value="/contacts/delete",method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
		contactService.delete(id);
		return "redirect:/contacts";
	}
}
