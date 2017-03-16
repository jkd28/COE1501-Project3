public class CarTracker{
  public static void main(String[] args){
    MileageQ q = new MileageQ();
    Car one = new Car();
    Car two = new Car();
    Car three = new Car();
    Car four = new Car();
    Car five = new Car();

    q.insert(one);
    q.insert(two);
    q.insert(three);
    q.insert(four);
    q.insert(five);
    
    q.printQ();
  }
}
