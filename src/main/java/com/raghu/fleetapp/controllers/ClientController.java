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

import com.raghu.fleetapp.models.Country;
import com.raghu.fleetapp.models.State;
import com.raghu.fleetapp.models.Client;
import com.raghu.fleetapp.services.CountryService;
import com.raghu.fleetapp.services.StateService;
import com.raghu.fleetapp.services.ClientService;

@Controller
public class ClientController {
	@Autowired
	private StateService stateService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private CountryService countryService;
	@GetMapping("/clients")
	public String getClients(Model model)
	{
		List<Client> clientList=clientService.getClients();
		model.addAttribute("clients",clientList);
		
		List<State> stateList=stateService.getStates();
		model.addAttribute("states",stateList);
		
		List<Country> countryList=countryService.getCountries();
		model.addAttribute("countries",countryList);
		
		return "Client";
	}
	
	@PostMapping("/clients/addNew")
	public String addNew(Client client)
	{
		clientService.save(client);
		return "redirect:/clients";
	}
	
	@RequestMapping("clients/findById")
	@ResponseBody
	public Optional<Client> findById(int id)
	{
		return clientService.findById(id);
	}

	@RequestMapping(value="/clients/update",method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Client client)
	{
		clientService.save(client);
		return "redirect:/clients";
	}
	
	@RequestMapping(value="/clients/delete",method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
		clientService.delete(id);
		return "redirect:/clients";
	}
}
