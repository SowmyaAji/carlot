// CarLotTesterClass
// Write a tester class CarLotTester that verifies that your CarLot class is working properly.  CarLotTester should contain a main method. Specifically, your tester class should:
// Test that the addCar() and sellCar() methods work as expected
// Verify that the accessor methods work as expected by creating a CarLot  with an inventory of at least 2 Cars. Your code should call the appropriate accessor and if the correct Car is not returned, print an error message on the Console 
// Hints
// If you did not complete successfully complete all parts of the Car class from Step 1, finish that before starting Step 2
// In Step 1 of the project, you implement several "compareTo" methods. Use those methods when implementing some of the accessor methods
// The getCarsSortedByMPG() will require sorting the ArrayList.  Modify the selection sort from Unit 7 to work with Cars and use the appropriate "compareTo" from Step 1
// Grading Elements
// The submission contains Car, CarLot, and CarLotTester.  CarTester is ideally provided but is not required
// CarLot contains a single ArrayList<Car> attribute named inventory
// All CarLot accessor and mutator methods are implemented exactly as defined in the JavaDoc
// CarLotTester runs successfully
// CarLotTester prints an error message in the event a test fails

// Enhance the CarLotTester class to test the saveToDisk() and loadFromDisk() methods


import java.util.ArrayList;
import java.io.IOException;

public class CarLotTester {

    public static void main(String[] args){

         // create two car instances with all fields
         Car car1 = new Car("2010 Kia Soul", 12005, 12, 12000.00, 13000.00);
         Car car2 = new Car("2012 Ford Focus",25032, 28, 12500.00, 13000.00);
         // test the empty constructor and the setters
         Car car3 = new Car();
         car3.setID("2013 Chevrolet Camaro");
         car3.setMPG(30);
         car3.setMileage(25000);
         car3.setCost(10000);
         car3.setSalesPrice(11000);


         // create arraylist to add cars
         ArrayList<Car> addCars = new ArrayList<>();
         addCars.add(car1);
         addCars.add(car2);
         addCars.add(car3);

         // create carlot instance and add the arraylist to the inventory variable
         CarLot carLotOne = new CarLot();
         
         // test setInventory function; 
         carLotOne.setInventory(addCars);

         // test add car function;
         carLotOne.addCar("2011 Acura TL", 16000, 24, 7800, 9000);

         // test saveToDisk function;
         try{
            carLotOne.saveToDisk();
         }
         catch(IOException e){
             System.out.println(e.getStackTrace());
         }
         

         // test loadToDisk function
         try{
             carLotOne.loadFromDisk();
         }
         catch(Exception e){
             System.out.println(e.getMessage());
         }

         System.out.println();
         System.out.println("1. Cars in order of entry: " + carLotOne.getCarsInOrderOfEntry());
         System.out.println("2. Sort cars by MPG lowest to highest: " + carLotOne.getCarsSortedByMPG());
         System.out.println("3. Car with best MPG is: " + carLotOne.getCarWithBestMPG());
         System.out.println("4. Car with highest mileage is: " + carLotOne.getCarWithHighestMileage());
         System.out.println("5. Average MPG of the cars in the car lot: " + carLotOne.getAverageMpg());
         
         // test sell car function;
         carLotOne.sellCar("2011 Acura TL", 10000);
         System.out.println("Total profit from cars sold in the car lot: " + carLotOne.getTotalProfit());

         // test the error thrown when a car with a wrong identifier is sold
         carLotOne.sellCar("Random car", 15000);
    }
    
}
