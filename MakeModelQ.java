/*
  Created by John Dott
  3/16/17
  COE 1501: Algorithm Implementation

  This is a class that manages two HashMaps containing Priority Queues for each unique 
	combinations of make/model that is present. 

	This allows me to get the lowest price or mileage for a make/model combination in constant 
	time, since hashing is constance time and retrieval from the queue is constant time as well. 
	
	Inserts will be logarithmic time, as there is only the addition of constant time hashing 
	to reach the queue we are inserting to. 
	
	Removal will be in logarithmic time since it takes the removed Car from one of the other 
	queues.  This allows me to hash the make/model in constant time and remove from the queue
	in which it exists in logarithmic time.  
*/
import java.util.HashMap;
import java.util.Set;
public class MakeModelQ{
	private HashMap<String, MileageQ> mileage;
	private HashMap<String, PriceQ> price;
	
	public MakeModelQ(){
		//initialize with arbitrary sizes of 100
		mileage = new HashMap<String, MileageQ>(100);
		price = new HashMap<String, PriceQ>(100);
	}
	
	//Insert a car into the proper queue
	public void insert(Car car){
		insertMiles(car);
		insertPrice(car);
		return;
	}
	private void insertMiles(Car car){
		String key = car.getMake() + car.getModel(); // combine make and model for hash key
		
		// check if the HashMap contain the given make/model combo
		if (!(mileage.containsKey(key))){
			//if not, create a MileageQ and add it to the hashmap
			MileageQ q = new MileageQ();
			q.insert(car); // insert the car into the queue
			mileage.put(key, q); //insert the queue into the hashmap under that make/model
		} else {
			//if it does exist, get the queue at that make/model key
			MileageQ q = mileage.get(key);
			q.insert(car);
			mileage.put(key, q); // place the queue with new item into the hashmap
		}
		return;
	}
	private void insertPrice(Car car){
		String key = car.getMake() + car.getModel(); // combine make and model for hash key
		
		// check if the HashMap contain the given make/model combo
		if (!(price.containsKey(key))){
			//if not, create a PriceQ and add it to the hashmap
			PriceQ q = new PriceQ();
			q.insert(car); // insert the car into the queue
			price.put(key, q); //insert the queue into the hashmap under that make/model
		} else {
			//if it does exist, get the queue at that make/model key
			PriceQ q = price.get(key);
			q.insert(car);
			price.put(key, q); // place the queue with new item into the hashmap
		}
		return;
	}
	
	// remove a car from any queue in which it is present
	public void remove(Car car){
		if(car == null) return; //if the car does not exist, do nothing
		
		String key = car.getMake()+car.getModel(); //get key
		//remove from both structures
		removeMileage(key, car.getVIN());
		removePrice(key, car.getVIN());
		return;
	}
	private void removeMileage(String key, String vin){
		MileageQ q = mileage.get(key); // retrieve the queue for the key
		q.remove(vin);	// in the queue, remove the car
		return;
	}
	private void removePrice(String key, String vin){
		PriceQ q = price.get(key);	// retrieve the queue for the key
		q.remove(vin);		// in the queue, remove the car
		return;
	}
	
	//updates a 
	//returns the minimum mileage car with a given make/model combination
	public Car getLowestMileage(String make, String model){
		String key = make+model; //generate hashing key
		MileageQ q = mileage.get(key); //get the queue at that key
		return q.getMin();		
	}
	
	//returns the lowest price car with a given make/model combination
	public Car getLowestPrice(String make, String model){
		String key = make+model; //generate hashing key
		PriceQ q = price.get(key); //get the queue at that key
		return q.getMin();		
	}
}