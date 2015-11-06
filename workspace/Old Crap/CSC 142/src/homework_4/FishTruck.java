package homework_4;
/**
 * This class represents a fish truck and it processes instances of the Order
 * class, updating its inventory and revenue accordingly.
 * @author Alexander Hoppe
 * @version 10/22/14
 */
public class FishTruck {
    
    //fields
    
    /**
     * This is the number of pieces of fish left in the truck
     */
    private int fishCount;
    
    /**
     * This is the number of containers of tartar sauce left
     */
    private int sauceCount;
    
    /**
     * This is the number of paper sacks left
     */
    private int sackCount;
    
    /**
     * This is the amount of coleslaw left over in cups
     */
    private int coleSlawCups;
    
    /**
     * This is the number of coleslaw bowls left over
     */
    private int bowlCount;
    
    /**
     * This is the amount of soda left in ounces
     */
    private int sodaCount;
    
    /**
     * This is the number of soda cups left. 
     */
    private int cupCount;
    
    /**
     * This is the number of transactions that have been made
     */
    private int transactionCount;
    
    /**
     * This is the total revenue of the fish truck
     */
    private double totalSales;
    
    //constructors
    
    /**
     * This constructor initializes a new fish truck to its default state (fully stocked)
     */
    public FishTruck(){
        fishCount = 500;
        sauceCount = 200;
        sackCount = 250;
        coleSlawCups = 320;
        bowlCount = 320;
        sodaCount = 600;
        cupCount = 75; 
        transactionCount = 0;
        totalSales = 0;
    }
    
    //accessor methods
    
    /**
     * This method returns the total sales for the fish truck
     * @return a nonnegative double
     */
    public double getTotalSales(){
        return totalSales;
    }
    
    /**
     * This method returns the average purchase price of each order for this truck
     * @return a nonnegative double
     */
    public double getAveCost(){
        return totalSales / transactionCount;
    }
    
    /**
     * This method returns the number of pieces of fish left in the truck
     * @return a nonnegative integer
     */
    public int getFishCount(){
        return fishCount;
    }
    
    /**
     * This method returns the number of tartar sauce cups left
     * @return a nonnegative integer
     */
    public int getSauceCount(){
        return sauceCount;
    }
    
    /**
     * This method returns the number of paper sacks left
     * @return a nonnegative integer
     */
    public int getSackCount(){
        return sackCount;
    }
    
    /**
     * This method returns the amount of coleslaw left in the truck in cups
     * @return a nonnegative integer
     */
    public int getColeSlawCups(){
        return coleSlawCups;
    }
    
    /**
     * This method returns the number of coleslaw bowls left
     * @return a nonnegative integer
     */
    public int getBowlCount(){
        return bowlCount;
    }
    
    /**
     * This method returns the amount of soda left in the truck in ounces
     * @return a nonnegative integer
     */
    public int getSodaCount(){
        return sodaCount;
    }
    
    /**
     * This method returns the number of soda cups left in the truck
     * @return a nonnegative integer
     */
    public int getCupCount(){
        return cupCount;
    }
    
    /**
     * This method returns a String that has the inventory of the fish truck
     * @returns a string representation of this object
     */
    public String toString(){
        return "Total Sales: " + getTotalSales() + "\nAverage Sale: " 
                + getAveCost() + "\nInventory:\nFish: " + getFishCount()
                + "\nTartar Sauce: " + getSauceCount() + "\nPaper Sacks: " 
                + getSackCount() + "\nCole Slaw: " + getColeSlawCups()
                + " cups\nColeslaw Bowls: " + getBowlCount() + "\nSoda: " 
                + getSodaCount() + " oz.\nSoda Cups: " + getCupCount();
    }
    
    
    /**
     * This method tests the FishTruck object by printing its state, then
     * updating it and printing its state again
     */
    public static void test(){
        Order test = new Order(1, 2, 3, 3);
        FishTruck skippiesFish = new FishTruck();
        System.out.println("Initial state:");
        System.out.println();
        System.out.println(skippiesFish.toString());
        System.out.println("\n");
        System.out.println("Updated state:");
        System.out.println();
        skippiesFish.processOrder(test);
        System.out.println(skippiesFish.toString());
        System.out.println("\n");
        System.out.println("Should throw an exception here:");
        Order tooBig = new Order(1000, 1000, 1000, 1000);
        try{
            skippiesFish.processOrder(tooBig);
        } catch (IllegalStateException e){
            System.err.println("IllegalStateException:" + e.getMessage());
        }
    }
    
    //update
    
    /**
     * This method takes an Order object as a parameter and updates the FishTruck
     * inventory accordingly. It also returns the price of the Order
     * @param o The order object passed in
     * @return The price of the order, a nonnegative double
     * @throws IllegalStateException if Order requests more than available stock
     */
    public double processOrder(Order o){
        transactionCount += 1;
        if (fishCount >= 2 * o.get2PieceCount() + 3 * o.get3PieceCount() 
                && sauceCount >= o.get2PieceCount() + 2 * o.get3PieceCount() 
                && sackCount >= o.get2PieceCount() + o.get3PieceCount()
                && coleSlawCups >= o.getColeSlawCount()
                && bowlCount >= o.getColeSlawCount()
                && sodaCount >= 8 * o.getSodaCount()
                && cupCount >= o.getSodaCount()){
        fishCount -= 2 * o.get2PieceCount() + 3 * o.get3PieceCount();
        sauceCount -= o.get2PieceCount() + 2 * o.get3PieceCount();
        sackCount -= o.get2PieceCount() + o.get3PieceCount();
        coleSlawCups -= o.getColeSlawCount();
        bowlCount -= o.getColeSlawCount();
        sodaCount -= 8 * o.getSodaCount();
        cupCount -= o.getSodaCount();
        totalSales += o.getPrice();
        } else throw new IllegalStateException("Out of Stock!");
        return o.getPrice();
    }
    
}
