import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This JUnit test case tests the functionality of the Roots.cbrt() method
 * This method has no boundary cases, but has a range in which it will converge 
 * in under 100 iterations.
 * @author Alexander Hoppe
 * @version Apr 18, 2015
 */
public class TestCbrt {

    //No need for fields
    
    //Test methods
    /**
     * This method tests the lower range NonConvergenceException past -1e26
     */
    @Test (expected = NonConvergenceException.class)
    public void exceptionBelow_minus1e26() {
        Roots.cbrt(-1e27);
    }
    
    /**
     * This method tests the upper range NonConvergenceException, past 1e26
     */
    @Test (expected = NonConvergenceException.class)
    public void exceptionAbove_1e26() {
        Roots.cbrt(1e27);
    }
    
    /**
     * This method tests a standard case, cbrt 0, expects 0
     */
    @Test
    public void standardCase1() {
        assertEquals("Incorrect cube root of 0", 0, Roots.cbrt(0), 1e-8);
    }
    
    /**
     * This method tests a standard case, cbrt 8, expects 2
     */
    @Test
    public void standardCase2() {
        assertEquals("Incorrect cube root of 8", 2, Roots.cbrt(8), 1e-8);
    }
    
    /**
     * This method tests a standard case, cbrt 125000, expects 50
     */
    @Test
    public void standardCase3() {
        assertEquals("Incorrect cube root of 125000", 50, Roots.cbrt(125000), 1e-7);
    }
    
    /**
     * This method tests a standard case, cbrt 9874.3, expects 21.4536951
     */
    @Test
    public void standardCase4() {
        assertEquals("Incorrect cube root of 9874.3", 21.4536951, Roots.cbrt(9874.3), 1e-7);
    }
    
    /**
     * This method tests a standard case, cbrt 57, expects 3.84850113
     */
    @Test
    public void standardCase5() {
        assertEquals("Incorrect cube root of 57", 3.84850113, Roots.cbrt(57), 1e-8);
    }
    
    /**
     * This method tests a standard case, cbrt 27 billion, expects 3000
     */
    @Test
    public void standardCase6() {
        assertEquals("Incorrect cube root of 27 billion", 3000, Roots.cbrt(2.7e10), 1e-5);
    }
}
