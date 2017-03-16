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
	public Car(String vin, String make, String model, int price, int miles, String color){
		myVIN 	= vin;
		myMake 	= make;
		myModel = model;
		myPrice = price;
		myMiles = miles;
		myColor = color;
	}
	
	//constructor for TESTING	
	public Car(String vin, int miles){
		myVIN = vin;
		myMiles = miles;
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
