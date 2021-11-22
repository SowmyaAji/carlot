// In step 1 of the project, you created a class to represent a Car that is for sale. In step 2 of the project, you will create a CarLot class that manages all of the vehicles that are for sale.  The collection of vehicles that are for sale represent the CarLot's inventory. 
// Note: The CarLot class requires successfully implementing the Car class developed in Step 1 of the project. 
// The CarLot Class
// Define a class CarLot. Your CarLot will have a single attribute, inventory, of the type ArrayList<Car>. Provide default accessor and mutator methods for the inventory attribute.
// Accessors
// Add the following accessor methods:
// Car findCarByIdentifier(String identifier).  Find the car with the specified identifer in the inventory. Return null if the Car is not found
// ArrayList<Car> getCarsInOrderOfEntry(). Return an ArrayList of all Cars in the inventory, ordered by their entry into the inventory. This method should return a copy of the inventory, not the inventory itself
// ArrayList<Car> getCardsSortedByMPG(). Return an ArrayList of all Cars in the inventory, sorted by MPG. This method should not sort the inventory, but should instead make a copy of the inventory and sort the copy
// Car getCarWithBestMPG(). Return the Car in the inventory with the highest MPG
// Car getCarWithHighestMileage(). Return the Car in the inventory with the highest mileage
// double getAverageMpg(). Return the average MPG of all Cars in the inventory
// double getTotalProfit(). Return the total profit of all cars in the inventory that have been sold
// Mutators
// Add the following mutator methods:
// void addCar(String id, int mileage, int mpg, double cost, double salesPrice).  Add a new Car with the specified id, mileage, mpg, cost, and salesPrice to the inventory
// void sellCar(String identifier, double priceSold ) throws IllegalArgumentException. Sell the Car identified by identirier for the priceSold. If the Car does not exist in the identifier, throw an IllegalArgument Exception with an appropriate error message
// JavaDoc
// The JavaDoc supplied in Step 1 of the project also contains documentation for the CarLot class. Your implementation of the CarLot class should match the JavaDoc exactly. 
// To view the JavaDoc, you must extract all of the files from the zip archive.  After extracting the files, click on the index.html file to view the JavaDoc.
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


// The Car Lot Project Step 4: Loading/Saving CarLot Data
// After completing Step 3, your CarLot application is up and running, but it cannot save any of its data! In step 4, you will add the ability to load and save data. 
// Note: This step is NOT part of the Team Assignment and should be completed individually.  This step should not be submitted separately for grading, but instead included with your final project submission.
// Requirements
// Add the method saveToDisk() in the CarLot class.  When executed, this method should save all of the inventory data to a .txt file named "carlot.txt"
// Add the method loadFromDisk() to the CarLot class. When executed, this method should load all of the data from the file "carlot.txt"
// Enhance the CarLotTester class to test the saveToDisk() and loadFromDisk() methods
// Add two additional menu items, "Save to Disk" and "Load from Disk" to the CarLotMain class
// Include a sample carlot.txt file in your final project submission.
// Hints
// Refer to programming Lab 9A for background on reading/writing CSV files
// Grading Elements
// CarLot includes the saveToDisk() and loadFromDisk() methods. These methods work properly
// Appropriate exception handling is implemented
// The CarLotTester class has been updated to test saveToDisk() and loadFromDisk(). The tester class runs successfully
// The CarLotMain class has the "Save to Disk" and "Load from Disk" menu options. Both options work successfully
// A sample carlot.txt file is included in the lab submission

