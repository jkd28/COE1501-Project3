/*
	Created by: John Dott
	COE 1501: Project 3
	3/15/17
	
	This file acts as a driver for Project 3, which implements a Priority Queue with Indirection
	
*/
import java.util.Scanner;
public class CarTracker{
	static MileageQ byMiles;
	static PriceQ byPrice;
	static MakeModelQ byMakeModel;
	
	public static void displayMenu(){
		System.out.println("	1. Add a Car");
		System.out.println("	2. Update an Existing Car");
		System.out.println("	3. Remove a Car");
		System.out.println("	4. Retrieve Lowest PRICE Car");
		System.out.println("	5. Retrieve Lowest MILEAGE Car");
		System.out.println("	6. Retrieve Lowest PRICE Car by MAKE AND MODEL");
		System.out.println("	7. Retrieve Lowest MILEAGE Car by MAKE AND MODEL");
		System.out.println("Entering -1 will terminate the program");
		System.out.println("**********************************************************************");
		return;
	}
	
	// get menu input from user and validate
	public static int prompt(){
		Scanner reader = new Scanner(System.in);
		System.out.print("Selection: ");
		int choice = reader.nextInt();
		while((choice < 1 ||	choice > 7) && !(choice == -1)){
			System.out.print("INVALID SELECTION. Please enter a number from the menu above: ");
			choice = reader.nextInt();
			System.out.println();
		}
		return choice;
	}
	
	// direct user to proper function based on input
	public static void directUser(int choice){
		switch(choice){
			case 1:
				addCar();
				break;
			case 2:
				updateCar();
				break;
			case 3:
				removeCar();
				break;
			case 4:
				lowestPrice();
				break;
			case 5:
				lowestMileage();
				break;
			case 6:
			lowestPriceMakeModel();
				break;
			case 7:
			lowestMileageMakeModel();
				break;
		}
	}
	
	// gets VIN from user and returns it
	public static String userVin(int s){
		String vin;
		Scanner reader = new Scanner(System.in);
		
		// output proper message based on calling function code (s)
		switch(s){
			case 1:
				System.out.print("Enter VIN: ");
				break;
			case 2: 
				System.out.print("Enter the VIN of the car you would like to update: ");
				break;
			case 3: 
				System.out.print("Enter the VIN of the car you would like to remove: ");
				break;
		}
		
		vin = reader.nextLine().trim().toUpperCase();
		return vin;
	}
	
	// prompt and gather information to create a Car object from user input
	public static Car createCar(){
		String vin, make, model, color;
		int miles;
		double price;

		// create scanners for input
		Scanner stringreader = new Scanner(System.in);
		Scanner intreader = new Scanner(System.in);

		// get all input, all strings are placed in upper case for consistency
		System.out.println("Car Creation");
		System.out.println("************");
		
		// get VIN
		vin = userVin(1);
		
		// get Make
		System.out.print("Enter Make: ");
		make = stringreader.nextLine().trim().toUpperCase();
		
		// get Model
		System.out.print("Enter Model: ");
		model = stringreader.nextLine().trim().toUpperCase();
		
		// get Price
		System.out.print("Enter Price: ");
		price = intreader.nextDouble();
		
		// get Mileage
		System.out.print("Enter Mileage: ");
		miles = intreader.nextInt();
		
		// get Color
		System.out.print("Enter Color: ");
		color = stringreader.nextLine().trim().toUpperCase();
		
		// create a car object
		Car car = new Car(vin, make, model, price, miles, color);
		return car;
	}
	
	//Menu Selection 1, add a car for consideration
	public static void addCar(){
		//first, we prompt for all properties of the car
		Car c = createCar();
		//add the car to all necessary PQs
		byMiles.insert(c);
		byPrice.insert(c);
		byMakeModel.insert(c);
	}
	
	//Menu Selection 2, update a car
	public static void updateCar(){
		String vin = userVin(2); // get vin for update
		Scanner reader = new Scanner(System.in);
		// prompt for update choice
		System.out.println("Enter the number of your update selection: ");
		System.out.println("	1. Price");
		System.out.println("	2. Mileage");
		System.out.println("	3. Color");
		System.out.print(" Enter selection: ");
		int select = reader.nextInt();
		
		//go to helper function based on input
		switch(select){
			case 1:
				updateCarPrice(vin);
				break;
			case 2:
				updateCarMiles(vin);
				break;
			case 3:
				updateCarColor(vin);
				break;
		}
		return;
	}
	
