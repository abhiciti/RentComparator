/**
 * 
 */
package main.java.com.example.rentcomparator;

import java.util.Scanner;

/**
 * @author AbhishekMishra
 * Takes input of 7 as{FlatMonthlyRent,FlatMonthlyMaintenance,RentIncreaseRate,Rented Year
 * Flat Price, MaintenanceIncrease rate, Monthly Maintenance, Purchase Year}
 *eg - {18000,0,10,2017,7500000,0,3000,2017}
 */
public class RentvsBuyService {
	
	Rent rent;
	
	
	public String compareRentToPurchasePrice(){
		
        Scanner in = new Scanner(System.in);  
        double flatRent = in.nextDouble(); 
        double maintenance = in.nextDouble();  
        double increaseRate = in.nextDouble();  
        double rentedYears = in.nextDouble();
        
        double flatPrice = in.nextDouble(); 
        double flatMonthlyMaintenance = in.nextDouble();  
        double maintenanceIncreaseRate = in.nextDouble();  
        double purchaseYears = in.nextDouble();
        
        Rent rent = new  Rent();
		rent.setFlatMonthlyRent(flatRent);
		rent.setMonthlyMaintenance(maintenance);
		rent.setIncreaseRate(increaseRate);
		rent.setRentedYear(rentedYears);
		
		Buy buy = new Buy();
		buy.setFlatPrice(flatPrice);
		buy.setMonthlyMaintenance(flatMonthlyMaintenance);
		buy.setMaintenaceIncreaseRate(maintenanceIncreaseRate);
		buy.setPurchaseYear(purchaseYears);
		
        return compareRentAndBuy(rent,buy);
        

	}
	
	public String compareRentAndBuy(Rent rent, Buy buy){
		
		Rent calculatedRent = calculateFlatRent(rent);
		Buy calculatedBuy = calaculateFlatPrice(buy);
		String result = null;
		
		return result;
	}
	
	
	
	public static Rent calculateFlatRent(Rent rent){
		
		double monthlyRent = rent.getFlatMonthlyRent();
		double monthlyMaintenance = rent.getMonthlyMaintenance();
		double annualIncreaseRate = (rent.getIncreaseRate()/100)+1;
		double noOfYears = rent.getRentedYear();
		double totalRent = 0;
		double yearlyGrossRent = 12*(monthlyRent + monthlyMaintenance);
		
		totalRent = yearlyGrossRent*((1-(Math.pow(annualIncreaseRate,noOfYears )))/(1-annualIncreaseRate));
		System.out.println("Total Rent for " + noOfYears + " years is " + totalRent);
		return rent; 
	}
	
	public Buy calaculateFlatPrice(Buy buy){
		
		double totalFlatPrice = 0;
		double noOfYears = buy.getPurchaseYear();
		double yearlyMaintenance = 12*buy.getMonthlyMaintenance();
		double totalMaintenance= 0;
		double annualIncreaseRate = (buy.getMaintenaceIncreaseRate()/100)+1;
		double loanFlat = 0;
		
		totalMaintenance = yearlyMaintenance*((1-(Math.pow(annualIncreaseRate,noOfYears )))/(1-annualIncreaseRate));
		totalFlatPrice = buy.getFlatPrice() + totalMaintenance;
		loanFlat = (buy.getFlatPrice())*(Math.pow(1.1, noOfYears));
		
		
		
		System.out.println("Total Flat Price for " + noOfYears + " years is " + totalFlatPrice);
		System.out.println("Total Flat Price for Loan " + noOfYears + " years is " + loanFlat+totalMaintenance);
		return buy; 
	}

}
