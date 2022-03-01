package main.java.com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentComparatorController {
	
	
	/**
	 * @author AbhishekMishra
	 * Takes input of 7 as{FlatMonthlyRent,FlatMonthlyMaintenance,RentIncreaseRate,Rented Year
	 * Flat Price, MaintenanceIncrease rate, Monthly Maintenance, Purchase Year}
	 *eg - {18000,0,10,2017,7500000,0,3000,2017}
	 */
	
	@GetMapping("/comparerRent/rent/{monthlyRent}/monthlyMaintenanceForRent/{monthlyMaintenanceForRent}/"
			+ "rentIncreaseREate/{rentIncreaseREate}")
	public String compareRentVsCost(@PathVariable String monthlyRent,
			@PathVariable String monthlyMaintenanceForRent, @PathVariable String rentIncreaseREate,
			@PathVariable String rentedYear, @PathVariable String maintenanceIncreaseRate ,
			@PathVariable String monthlyMaintenanceForPurchase, @PathVariable String purchaseYear) {
		
		String result= null;
		return result;
	}
	
}

