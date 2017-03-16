/*
	Created by: John Dott
	COE 1501: Project 3
	3/15/17
	
	This file acts as a driver for Project 3, which implements a Priority Queue with Indirection
	
*/
import java.util.Scanner;
public class CarTracker{
	MileageQ byMiles;
	
	public static void displayMenu(){
		System.out.println("**********************************************************************");
		System.out.println("Welcome to Select-A-Car! Please enter a numeric option from the menu: ");
		System.out.println("	1. Add a Car");
		System.out.println("	2. Update an Existing Car");
		System.out.println("	3. Remove a Car");
		System.out.println("	4. Retrieve Lowest PRICE Car");
		System.out.println("	5. Retrieve Lowest MILEAGE Car");
		System.out.println("	6. Retrieve Lowest PRICE Car by MAKE AND MODEL");
		System.out.println("	7. Retrieve Lowest MILEAGE Car by MAKE AND MODEL");
		System.out.println("**********************************************************************");
		return;
	}
	
	// get menu input from user and validate
	public static int prompt(){
		Scanner reader = new Scanner(System.in);
		System.out.print("Selection: ");
		int choice = reader.nextInt();
		while(choice < 1 ||	choice > 7){
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
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
		}
	}
	
	public static Car createCar(){
		String vin, make, model, color;
		int price, miles;

		// create scanners for input
		Scanner stringreader = new Scanner(System.in);
		Scanner intreader = new Scanner(System.in);

		// get all input, all strings are placed in upper case for consistency
		System.out.println("Car Creation");
		System.out.println("************");
		// get VIN
		System.out.print("Enter VIN: ");
		vin = ((stringreader.nextLine()).trim()).toUpperCase();
		// get Make
		System.out.print("\nEnter Make: ");
		make = ((stringreader.nextLine()).trim()).toUpperCase();
		// get Model
		System.out.print("\nEnter Model: ");
		model = stringreader.nextLine().trim().toUpperCase();
		// get Price
		System.out.print("\nEnter Price: ");
		price = intreader.nextInt();
		// get Mileage
		System.out.print("\nEnter Mileage: ");
		miles = intreader.nextInt();
		// get Color
		System.out.print("\nEnter Color: ");
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
		
	}
	
  public static void main(String[] args){
    /*MileageQ q = new MileageQ();
    Car one = new Car();
    Car two = new Car();
    Car three = new Car();
    Car four = new Car();
    Car five = new Car();

		Car[] cars = {one, two, three, four, five};
		//test insertion
    q.insert(one);		
    q.insert(two);
		q.insert(three);
    q.insert(four);
    q.insert(five); 
    q.printQ();
		
		//test update of indirection
  	System.out.println();
		for(Car c : cars){
			System.out.println(c.getVIN() + " : " + q.getQIndex(c.getVIN()));
		}
		
		System.out.println();
		//test removal
		q.remove(five.getVIN());
		q.printQ();
		q.remove(four.getVIN());
		q.printQ();
		
		//test update of indirection
  	System.out.println();
		for(Car c : cars){
			System.out.println(c.getVIN() + " : " + q.getQIndex(c.getVIN()));
		}*/
		byMiles = new MileageQ();	// initialize the PQ to sort by Mileage
		int choice;
		displayMenu();
		choice = prompt();
		directUser(choice);
	}
}
