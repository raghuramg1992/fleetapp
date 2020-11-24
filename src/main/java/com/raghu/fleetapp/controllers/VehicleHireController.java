package com.raghu.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raghu.fleetapp.models.VehicleHire;
import com.raghu.fleetapp.services.ClientService;
import com.raghu.fleetapp.services.LocationService;
import com.raghu.fleetapp.services.VehicleHireService;
import com.raghu.fleetapp.services.VehicleService;

@Controller
public class VehicleHireController {

	@Autowired private VehicleHireService vehicleHireService;
	@Autowired private VehicleService vehicleService;
	@Autowired private ClientService clientService;
	@Autowired private LocationService locationService;
	
	@GetMapping("/vehicleHires")
	public String getVehicleHires(Model model)
	{
		
		model.addAttribute("vehicleHires",vehicleHireService.getVehicleHires());
		model.addAttribute("vehicles",vehicleService.getVehicles());
		model.addAttribute("clients",clientService.getClients());
		model.addAttribute("locations",locationService.getLocations());
		return "VehicleHire";
	}
	
	@PostMapping("/vehicleHires/addNew")
	public String addNew(VehicleHire vehicleHire)
	{
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHires";
	}
	
	@RequestMapping("vehicleHires/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(int id)
	{
		return vehicleHireService.findById(id);
	}

	@RequestMapping(value="/vehicleHires/update",method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleHire vehicleHire)
	{
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHires";
	}
	
	@RequestMapping(value="/vehicleHires/delete",method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
		vehicleHireService.delete(id);
		return "redirect:/vehicleHires";
	}
}
