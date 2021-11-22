// The CarTester Class
// In addition to the Car class, provide a CarTester class.  Your CarTester should have a main method that verifies that your Car class is working properly.  The CarTester class should do the following:
// Instantiate at least 2 Car objects
// Ensure that both constructors work as specified. This is especially important for the constructor used to add a new Car to the inventory
// Ensure that the sellCar() method works properly
// Test each of the Compare methods above by creating two Car objects and verifying that each possible return value (negative number, zero, or positive number) is generated as expected
// Running your CarTester class should be an easy way to determine that everything is working properly. If something in your class does NOT work as expected, you should display an error message on the Console.  
// Hints
// Eclipse will generate default accessor and mutator methods. From the package explorer, select the class, display the pop-up menu, select Source -> Generate Getters/Setters
// In addition to System.out,  Java also provides System.err, which is used to print out error messages.  System.err works identically to System.out, but the Eclipse console displays System.err text in red.  Use System.err to clearly indicate error conditions in your CarTester class or within the CarLot application.
// Grading Elements
// The submission includes two classes: Car and CarTester
// Car has the required attributes, constructors, accessors, and mutators that match the provided JavaDoc
// Car works correctly
// Only CarTester has a main method
// CarTester does not fail silently. It displays an error message if appropriate


/**
 * Tests the car objects created by the Car class
 */

public class CarTester {

    public static void main(String[] args){

        try {

            // create two car instances with all fields
            Car car1 = new Car("2010 Kia Soul",25, 1200, 12000.00, 13000.00);
            Car car2 = new Car("2012 Ford Focus",28, 1100, 12500.00, 13000.00);

            // test the empty constructor and the setters
            Car car3 = new Car();
            car3.setID("2013 Chevrolet Camaro");
            car3.setMPG(30);
            car3.setMileage(25000);
            car3.setCost(10000);
            car3.setSalesPrice(11000);

            // sell two cars
            car1.sellCar(13200.00);
            car2.sellCar(12000.00);
           

            // get all three car details through the toString() method of the car object
            System.out.println(car1);
            System.out.println(car2);
            System.out.println(car3);


            // compare car1 and car2
            System.out.println(car1.compareMPG(car2));
            System.out.println(car1.compareMiles(car2));
            System.out.println(car1.comparePrice(car2));
        }
        catch(Exception ex){
            // print out any error in the process
            System.err.println("The car objects could not be created ...: " + ex.getMessage());
        }
           
    }

    
}
