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

import com.raghu.fleetapp.models.Location;
import com.raghu.fleetapp.models.Vehicle;
import com.raghu.fleetapp.models.VehicleMovement;
import com.raghu.fleetapp.services.LocationService;
import com.raghu.fleetapp.services.VehicleMovementService;
import com.raghu.fleetapp.services.VehicleService;

@Controller
public class VehicleMovementController {

	@Autowired
	private LocationService locationService;
	@Autowired
	private VehicleMovementService vehicleMovementService;
	@Autowired
	private VehicleService vehicleService;
	@GetMapping("/vehicleMovements")
	public String getVehicleMovements(Model model)
	{
		List<VehicleMovement> vehicleMovementList=vehicleMovementService.getVehicleMovements();
		model.addAttribute("vehicleMovements",vehicleMovementList);
		
		List<Location> locationList=locationService.getLocations();
		model.addAttribute("locations",locationList);
		
		List<Vehicle> vehicleList=vehicleService.getVehicles();
		model.addAttribute("vehicles",vehicleList);
		
		return "VehicleMovement";
	}
	
	@PostMapping("/vehicleMovements/addNew")
	public String addNew(VehicleMovement vehicleMovement)
	{
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}
	
	@RequestMapping("vehicleMovements/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(int id)
	{
		return vehicleMovementService.findById(id);
	}

	@RequestMapping(value="/vehicleMovements/update",method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMovement vehicleMovement)
	{
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}
	
	@RequestMapping(value="/vehicleMovements/delete",method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
		vehicleMovementService.delete(id);
		return "redirect:/vehicleMovements";
	}
}
