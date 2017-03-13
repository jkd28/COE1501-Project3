/* 
	Created by: John Dott
	COE 1501
	3/13/17
*/
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
		myMake	= make;
		myModel	= model;
		myPrice = price;
		myMiles = miles;
		myColor = color;
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
	public void setVIN(String vin){
		myVIN = vin;
	}
	public void setMake(String make){
		myMake=make;
	}
	public void setModel(String model){
		myModel=model;
	}
	public void setPrice(int price){
		myPrice=price;
	}
	public void setMileage(int miles){
		myMiles=miles;
	}
	public void setColor(String color){
		 myColor=color;
	}
}