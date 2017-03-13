/* 
	Created by: John Dott
	COE 1501
	3/13/17
*/
import java.util.Scanner;
public class Car{
	// Properties of the car
	private String myVIN;
	private String myMake;
	private String myModel;
	private int myPrice;
	private int myMiles;
	private String myColor;
	
	// Constructor
	public Car(){
		createCar();
	}
	
	// prompt for car creation
	private void createCar(){
		String vin, make, model, color;
		int price, miles;
		
		// create scanners for input
		Scanner stringreader = new Scanner(System.in);
		Scanner intreader = new Scanner(System.in);
		
		// get VIN
		System.out.print("Enter VIN: ");
		vin = stringreader.nextLine();
		while(!checkVIN(vin)){
			System.out.print("\nInvalid VIN, enter valid VIN: ");
			vin = stringreader.nextLine();
		}
		// get Make
		System.out.print("\nEnter Make: ");
		make = stringreader.nextLine();
		
		// get Model
		System.out.print("\nEnter Model: ");
		model = stringreader.nextLine();
		
		// get Price
		System.out.print("\nEnter Price: ");
		price = intreader.nextInt();
		
		// get Mileage
		System.out.print("\nEnter Mileage: ");
		miles = intreader.nextInt();
		
		// get Color
		System.out.print("\nEnter Color: ");
		color = stringreader.nextLine();
		
		// set all values to instance variables
		myVIN 	= vin;
		myMake	= make;
		myModel	= model;
		myPrice	= price;
		myMiles	= miles;
		myColor	= color;
		
		return;
	}
	
	// check validity of the entered VIN
	private boolean checkVIN(String vin){
	}
	
	
	// Getters 
	public String getVIN(){
		return myVIN;
	}
	public String getMake(){
		return myMake;
	}
	public String getModel(){
		return myModel;
	}
	public int getPrice(){
		return myPrice;
	}
	public int getMileage(){
		return myMiles;
	}
	public String getColor(){
		return myColor;
	}
	
	// Setters
	public void setPrice(int price){
		myPrice=price;
		return;
	}
	public void setMileage(int miles){
		myMiles=miles;
		return;
	}
	public void setColor(String color){
		 myColor=color;
		 return;
	}
}