// The goal of this semester's project is to build software that runs the basic operations of a Car Lot.  At the heart of any business selling cars is knowing about each car in the inventory, so the first order of business is to define a Car class. 

// The Car Class
// Define a new class, Car. The Car class should meet the following specifications: 
// Attributes 
// Your Car should have the following attributes:
// ID uniquely identifies each car.  An example ID might be "1985 Ferrari 308GT", but any string is a valid identifier
// Mileage represents the number of miles the car has been driven. You can assume this value does not change 
// MPG represents the Car's fuel efficiency in miles per gallon
// Cost represents the amount the Car Lot paid for the car
// the sales price represents the amount that the Car Lot is asking to purchase this car
// Sold is true if the Car has been sold, otherwise, it is false to represent that is it available for sale
// PriceSold represents the amount that the Car actually sold for.  Remember the SalesPrice is what the Car Lot asked for the Car, but the PriceSold is what the Car Lot actually accepted
// Profit. When a car is sold, the Profit the CarLot makes on the Car is equal to the PriceSold minus the Cost of the Car
// Constructors
// Your Car class should provide 2 constructors:
// A default Constructor.
// A Constructor that is used to add a new Car to the CarLot's inventory. The constructor should take the following arguments:
// String id
// int mileage
// int mpg
// double cost
// double salesPrice
// Accessors 
// Your Car class should provide appropriate accessor methods for all of its attributes. 
// Provide a toString() method that provides a human-consumable version of the Car instance.  Your toString() method should return something along the lines of: 
// Car:    test1, Mileage:  10000, MPG  30, Sold:  Yes, Cost: $12500.00, Selling price: $17500.00, Sold For $18000.00, Profit: $5500.00
// Implement the following 3 comparison methods
// int compareMPG(Car otherCar)returns
// a negative value (exact value doesn't matter--only that it be less than zero) if the current car gets fewer miles per gallon than otherCar
// a positive number  (exact value doesn't matter--only that it be greater than zero) if the current car gets more miles per gallon than otherCar
// 0 if the two cars have exactly the same MPG (given that MPG is a double number, this will probably occur relatively infrequently)
// int compareMiles(Car otherCar) return
// a negative value (exact value doesn't matter--only that it be less than zero) if the current car has fewer miles than otherCar
// a positive number  (exact value doesn't matter--only that it be greater than zero) if the current car has more miles than otherCar
// and 0 if the two cars have exactly the same miles
// int comparePrice(Car otherCar) returns
// a negative value (exact value doesn't matter--only that it be less than zero) if the current car's price is less than the price of otherCar
// a positive number  (exact value doesn't matter--only that it be greater than zero) if the current car's price is more than the price of otherCar
// 0 if the two cars have exactly the same price
// Mutators
// The Car class should have default mutators for all attributes.
// In addition the Car class must provide a sellCar() method that takes the priceSold for a Car.  When a Car is sold, the following must happen:
// The Car is marked sold
// The priceSold attribute is updated appropriately 
// The profit is calculated 
// JavaDoc
// The attached .zip file core-javadoc.zip. Contains the JavaDoc for the Car class. Your implementation of the Car class should match the JavaDoc exactly. 



/**
 * Contains the attributes and methods applicable to each car
 */

public class Car{

    // class attributes
    private String id = "";
    private int mileage = 0;
    private int mpg = 0;
    private double cost = 0.0;
    private double salesPrice = 0.0;
    private boolean isSold = false;
    private double priceSold = 0.0;
    private double profit = 0.0;

    // no arguments constructor
    public Car(){}

    /**
     * Constructor with attributes for each individual car
     * @param id
     * @param mileage
     * @param mpg
     * @param cost
     * @param salesPrice
     */
    public Car(String id, int mileage, int mpg, double cost, double salesPrice){
        this.id = id;
        this.mileage = mileage;
        this.mpg = mpg;
        this.cost = cost;
        this.salesPrice = salesPrice;
        
    }

    
    // getters  or accessors for all the attributes
    public String getID(){
        return this.id;
    }

    public int getMileage(){
        return this.mileage;
    }

    public int getMPG(){
        return this.mpg;
    }

    public double getCost(){
        return this.cost;
    }

    public double getSalesPrice(){
        return this.salesPrice;
    }

    public double getPriceSold(){
        return this.priceSold;
    }

    // get string return for the boolean value
    public String getIsSold(){
        if(this.isSold){
            return "Yes";
        }
        else{
            return "No";
        }
    }
    
    public double getProfit(){
        return this.profit;
    }

    // to string method to represent the car
    public String toString(){
        return "Car: " + this.id + ", Mileage: " + this.mileage + ", MPG: " + this.mpg + ", Sold: " + getIsSold() + ", Cost: " + this.cost + ", Selling price: " + this.salesPrice + ", Sold For " + this.priceSold + ", Profit: " + this.profit;
    }

    // setters or mutators
    public void setID(String id){
        this.id = id;
    }

    public void setMileage(int m){
        this.mileage = m;
    }

    public void setMPG(int mpg){
        this.mpg = mpg;
    }

    public void setCost(double cost){
        this.cost = cost; 
    }

    public void setSalesPrice(double sales){
        this.salesPrice = sales;
    }

    public void sellCar(double priceSold){
        this.priceSold = priceSold;
        this.isSold = true;
        this.profit = this.priceSold - this.cost;
    }


  // comparison methods
  /**
   * Compare miles per gallon for both cars
   * @Car instance
   * @return -1 if current car has lesser miles per gallon, 1 if other car has better and 0 if they are equal
   */
    public int compareMPG(Car otherCar){
        if(this.mpg < otherCar.mpg){
            return -1;
        }
        else if(this.mpg == otherCar.mpg){
            return 0;
        }
        else{
            return 1;
        }   
    }

   /**
   * Compare mileage p for both cars
   * @Car instance
   * @return -1 if current car has lesser mileage, 1 if other car has lesser and 0 if they are equal
   */
    public int compareMiles(Car otherCar){
        if(this.mileage < otherCar.mileage){
            return -1;
        }
        else if(this.mileage == otherCar.mileage){
            return 0;
        }
        else{
            return 1;
        }   
    }

    /**
    * Compare sales price for both cars
    * @Car instance
    * @return -1 if current car has lower sales price, 1 if other car has  lower and 0 if they are equal
    */
    public int comparePrice(Car otherCar){
        if(this.salesPrice < otherCar.salesPrice){
            return -1;
        }
        else if(this.salesPrice == otherCar.salesPrice){
            return 0;
        }
        else{
            return 1;
        }   
    }

}