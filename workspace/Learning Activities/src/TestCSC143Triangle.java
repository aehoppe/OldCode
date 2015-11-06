import static org.junit.Assert.*;
import org.junit.*;

/**
 * This class is a JUnit test case for the CSC143Triangle class
 * @author Alexander Hoppe
 * @version Apr 15, 2015
 */
public class TestCSC143Triangle {

    //fields
    /**
     * This holds the CSC143Triangle object that the tests will be run on
     */
    private CSC143Triangle t;
    
    //test methods
    /**
     * This method sets up the CSC143Triangle object for each test method
     */
    @Before
    public void setup() {
        t = new CSC143Triangle(5, 5);
    }
    
    /**
     * This method tests the constructor for a normal case
     */
    @Test
    public void constructorTest1() {
        new CSC143Triangle(5, 5);
    }
    
    /**
     * This method tests the constructor for a lower exception case in base and 
     * a normal case in height
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorTest2() {
        new CSC143Triangle(-1, 5);
    }
    
    /**
     * This method tests the constructor for a lower boundary case in base and 
     * a normal case in height
     */
    @Test
    public void constructorTest3() {
        new CSC143Triangle(0, 5);
    }
    
    /**
     * This method tests the constructor for an upper boundary case in base and 
     * a normal case in height
     */
    @Test
    public void constructorTest4() {
        new CSC143Triangle(1000, 5);
    }
    
    /**
     * This method tests the constructor for an upper exception case in base and 
     * a normal case in height
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorTest5() {
        new CSC143Triangle(1001, 5);
    }
    
    /**
     * This method tests the constructor for a normal case in base and a lower 
     * exception case in height
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorTest6() {
        new CSC143Triangle(5, -1);
    }
    
    /**
     * This method tests the constructor for a normal case in base and a lower 
     * boundary case in height
     */
    @Test
    public void constructorTest7() {
        new CSC143Triangle(5, 0);
    }
    
    /**
     * This method tests the constructor for a normal case in base and an upper 
     * boundary case in height
     */
    @Test
    public void constructorTest8() {
        new CSC143Triangle(5, 1000);
    }
    
    /**
     * This method tests the constructor for a normal case in base and an upper 
     * exception case in height
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorTest9() {
        new CSC143Triangle(5, 1001);
    }
    
    /**
     * This method tests the getHeight method, it should return 10
     */
    @Test
    public void testGetHeight() {
        assertEquals("Returned incorrect height", 5, t.getHeight());
    }
    
    /**
     * This method tests the getBase method, it should return 10
     */
    @Test
    public void testGetBase() {
        assertEquals("Returned incorrect base", 5, t.getBase());
    }

    /**
     * This method tests the getArea method, it should return 50, with a delta 
     * of 0.000000001 (10E-10)
     */
    @Test
    public void testGetArea() {
        assertEquals("Returned incorrect area", 12.5, t.getArea(), 0.000000001);
    }

}
