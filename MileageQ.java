/*
  Created by John Dott
  3/13/17
  COE 1501: Algorithm Implementation

  This is a class that acts as a Priority Queue for the mileage of cars, with the
  least mileage having the highest priority
*/
public class MileageQ{
    private Car[] q;  // the array to store the cars we are queueing
    private int size; // stores the size of the queueing
    private int last; // the next index to be inserted to in order to maintain the heap property

    public MileageQ(){
      q = new Car[100]; // initialize new car array with arbitrary size of 100
      size = 0;
      last = 0;
    }
    
    public boolean isEmpty(){
      if (size == 0) { return true; }
      else { return false; }
    }
}
