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
public class RentvsBuy {
	
	Rent rent;

	public static void main(String[] args) {
	
		//compareRentAndBuy(args);
		System.out.println("--------Enter Details for comparison-------- ");  
        Scanner in = new Scanner(System.in);  
        System.out.print("Please enter your flat's monthly rent: ");    
        double flatRent = in.nextDouble(); 
        System.out.print("Please enter your flat's monthly maintenance: ");  
        double maintenance = in.nextDouble();  
        System.out.print("Please enter your flat's Rent increase rate: ");  
        double increaseRate = in.nextDouble();  
        System.out.println("Please enter your flat's Rented years:");     
        double rentedYears = in.nextDouble();
        
        System.out.print("Please enter your flat's Price: ");    
        double flatPrice = in.nextDouble(); 
        System.out.print("Please enter your flat's monthly maintenance: ");  
        double flatMonthlyMaintenance = in.nextDouble();  
        System.out.print("Please enter your flat's maintenance increase rate: ");  
        double maintenanceIncreaseRate = in.nextDouble();  
        System.out.println("Please enter your flat's purchase years:");     
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
		
        compareRentAndBuy(rent,buy);
        
        in.close();           

	}
	
	public static void compareRentAndBuy(Rent rent, Buy buy){
		
		Rent calculatedRent = calculateFlatRent(rent);
		Buy calculatedBuy = calaculateFlatPrice(buy);
		System.out.println("Comparison for Rent and Buying--");
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
	
	public static Buy calaculateFlatPrice(Buy buy){
		
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
