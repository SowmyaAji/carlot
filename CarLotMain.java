// The attached Java Doc is to be used as a reference if needed.  All the specifications for Step 3 are listed below. If there is a conflict between the Java Doc and blackboard contact me.
// In Programming Lab 5D, you implemented a simple menu system. In Step 3 of the CarLot Project, you will use this code as the foundation of your main CarLotMain application.
// The CarLotMain Class
// Using the menu system in Lab 5D, build the main user interface to the CarLot system in the class CarLotMain.  
// Note: The JavaDoc supplied in Step 1 of the project also has doc for CarLotMain
// Requirements
// Option 1 - Add a car to inventory. The following attributes are required for all cars:
// Identifier. This must be a String that describes the car
// Mileage. The current mileage on the car
// MPG. The Car's MPG rating
// Cost. The amount that the dealer paid for the car
// Sales Price.  The asking price for the Car
// Option 2 - Sell a car from inventory.  Selling a car requires the ID of the car and the actual price for the car, not the asking price
// Option 3 - Print a listing of all cars in the inventory, ordered by when they were acquired. 
// Option 4 - Print a listing of all cars in the inventory, sorted from highest MPG to lowest MPG
// Option 5 - Display the car in the inventory with the highest MPG
// Option 6 - Display the car in the inventory that has the highest mileage.
// Option 7 - Calculate the average MPG for all cars in the inventory.
// Option 8 - Display the total profit for all cars in the inventory that are sold.
// Hints
// All inputs should be collected from the CarLotMain class. The Car and CarLot classes should not do Console input
// The CarLot class should do most of the work
// Your menu may look something like this:
// [0] Exit
// [1] Add a car to inventory
// [2] Sell a car from inventory
// [3] List inventory by order of acquisition
// [4] List Inventory From Best MPG to Worst MPG
// [5] Display car with best MPG
// [6] Display car with the highest mileage
// [7] Display overall MPG for the entire inventory
// [8] Display profit for all sold cars
// Enter a number from 0 to 8 : 
// Grading Elements
// All eight options are listed in the menu
// All eight options work correctly
// CarLotMain reads any required input and prints application output
// All required classes are submitted in a single zip file.
// Add two additional menu items, "Save to Disk" and "Load from Disk" to the CarLotMain class

import java.util.Scanner;
import java.util.Collections;
import java.io.IOException;
import java.util.ArrayList;

public class CarLotMain {

    public static void main(String[] args){

        // create new carlot

        CarLot ourCarLot = new CarLot();
        // get inputs

        Scanner input = new Scanner(System.in);
        String prompt ="[0] Exit \n[1] Add a car to inventory \n[2] Sell a car from inventory \n[3] Save To Disk \n[4] Load From Disk \n[5] List inventory by order of acquisition \n[6] List Inventory From Best MPG to Worst MPG \n[7] Display car with best MPG \n[8] Display car with the highest mileage \n[9] Display overall MPG for the entire inventory \n[10] Display profit for all sold cars \nEnter a number from 0 to 10 :";

        int option = 0;

        do{
            System.out.println(prompt);
            option = input.nextInt();

            switch(option){

                case 0: {
                    System.out.println("Exiting... Thanks for visiting our carlot! Please come again!");
                    System.exit(0);
                }
                case 1: {
                    System.out.println("Enter the car's identifier: ");
                    input.nextLine();
                    String id = input.nextLine();
                    System.out.println("Enter the current mileage on the car: ");
                    int mileage = input.nextInt();
                    System.out.println("Enter the car's MPG rating: ");
                    int MPG = input.nextInt();
                    System.out.println("Enter the cost of the car: ");
                    double cost = input.nextDouble();
                    System.out.println("Enter the asking price for the car: ");
                    double salesPrice = input.nextDouble();
                    ourCarLot.addCar(id, mileage, MPG, cost, salesPrice);
                    System.out.println("Cars in our inventory are: " + ourCarLot.getInventory());
                    break;
                }
                case 2: {
                    System.out.println("Enter the identifier for the car to be sold: ");
                    input.nextLine();
                    String id = input.nextLine();
                    System.out.println("Enter the price the car is sold at: ");
                    double priceSold = input.nextDouble();
                    try{
                        ourCarLot.sellCar(id, priceSold);
                    }
                    catch(Exception ex){
                        System.out.println("We couldn't find or sell that car. " + ex.getMessage());
                    }
                    
                    System.out.println("Cars in our inventory are: " + ourCarLot.getInventory());
                    break;
                }
                case 3: {
                    try{
                        ourCarLot.saveToDisk();
                    }
                    catch(IOException e){
                        System.out.println("Couldn't save the file: " + e.getMessage());
                    }
                    break;
                }
                case 4: {
                    try{
                        ourCarLot.loadFromDisk();
                    }
                    catch(Exception e){
                        System.out.println("Couldn't load the inventory: " + e.getMessage());
                    }
                    break;
                }
                case 5: {
                    System.out.println("Cars in the order acquired: " + ourCarLot.getCarsInOrderOfEntry());
                    break;
                }
                case 6: {
                   ArrayList sortedCars =  ourCarLot.getCarsSortedByMPG();
                   Collections.reverse(sortedCars);
                   System.out.println("Cars from the best MPG to the worst MPG: " + sortedCars); 
                   break;
                }
                case 7: {
                    System.out.println("Car with the best MPG: " + ourCarLot.getCarWithBestMPG());
                    break;
                }
                case 8: {
                    System.out.println("Car with the highest mileage: " + ourCarLot.getCarWithHighestMileage());
                    break;
                }
                case 9: {
                    System.out.println("Average MPG for all the cars in the inventory: " + ourCarLot.getAverageMpg());
                    break;
                }
                case 10: {
                    System.out.println("Profit from all the cars sold: " + ourCarLot.getTotalProfit());
                    break;
                }
            }
            System.out.println("Type 11 to reach the main menu and choose your next option.");
            option = input.nextInt();
        }
        while(option >= 0 && option <= 11);
        input.close();
    }
    
}
