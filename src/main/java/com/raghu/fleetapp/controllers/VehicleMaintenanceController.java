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
import com.raghu.fleetapp.models.Supplier;
import com.raghu.fleetapp.models.Vehicle;
import com.raghu.fleetapp.models.VehicleMaintenance;
import com.raghu.fleetapp.services.SupplierService;
import com.raghu.fleetapp.services.VehicleMaintenanceService;
import com.raghu.fleetapp.services.VehicleService;

@Controller
public class VehicleMaintenanceController {

	@Autowired
	private SupplierService supplierService;
	@Autowired
	private VehicleMaintenanceService vehicleMaintenanceService;
	@Autowired
	private VehicleService vehicleService;
	@GetMapping("/vehicleMaintenances")
	public String getVehicleMaintenances(Model model)
	{
		List<VehicleMaintenance> vehicleMaintenanceList=vehicleMaintenanceService.getVehicleMaintenances();
		model.addAttribute("vehicleMaintenances",vehicleMaintenanceList);
		
		List<Vehicle> vehicleList=vehicleService.getVehicles();
		model.addAttribute("vehicles",vehicleList);
		
		List<Supplier> supplierList=supplierService.getSuppliers();
		model.addAttribute("suppliers",supplierList);
		
		return "VehicleMaintenance";
	}
	
	@PostMapping("/vehicleMaintenances/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance)
	{
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenances";
	}
	
	@RequestMapping("vehicleMaintenances/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(int id)
	{
		return vehicleMaintenanceService.findById(id);
	}

	@RequestMapping(value="/vehicleMaintenances/update",method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(VehicleMaintenance vehicleMaintenance)
	{
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenances";
	}
	
	@RequestMapping(value="/vehicleMaintenances/delete",method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehicleMaintenances";
	}
}
