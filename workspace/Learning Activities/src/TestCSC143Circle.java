import org.junit.*;
import static org.junit.Assert.*;

/**
 * This class is a JUnit test case for the CSC143Circle class
 * @author Alexander Hoppe
 * @version Apr 15, 2015
 */
public class TestCSC143Circle {

    //fields
    /**
     * This is the CSC143Circle object we use to test in each method.
     */
    private CSC143Circle c;
    
    //test methods
    /**
     * This method constructs a CSC143Circle object for the test methods, 
     * with dimensions of five
     */
    @Before
    public void setup() {
        c = new CSC143Circle(5);
    }
    
    /**
     * This method tests the lower bound exception for the constructor, 
     * it should throw an exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorTest1() {
        new CSC143Circle(-1);
    }
    
    /**
     * This method tests the lower boundary case for the constructor, 
     * it should not throw an exception
     */
    @Test
    public void constructorTest2() {
        new CSC143Circle(0);
    }
    
    /**
     * This method tests a normal case for the constructor, 
     * it should not throw an exception
     */
    @Test
    public void constructorTest3() {
        new CSC143Circle(10);
    }
    
    /**
     * This method tests the upper boundary case for the constructor, 
     * it should not throw an exception
     */
    @Test
    public void constructorTest4() {
        new CSC143Circle(1000);
    }
    
    /**
     * This method tests the upper bound exception for the constructor, 
     * it should throw an exception
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorTest5() {
        new CSC143Circle(1001);
    }
    
    /**
     * This method tests the getDiameter method, it should return 5
     */
    @Test
    public void diameterTest() {
        assertEquals("The getDiameter method returned the wrong value", 5, 
                c.getDiameter());
    }
    
    /**
     * This method tests the getArea method, it should return a value close enough 
     * to 19.634954085 (within .000000001)
     */
    @Test
    public void areaTest() {
        assertEquals("Returned incorrect area", 19.634954085, 
                c.getArea(), 0.000000001);
    }

}
