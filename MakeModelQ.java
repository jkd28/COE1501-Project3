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
	
	Updates will also be in logarithmic time since it takes a Car object, extracts make/model info
	in constant time, then gets the queues in which that car is stored in constant time, then performs
	the update operation on those two queues, which is logarithmic time with a multiplicative constant 
	of 2. We can ignore this constant in assymptotic runtimes.
*/
import java.util.HashMap;
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
		//make a seperate car object
		Car car2 = new Car(car.getVIN(), car.getMake(), car.getModel(), car.getPrice(), car.getMileage(), car.getColor());
		insertMiles(car);
		insertPrice(car2); //using 2 seperate objects avoids an error with referencing the same car from both structures
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
	
	// updates a car's mileage in appropriate queue within either hashmap 
	public void updateMileage(Car car, int newMileageVal){
		if(car == null) return; //check for existence of car
		
		String key = car.getMake()+car.getModel(); //get the hash key
		//get appropriate queues
		MileageQ 	m = mileage.get(key);
		PriceQ		p = price.get(key);
		
		//update car in both hashmaps
		m.updateMileage(car.getVIN(), newMileageVal);
		p.updateMileage(car.getVIN(), newMileageVal);
		mileage.put(key,m);
		price.put(key,p);
	}
	// updates a car's price in appropriate queue within either hashmap
	public void updatePrice(Car car, double newPriceVal){
		if(car == null) return; //check for existence of car
		
		String key = car.getMake()+car.getModel(); //get the hash key
		//get appropriate queues
		MileageQ 	m = mileage.get(key);
		PriceQ		p = price.get(key);
		
		//update car in both hashmaps
		m.updatePrice(car.getVIN(), newPriceVal);
		p.updatePrice(car.getVIN(), newPriceVal);
		mileage.put(key,m);
		price.put(key,p);
	}	
	// updates a car's color in appropriate queue within either hashmap
	public void updateColor(Car car, String color){
		if(car == null) return; //check for existence of car
		
		String key = car.getMake()+car.getModel(); //get the hash key
		//get appropriate queues
		MileageQ 	m = mileage.get(key);
		PriceQ		p = price.get(key);
		
		//update car in both hashmaps
		m.updateColor(car.getVIN(), color);
		p.updateColor(car.getVIN(), color);
		mileage.put(key,m);
		price.put(key,p);
	}
	
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