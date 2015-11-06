package homework_4;
/**
 * A class representing an order to be made at a fish truck.
 * Orders are immutable.
 * @author Alexander Hoppe
 * @version 10/22/14
 */

public class Order {
    //constants
    /**
     * This is the price of a two piece order
     */
    public final double twoPiecePrice = 8.95;
    
    /**
     * This is the price of a three piece order
     */
    public final double threePiecePrice = 12.75;
    
    /**
     * This is the price of an order of coleslaw
     */
    public final double coleSlawPrice = 2.50;
    
    /**
     * This is the price of a soda
     */
    public final double sodaPrice = 1.50;
    
    /**
     * This is the price of a Combo #1
     */
    public final double combo1Price = .9 * (twoPiecePrice + sodaPrice);
    
    /**
     * This is the price of a Combo #2
     */
    public final double combo2Price = .9 * (threePiecePrice + coleSlawPrice +
            (sodaPrice * 2));
    
    //fields
    /**
     * The number of two-piece meals in this order
     */
    private int twoPieceCount;
    
    /**
     * The number of three-piece meals in this order
     */
    private int threePieceCount;
    
    /**
     * The number of coleslaw servings in this order
     */
    private int coleSlawCount;
    
    /**
     * The number of sodas in this order
     */
    private int sodaCount;
    
    /**
     * The price of this order
     */    
    private double price;
    
    /**
     * Whether or not this order is a combo (10% discount)
     */
    private boolean isCombo;
    
    //constructors
    /**
     * This method initializes all fields to zero, and is called by the constructors
     */
    public void init(){
        twoPieceCount = 0;
        threePieceCount = 0;
        coleSlawCount = 0;
        sodaCount = 0;
        price = 0;
        isCombo = false;
    }
    
    /**
     * This constructor initializes a new Order object with the default order, 
     * 1 two-piece combo and 1 soda. It is a combo.
     */
    public Order(){
        init();
        twoPieceCount = 1;
        sodaCount = 1;
        price = combo1Price;
        isCombo = true;
    }
    
    /**
     * This constructor initializes a new Order with the specified number of combos
     * of either type. It is a combo, so it gets the discount. 
     * 
     * precondition: inputs are nonnegative
     * @throws IllegalArgumentException if inputs are negative
     */
    public Order(int combo1Count, int combo2Count){
        init();
        if (combo1Count < 0 || combo2Count < 0)
            throw new IllegalArgumentException("Inputs must not be negative");
        twoPieceCount = combo1Count;
        threePieceCount = combo2Count;
        sodaCount = combo1Count + 2 * combo2Count;
        coleSlawCount = combo2Count;
        isCombo = true;
        price = combo1Count * combo1Price + combo2Count * combo2Price;
    }
    
    /**
     * This constructor initializes a new Order with the specified items
     * @param twoPieceCount The number of two-piece meals
     * @param threePieceCount The number of three-piece meals
     * @param coleSlawCount The number of coleslaw orders
     * @param sodaCount The number of sodas
     * @throws IllegalArgumentException if arguments are negative
     */
    public Order(int twoPieceCount, int threePieceCount, int coleSlawCount, 
            int sodaCount){
        if (twoPieceCount < 0 || threePieceCount < 0 || coleSlawCount < 0 || sodaCount < 0)
            throw new IllegalArgumentException("Inputs must not be negative");
        this.twoPieceCount = twoPieceCount;
        this.threePieceCount = threePieceCount;
        this.coleSlawCount = coleSlawCount;
        this.sodaCount = sodaCount;
        price = this.getPrice();

    }
    
    //accessor methods
    /**
     * This method gets the count of two piece meals in this Order
     * @return A nonnegative integer
     */
    public int get2PieceCount(){
        return twoPieceCount;
    }
    
    /**
     * This method returns the number of three piece meals in this Order
     * @return A nonnegative integer
     */
    public int get3PieceCount(){
        return threePieceCount;
    }
    
    /**
     * This method returns the number of coleslaw meals in this Order
     * @return A nonnegative integer
     */
    public int getColeSlawCount(){
        return coleSlawCount;
    }
    
    /**
     * This method returns the number of sodas in this Order
     * @return a nonnegative integer
     */
    public int getSodaCount(){
        return sodaCount;
    }
    
    /**
     * This method returns whether or not this order is a combo
     * @return A boolean
     */
    public boolean isCombo(){
        return isCombo;
    }
    
    /**
     * This method returns the price of the order
     * @return A nonnegative double
     */
    public double getPrice(){
        return twoPieceCount * twoPiecePrice + threePieceCount * threePieceCount +
                coleSlawCount * coleSlawPrice + sodaCount * sodaPrice;
    }
    
    /**
     * This is a subsidiary method of the test method, it prints out this object's state
     */
    public void orderPrint(){
        System.out.println("Number of two-piece combos " + twoPieceCount);
        System.out.println("Number of three-piece combos " + threePieceCount);
        System.out.println("Number of coleslaws " + coleSlawCount);
        System.out.println("Number of sodas " + sodaCount);
        System.out.println("Is it a combo? " + isCombo);
        System.out.printf("This order costs $%-5.2f \n", this.price);
        System.out.println();
    }
    
    /**
     * This method constructs an object and then prints out its fields to see if 
     * it behaves properly. 
     */
    public static void test(){
        System.out.println("Default");
        Order o = new Order();
        o.orderPrint();
        System.out.println("Combo constructor");
        Order p = new Order(3, 4);
        p.orderPrint();
        System.out.println("Custom Order");
        Order q = new Order(1, 2, 4, 2);
        q.orderPrint();
        System.out.println("Trying to initialize an order with negative values:");
        try{
            Order a = new Order(-1, -1, -1, -1);
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException:" + e.getMessage());
        }
        
    }

}
