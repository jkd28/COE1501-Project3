# Car-buyer Assistant
This project was an assignment for Algorithm Implementation at the University of Pittsburgh.  The assignment was to create an application to help a user select a car to buy.  The application did not have a GUI and would instead run in the terminal.
In order to complete this assignment, I was required to implement an Indexable Priority Queue.

There were several requirements for the performance/efficiency of certain operations as well.  This ensured that the PQ was implemented with a heap using indirection.

## Overall Runtimes for Operations:
In all cases, n is the number of cars in the structure:  

	BY MILEAGE/PRICE
	Insert:  O(logn)
	Remove:  O(logn)
	Update:  O(1)
	findMin: O(1)

	BY MAKE/MODEL
	Insert:  O(logn)
	Remove:  O(logn)
	Update:  O(1)
	findMin: O(1)

## Space Complexity:
**2n** :for the MileageQ and PriceQ  
**2n** :for the implementatin of MakeModelQ, which uses many MileageQ and PriceQ    
**2n** :for each indirection data structure to hold hashes to indexes in MileageQ/PriceQ  
**2n** :for each the indirection structures in MakeModelQ

**TOTAL SPACE COMPLEXITY:**  
O(2n + 2n + 2n + 2n) = O(8n) = O(n)

## Implementation of Queues  
I decided that two separate queues would be preferable to gather the information/sort the values appropriately.  This means that each Car object
is stored at least twice, once in a MileageQ (PQ for mileage of a car) and once in a PriceQ (PQ for price of a car).  I chose to do this because
it was the most straightfoward way I could think of to approach the problem of sorting/prioritizing based on two separate values.

MileageQ and PriceQ are implemented exactly the same as each other, with a few changes to individual methods in order to keep each functioning
to the purpose of the class. The Queues work by implementing an array-based heap as discussed in lecture.  This was the most efficient way for
me to implement the heap structure, and also was the most familiar to me.

__Insert:__ Add the object to the last point of the heap array (constant-time) and swim the value up as necessary (logarithmic-time).

__Remove:__ Hash vin to get index of removed item (constant-time), swap it with the last added value (constant-time), and sink the swapped value
	down as necessary (logarithmic-time).

__Update:__ Hash vin to get index of item to update (constant-time), update the car object as necessary (constant-time).

__GetMinimum:__ Return the first value in the heap array (constant-time).

## Implementation of Indirection
I chose to use a HashMap of VIN to Index in Heap Array.  This implementation ensured a low chance of collisions due to uniqueness of VINs.  This implementation also meant that reaching the index of a certain VIN is a constant-time operation, as the **hash function is linear in terms of the VIN (O(n) where n is the length of the VIN)**, but that is a constant number of 17.  This allows us to hash in linear time with regard to the rest of the program. Based on my research of the topic, hashcodes for a given string are then cached and retrieval of the code is **O(1)** in the future. These performances allowed me to justify my use of the Java HashMap Library in my project.

The ease of implementation for Java's HashMap object was another large reason for my use of it.  Using an object that was already built and well-documented reduced my engineering effort to a minimal level. I was then able to focus on other parts of the project without having to "reinvent the wheel". Using these constant time operations and minimal engineering-effort objects, I was able to keep my inserts, updates, and removals at logarithmic time for my Queues.  

## Implementation of Sort by Make/Model:
I decided to implement this part of the project using the Java HashMap Library again, this time hashing a combination of strings Make and Model to a Priority Queue. This implementation required me to keep two separate HashMaps (one for mileage, one for price).  This doubled the space complexity of my program. Through this hashing implementation, I was able to keep track of the lowest mileage/price for any given make/model combination with the same time complexity as MileageQ and PriceQ.

This allows me to get the lowest price or mileage for a make/model combination in constant time, since hashing is constant time and retrieval from the queue is constant time as I discussed above.

__Inserts:__ logarithmic-time, as there is only the addition of constant time hashing to reach the queue we are inserting to.

__Removal:__ logarithmic-time since it takes the removed Car from one of the other queues.  This allows me to retrieve and hash the	make/model in
constant-time and remove from the proper queue in logarithmic-time.  

__Updates:__ constant-time since it takes a Car object, extracts make/model info in constant time, then gets the queues in which that car is stored in constant time, then performs the update operation on those two queues, which is constant time with a multiplicative constant of 2. We can ignore this constant in asymptotic runtimes.

__Minimum:__ constant-time, as we hash the make+model combination in constant-time and then return the value from the getMin operation in the queue, which is constant-time as well.

## Submission Comments
Though my space complexity was not ideal, I was able to minimize runtimes to the required amounts as well as reduce the necessary engineering effort to an acceptable and realistic amount.  I am sure that given more time I could find a solution to reduce my practical space complexity by some degree, though asymptotically I am happy with the result.