	public static void updateCarPrice(String vin){
		Scanner r = new Scanner(System.in);
		System.out.print("Enter a new price: $");
		double price = r.nextDouble();
		
		// update price in all Queues
		byMiles.updatePrice(vin, price);
		byPrice.updatePrice(vin, price);
		Car temp = byMiles.getCar(vin);
		byMakeModel.updatePrice(temp, price);
		return;
	}
	public static void updateCarMiles(String vin){
		Scanner r = new Scanner(System.in);
		System.out.print("Enter a new mileage: ");
		int miles = r.nextInt();
		
		// update price in all Queues
		byMiles.updateMileage(vin, miles);
		byPrice.updateMileage(vin, miles);
		Car temp = byMiles.getCar(vin);
		byMakeModel.updateMileage(temp, miles);
		return;
	}
	public static void updateCarColor(String vin){
		Scanner r = new Scanner(System.in);
		System.out.print("Enter a new color: ");
		String color = r.nextLine().trim().toUpperCase();
		
		// update price in all Queues
		byMiles.updateColor(vin, color);	//save car that is updated 
		byPrice.updateColor(vin, color);
		Car temp = byMiles.getCar(vin);
		byMakeModel.updateColor(temp,color); 
		return;
	}
	
	//Menu Selection 3, remove a car from consideration
	public static void removeCar(){
		String vin = userVin(3); //get vin for removal
		
		//remove that vin from all queues
		byMiles.remove(vin);
		Car temp = byPrice.remove(vin); // save the removal instance
		byMakeModel.remove(temp); // use that instance to remove from the byMakeModel structure
		return;
	}
	
	//Menu Selection 4, retrieve lowest price car
	public static void lowestPrice(){
		Car lowPrice = byPrice.getMin();
		//display lowest price car information
		System.out.println("Lowest Price Car Information:");
		lowPrice.displayInfo();
		return;
	}
	
	//Menu Selection 5, retrieve lowest mileage car
	public static void lowestMileage(){
		Car lowMiles = byMiles.getMin(); // retrieve lowest mileage car
		// display lowest mileage car information
		System.out.println("Lowest Mileage Car Information:");
		lowMiles.displayInfo();
		return;
	}
	
	//Menu Selection 6, retrieve lowest price car by make/model
	public static void lowestPriceMakeModel(){
		String make, model;
		System.out.println("*******************************");
		System.out.println("Low Price Search by Make/Model:");
		Scanner reader = new Scanner(System.in);
		//prompt for make
		System.out.print("Make: ");
		make = reader.nextLine().trim().toUpperCase();
		//prompt for model
		System.out.print("Model: ");
		model = reader.nextLine().trim().toUpperCase();
		
		//get car 
		Car result = byMakeModel.getLowestPrice(make, model);
		result.displayInfo();
		return;
	}
	
	//Menu Selection 7, retrieve lowest mileage car by make/model
	public static void lowestMileageMakeModel(){
		String make, model;
		System.out.println("*********************************");
		System.out.println("Low Mileage Search by Make/Model:");
		Scanner reader = new Scanner(System.in);
		//prompt for make
		System.out.print("Make: ");
		make = reader.nextLine().trim().toUpperCase();
		//prompt for model
		System.out.print("Model: ");
		model = reader.nextLine().trim().toUpperCase();
		
		//get car 
		Car result = byMakeModel.getLowestMileage(make, model);
		if(result == null) {
			System.out.println("NO INFORMATION AVAILABLE");
			return;
		}
		result.displayInfo();
		return;
	}
		
  public static void main(String[] args){
		byMiles = new MileageQ();	// initialize the PQ to sort by Mileage
		byPrice = new PriceQ();		// initialize PQ for sorting prices
		byMakeModel = new MakeModelQ(); // initialize PQ for sorting both prices and mileage by make/model
		int choice;
		System.out.println("**********************************************************************");
		System.out.println("Welcome to Select-A-Car! Please enter a numeric option from the menu: ");
		displayMenu();
		choice = prompt();
		while(choice != -1){
			directUser(choice);
			System.out.println("**********************************************************************");
			displayMenu();
			choice = prompt();
		}
	}
}
