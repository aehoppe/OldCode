import static org.junit.Assert.*;
import org.junit.*;

/**
 * This class is a JUnit test case for the CSC143Rectangle class
 * @author Alexander Hoppe
 * @version Apr 15, 2015
 */
public class TestCSC143Rectangle {

    //fields
    /**
     * This holds the CSC143Rectangle object that the tests will be run on
     */
    private CSC143Rectangle r;
    
    //test methods
    /**
     * This method sets up the CSC143Rectangle object for each test method
     */
    @Before
    public void setup() {
        r = new CSC143Rectangle(8, 10);
    }
    
    /**
     * This method tests the constructor for a normal case
     */
    @Test
    public void constructorTest1() {
        new CSC143Rectangle(5, 5);
    }
    
    /**
     * This method tests the constructor for a lower exception case in base and 
     * a normal case in height
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorTest2() {
        new CSC143Rectangle(-1, 5);
    }
    
    /**
     * This method tests the constructor for a lower boundary case in base and 
     * a normal case in height
     */
    @Test
    public void constructorTest3() {
        new CSC143Rectangle(0, 5);
    }
    
    /**
     * This method tests the constructor for an upper boundary case in base and 
     * a normal case in height
     */
    @Test
    public void constructorTest4() {
        new CSC143Rectangle(1000, 5);
    }
    
    /**
     * This method tests the constructor for an upper exception case in base and 
     * a normal case in height
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorTest5() {
        new CSC143Rectangle(1001, 5);
    }
    
    /**
     * This method tests the constructor for a normal case in base and a lower 
     * exception case in height
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorTest6() {
        new CSC143Rectangle(5, -1);
    }
    
    /**
     * This method tests the constructor for a normal case in base and a lower 
     * boundary case in height
     */
    @Test
    public void constructorTest7() {
        new CSC143Rectangle(5, 0);
    }
    
    /**
     * This method tests the constructor for a normal case in base and an upper 
     * boundary case in height
     */
    @Test
    public void constructorTest8() {
        new CSC143Rectangle(5, 1000);
    }
    
    /**
     * This method tests the constructor for a normal case in base and an upper 
     * exception case in height
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorTest9() {
        new CSC143Rectangle(5, 1001);
    }
    
    /**
     * This method tests the getHeight method, it should return 10
     */
    @Test
    public void testGetHeight() {
        assertEquals("Returned incorrect height", 8, r.getHeight());
    }
    
    /**
     * This method tests the getBase method, it should return 10
     */
    @Test
    public void testGetWidth() {
        assertEquals("Returned incorrect width", 10 , r.getWidth());
    }

    /**
     * This method tests the getArea method, it should return 100, with a delta 
     * of 0.000000001 (10E-10)
     */
    @Test
    public void testGetArea() {
        assertEquals("Returned incorrect area", 80.0, r.getArea(), 0.000000001);
    }

}
