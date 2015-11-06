import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This JUnit test case tests the functionality of the Roots.sqrt() method
 * This method has a lower boundary at zero, as negative numbers do not have real 
 * square roots. 
 * @author Alexander Hoppe
 * @version Apr 18, 2015
 */
public class TestSqrt {
    
    //No need for fields

    //Test cases
    /**
     * This method tests the boundary condition at zero
     */
    @Test
    public void boundaryAt_0() {
        assertEquals("Wrong Answer", 0, Roots.sqrt(0), 0.00000001);
    }
    
    /**
     * This method tests the exception for negative numbers
     */
    @Test (expected = IllegalArgumentException.class)
    public void exceptionAt_minus1() {
        Roots.sqrt(-1);
    }
    
    /**
     * This method tests the NonConvergenceException over 1e58
     */
    @Test (expected = NonConvergenceException.class)
    public void exceptionAbove_1e58() {
        Roots.sqrt(1e59);
    }
    
    /**
     * This method tests a normal case, sqrt 1, expects 1
     */
    @Test
    public void standardCase1() {
        assertEquals("Incorrect square root of 1", 1, Roots.sqrt(1), 1e-8);
    }
    
    /**
     * This method tests a normal case, sqrt 900, expects 30
     */
    @Test
    public void standardCase2() {
        assertEquals("Incorrect square root of 900", 30, Roots.sqrt(900), 1e-7);
    }
    
    /**
     * This method tests a normal case, sqrt 4,000,000, expects 2000
     */
    @Test
    public void standardCase3() {
        assertEquals("Incorrect square root of 4 million", 2000, Roots.sqrt(4000000), 1e-5);
    }
    
    /**
     * This method tests a normal case, sqrt 45.96, expects 6.77938050
     */
    @Test
    public void standardCase4() {
        assertEquals("Incorrect square root of 45.96", 6.77938050, Roots.sqrt(45.96), 1e-8);
    }
    
    /**
     * This method tests a normal case, sqrt 77, expects 8.77496438
     */
    @Test
    public void standardCase5() {
        assertEquals("Incorrect square root of 77", 8.77496438, Roots.sqrt(77), 1e-8);
    }
    
    /**
     * This method tests a normal case, sqrt 965, expects 31.0644491
     */
    @Test
    public void standardCase6() {
        assertEquals("Incorrect square root of 965", 31.0644491, Roots.sqrt(965), 1e-7);
    }
    
}