import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class CarLot {

    private ArrayList<Car> inventory = new ArrayList<>();

    public ArrayList<Car> getInventory() {
        return this.inventory;
    }

    public void setInventory(ArrayList<Car> inventory) {
        this.inventory = inventory;
    }

    // Accessors
    // Add the following accessor methods:
    // Car findCarByIdentifier(String identifier). Find the car with the specified
    // identifer in the inventory. Return null if the Car is not found

    public Car findCarByIdentifier(String identifier) {
        Car idCar = new Car();
        for (Car car : this.inventory) {
            String carID = car.getID().trim();
            String checkID = identifier.trim();
            if (carID.equals(checkID)) {
                idCar = car;
                break;
            } else {
                idCar = null;
            }
        }
        return idCar;
    }

    // ArrayList<Car> getCarsInOrderOfEntry(). Return an ArrayList of all Cars in
    // the inventory, ordered by their entry into the inventory. This method should
    // return a copy of the inventory, not the inventory itself
    public ArrayList<Car> getCarsInOrderOfEntry() {
        ArrayList<Car> entries = new ArrayList<>(this.inventory);
        return entries;
    }

    // ArrayList<Car> getCardsSortedByMPG(). Return an ArrayList of all Cars in the
    // inventory, sorted by MPG. This method should not sort the inventory, but
    // should instead make a copy of the inventory and sort the copy
    public ArrayList<Car> getCarsSortedByMPG() {
        ArrayList<Car> sortedByMPG = new ArrayList<>(this.inventory);
        selectionSort(sortedByMPG);
        return sortedByMPG;
    }


    /**
     * sort the list by lowest to highest MPG
     */
    private static void selectionSort(ArrayList<Car> sortedByMPG){
        int size = sortedByMPG.size();
        for (int i = 0; i < size - 1; i++) {
            // Find the minimum MPG among the cars
            Car lowestMPG = sortedByMPG.get(i);
            int currentMinIndex = i;

            for (int j = i + 1; j < size; j++) {
                Car two = sortedByMPG.get(j);
                int res = lowestMPG.compareMPG(two);
                if (res == 1) {
                    lowestMPG = two;
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                Car otherCar = sortedByMPG.get(currentMinIndex);
                sortedByMPG.set(currentMinIndex, sortedByMPG.get(i));
                sortedByMPG.set(i, otherCar);
            }
        }
    }

    // Car getCarWithBestMPG(). Return the Car in the inventory with the highest MPG
    public Car getCarWithBestMPG(){
        ArrayList<Car> sorted = getCarsSortedByMPG();
        return sorted.get(sorted.size()-1);
    }

    // Car getCarWithHighestMileage(). Return the Car in the inventory with the highest mileage
    public Car getCarWithHighestMileage(){
        ArrayList<Car> checkMileage = this.inventory;
        Car highestMileage = new Car();
        int highest = 0;
        for(Car car: checkMileage) {
            if(car.getMileage() > highest){
                highest = car.getMileage();
                highestMileage = car;
            } 
        }
        return highestMileage;
    }

    // double getAverageMpg(). Return the average MPG of all Cars in the inventory
    public double getAverageMpg(){
        double average = 0.0;
        int sum = 0;
        ArrayList<Car> carList = this.inventory;
        int size = carList.size();
        for(Car car: carList){
            sum+= car.getMPG();
        }
        average = sum / (double) size;
        return average;
    }

    // double getTotalProfit(). Return the total profit of all cars in the inventory that have been sold
    public double getTotalProfit(){
        double totalProfit = 0.0;
        for(Car car: this.inventory){
            if(car.getIsSold() == "Yes"){
                totalProfit += car.getProfit();
            }
        }
        return totalProfit;
    }

    // Mutators
    // Add the following mutator methods:
    // void addCar(String id, int mileage, int mpg, double cost, double salesPrice).  Add a new Car with the specified id, mileage, mpg, cost, and salesPrice to the inventory

    public void addCar(String id, int mileage, int mpg, double cost, double salesPrice){
        Car newCar = new Car(id, mileage, mpg, cost, salesPrice);
        this.inventory.add(newCar);
    }

    // void sellCar(String identifier, double priceSold ) throws IllegalArgumentException. Sell the Car identified by identirier for the priceSold. If the Car does not exist in the identifier, throw an IllegalArgument Exception with an appropriate error message


    public void sellCar(String identifier, double priceSold) throws IllegalArgumentException {
       
            Car sold = findCarByIdentifier(identifier);
            if(sold != null){
                sold.sellCar(priceSold);
            }
            else{
                throw new IllegalArgumentException("Couldn't find the car " + identifier);
            }   
         }
         
         // Add the method saveToDisk() in the CarLot class.  When executed, this method should save all of the inventory data to a .txt file named "carlot.txt"
         public void saveToDisk() throws IOException {

            File csvFile = new File("carlot.txt");
            if(csvFile.exists()){
                System.out.println("File already exists");
                System.exit(0);
            }
            System.out.println("Writing file ...");
            PrintWriter printer = new PrintWriter(csvFile);
            ArrayList<Car> cars = this.inventory;
            for(Car car : cars){
                String row = car.getID() + "," + car.getMileage() + "," + car.getMPG() + "," + car.getCost() + "," + car.getSalesPrice();
                printer.println(row);
            }
            
            printer.close();
            System.out.println("File written.");
        }

        // Add the method loadFromDisk() to the CarLot class. When executed, this method should load all of the data from the file "carlot.txt"
        public ArrayList<Car> loadFromDisk(){

            this.inventory.clear();
            try {
    
                File file = new File("carlot.txt");
                Scanner input = new Scanner(file);
                System.out.println("Reading file ....");
    
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] lineArray = line.split(",", 5);
                    String id = lineArray[0];
                    int mileage = Integer.parseInt(lineArray[1]);
                    int mpg = Integer.parseInt(lineArray[2]);
                    double cost = Double.parseDouble(lineArray[3]);
                    double salesPrice = Double.parseDouble(lineArray[4]);
                    Car car = new Car(id, mileage, mpg, cost, salesPrice);
                    this.inventory.add(car);
                }
                input.close();
    
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Finished reading ...");
            System.out.println("Inventory loaded from disk: " + this.inventory.toString());

            return this.inventory;
        }
         
         
       
}
    
