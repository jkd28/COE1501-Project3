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
	private double myPrice;
	private int myMiles;
	private String myColor;

	// Constructor
	public Car(String vin, String make, String model, double price, int miles, String color){
		myVIN 	= vin;
		myMake 	= make;
		myModel = model;
		myPrice = price;
		myMiles = miles;
		myColor = color;
	}
	
	//Display the car's info in a neatly formatted way
	public void displayInfo(){
		System.out.println("	VIN: " + myVIN);
		System.out.println("	Make: " + myMake);
		System.out.println("	Model: " + myModel);
		System.out.println("	Price: $" + myPrice);
		System.out.println("	Mileage: " + myMiles);
		System.out.println("	Color: " + myColor);
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
	public double getPrice(){
		return myPrice;
	}
	public int getMileage(){
		return myMiles;
	}
	public String getColor(){
		return myColor;
	}

	// Setters
	public void setPrice(double price){
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
