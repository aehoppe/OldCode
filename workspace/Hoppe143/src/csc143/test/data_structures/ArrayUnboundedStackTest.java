package csc143.test.data_structures;

import static org.junit.Assert.*;

import org.junit.*;

import csc143.data_structures.*;

/**
 * This class tests the functionality of the ArrayUnboundedStack class
 * @author Alexander Hoppe
 * @version May 3, 2015
 */
public class ArrayUnboundedStackTest {
    
    //fields
    /**
     * A ArrayUnboundedStack with 2 elements
     */
    ArrayUnboundedStack a;
    
    /**
     * A ArrayUnboundedStack with 4 elements
     */
    ArrayUnboundedStack b; 
    
    /**
     * An empty ArrayUnboundedStack with 0 elements
     */
    ArrayUnboundedStack e;
    
    /**
     * A ArrayUnboundedStack that will be partially filled, size 3
     */
    ArrayUnboundedStack p1;
    
    /**
     * A ArrayUnboundedStack that will be partially filled, size 2
     */
    ArrayUnboundedStack p2;
    
    /**
     * A ArrayUnboundedStack that is almost empty, size 1,
     */
    ArrayUnboundedStack ae;
    
    /**
     * Setting up two test instances to run methods on
     */
    @Before
    public void setup() {
        a = new ArrayUnboundedStack();
        b = new ArrayUnboundedStack();
        e = new ArrayUnboundedStack();
        p1 = new ArrayUnboundedStack();
        p2 = new ArrayUnboundedStack();
        ae = new ArrayUnboundedStack();
        
        //filling up Queues with nonzero values
            for (int i = 1; i < 3; i++) a.push(Integer.toString(i));
            for (int i = 1; i < 5; i++) b.push(Integer.toString(i));
            for (int i = 1; i < 4; i++) p1.push(Integer.toString(i));
            for (int i = 1; i < 3; i++) p2.push(Integer.toString(i));
            ae.push(Integer.toString(1));
    }

    /**
     * Testing constructor normal conditions
     */
    @Test
    public void testConstructor1() {
        new ArrayUnboundedStack();
    }
    
    /**
     * Testing push normal case
     * @throws TheStackIsFatAndFull
     * @throws TheStackIsSadAndLonely
     */
    @Test
    public void testPush1() throws TheStackIsFatAndFull, TheStackIsSadAndLonely {
        p1.push("0");
        assertEquals("improper size", 4, p1.size());
        assertEquals("improper pushing", "0", p1.top());
    }
    
    /**
     * Testing push normal case
     * @throws TheStackIsFatAndFull
     * @throws TheStackIsSadAndLonely
     */
    @Test
    public void testPush2() throws TheStackIsFatAndFull, TheStackIsSadAndLonely {
        p2.push("0");
        assertEquals("improper size", 3, p2.size());
        assertEquals("improper pushing", "0", p2.top());
    }
    
    /**
     * Testing push boundary case with empty list
     * @throws TheStackIsFatAndFull
     * @throws TheStackIsSadAndLonely
     */
    @Test
    public void testPushBoundaryEmpty() throws TheStackIsFatAndFull, TheStackIsSadAndLonely {
        e.push("0");
        assertEquals("improper pushing", "0", e.top());
    }
    
    /**
     * Testing pop() normal case
     * @throws TheStackIsSadAndLonely 
     */
    @Test
    public void testPop1() throws TheStackIsSadAndLonely {
        assertEquals("Improper pop", "3", p1.pop());
        assertEquals("improper size", 2, p1.size());
    }
    
    /**
     * Testing pop() normal case
     * @throws TheStackIsSadAndLonely 
     */
    @Test
    public void testPop2() throws TheStackIsSadAndLonely {
        assertEquals("Improper pop", "2", p2.pop());
        assertEquals("improper size", 1, p2.size());
    }
    
    /**
     * Testing pop() boundary case
     * @throws TheStackIsSadAndLonely 
     */
    @Test
    public void testPopBoundaryEmpty() throws TheStackIsSadAndLonely {
        assertEquals("Improper pop", "1", ae.pop());
        assertEquals("improper size", 0, ae.size());
    }
    
    /**
     * Testing pop() exception case
     * @throws TheStackIsSadAndLonely 
     */
    @Test (expected = TheStackIsSadAndLonely.class)
    public void testPopExceptionEmpty() throws TheStackIsSadAndLonely {
        e.pop();
    }

    /**
     * Testing top() normal case
     * @throws TheStackIsSadAndLonely
     */
    @Test
    public void testTop1() throws TheStackIsSadAndLonely {
        assertEquals("Incorrect Top", "2", a.top());
    }
    
    /**
     * Testing top() normal case
     * @throws TheStackIsSadAndLonely
     */
    @Test
    public void testTop2() throws TheStackIsSadAndLonely {
        assertEquals("Incorrect Top", "4", b.top());
    }
    
    /**
     * Testing top() boundary case
     * @throws TheStackIsSadAndLonely
     */
    @Test
    public void testTopBoundaryEmpty() throws TheStackIsSadAndLonely {
        assertEquals("Incorrect Top", "1", ae.top());
    }
    
    /**
     * Testing top() exception case
     * @throws TheStackIsSadAndLonely
     */
    @Test (expected = TheStackIsSadAndLonely.class)
    public void testTopExceptionEmpty() throws TheStackIsSadAndLonely {
        e.top();
    }

    /**
     * Testing isEmpty() normal case
     */
    @Test
    public void testIsEmpty1() {
        assertEquals("Incorrect emptiness result", false, p1.isEmpty());
    }
    
    /**
     * Testing isEmpty() normal case
     */
    @Test
    public void testIsEmpty2() {
        assertEquals("Incorrect emptiness result", true, e.isEmpty());
    }

    /**
     * Testing size() normal functioning
     */
    @Test
    public void testSize1() {
        assertEquals("Incorrect size", 2, a.size());
    }

    /**
     * Testing size() normal functioning
     */
    @Test
    public void testSize2() {
        assertEquals("Incorrect size", 4, b.size());
    }

    /**
     * Testing toString for empty queue
     */
    @Test
    public void testToString1() {
        assertEquals("Incorrect toString", "[ 0 : ]", e.toString());
    }
    
    /**
     * Testing toString normal case
     */
    @Test
    public void testToString2() {
        assertEquals("Incorrect toString", "[ 2 : 1, 2 ]", a.toString());
    }
    
    /**
     * Testing toString normal case
     */
    @Test
    public void testToString3() {
        assertEquals("Incorrect toString", "[ 4 : 1, 2, 3, 4 ]", b.toString());
    }

}
