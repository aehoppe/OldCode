package csc143.test.data_structures;

import static org.junit.Assert.*;

import org.junit.*;

import csc143.data_structures.*;

/**
 * This class tests the functionality of the SampleBoundedStack class
 * @author Alexander Hoppe
 * @version May 3, 2015
 */
public class SampleBoundedStackTest {
    
    //fields
    /**
     * A filled SampleBoundedStack with 2 elements
     */
    SampleBoundedStack a;
    
    /**
     * A filled SampleBoundedStack with 4 elements
     */
    SampleBoundedStack b; 
    
    /**
     * An empty SampleBoundedStack with 0 elements
     */
    SampleBoundedStack e;
    
    /**
     * A SampleBoundedStack that will be partially filled, size 3 of capacity 6
     */
    SampleBoundedStack p1;
    
    /**
     * A SampleBoundedStack that will be partially filled, size 2 of capacity 7
     */
    SampleBoundedStack p2;
    
    /**
     * A SampleBoundedStack that is almost empty, size 1, capacity 2
     */
    SampleBoundedStack ae;
    
    /**
     * A SampleBoundedStack that will be almost full, size 4 of capacity 5
     */
    SampleBoundedStack af1;
    
    /**
     * A SampleBoundedStack that will be almost full, size 2 of capacity 3
     */
    SampleBoundedStack af2;
    
    /**
     * Setting up two test instances to run methods on
     */
    @Before
    public void setup() {
        a = new SampleBoundedStack(2);
        b = new SampleBoundedStack(4);
        e = new SampleBoundedStack(4);
        p1 = new SampleBoundedStack(6);
        p2 = new SampleBoundedStack(7);
        ae = new SampleBoundedStack(2);
        af1 = new SampleBoundedStack(5);
        af2 = new SampleBoundedStack(3);
        
        //filling up Queues with nonzero values
        try {
            for (int i = 1; i < 3; i++) a.push(Integer.toString(i));
            for (int i = 1; i < 5; i++) b.push(Integer.toString(i));
            for (int i = 1; i < 4; i++) p1.push(Integer.toString(i));
            for (int i = 1; i < 3; i++) p2.push(Integer.toString(i));
            ae.push(Integer.toString(1));
            for (int i = 1; i < 5; i++) af1.push(Integer.toString(i));
            for (int i = 1; i < 3; i++) af2.push(Integer.toString(i));
        } catch (TheStackIsFatAndFull exception) {}
    }

    /**
     * Testing constructor normal conditions
     */
    @Test
    public void testConstructor1() {
        SampleBoundedStack x = new SampleBoundedStack(3);
        assertEquals("improper capacity", 3, x.capacity());
    }
    
    /**
     * Testing constructor normal conditions
     */
    @Test
    public void testConstructor2() {
        SampleBoundedStack x = new SampleBoundedStack(120);
        assertEquals("improper capacity", 120, x.capacity());
    }
    
    /**
     * Testing constructor lower boundary
     */
    @Test
    public void testConstructorBoundaryAt0() {
        new SampleBoundedStack(0);
    }
    
    /**
     * Testing constructor lower exception
     */
    @Test (expected = NegativeArraySizeException.class)
    public void testConstructorNegativeException() {
        new SampleBoundedStack(-1);
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
     * Testing push boundary almost full
     * @throws TheStackIsFatAndFull
     * @throws TheStackIsSadAndLonely
     */
    @Test
    public void testPushBoundaryFull1() throws TheStackIsFatAndFull, TheStackIsSadAndLonely {
        af1.push("0");
        assertEquals("improper size", 5, af1.size());
        assertEquals("improper pushing", "0", af1.top());
    }
    
    /**
     * Testing push boundary almost full
     * @throws TheStackIsFatAndFull
     * @throws TheStackIsSadAndLonely
     */
    @Test
    public void testPushBoundaryFull2() throws TheStackIsFatAndFull, TheStackIsSadAndLonely {
        af2.push("0");
        assertEquals("improper size", 3, af2.size());
        assertEquals("improper pushing", "0", af2.top());
    }
    
    /**
     * Testing push exception full
     * @throws TheStackIsFatAndFull 
     */
    @Test (expected = TheStackIsFatAndFull.class)
    public void testPushExceptionFull1() throws TheStackIsFatAndFull {
        a.push("0");
    }
    
    /**
     * Testing push exception full
     * @throws TheStackIsFatAndFull 
     */
    @Test (expected = TheStackIsFatAndFull.class)
    public void testPushExceptionFull2() throws TheStackIsFatAndFull {
        b.push("0");
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
     * Testing isFull() normal case
     */
    @Test
    public void testIsFull1() {
        assertEquals("Incorrect fullness result", false, p1.isFull());
    }
    
    /**
     * Testing isFull() normal case
     */
    @Test
    public void testIsFull2() {
        assertEquals("Incorrect fullness result", true, a.isFull());
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
     * Testing capacity() normal functioning
     */
    @Test
    public void testCapacity1() {
        assertEquals("Incorrect capacity", 2, a.capacity());
    }

    /**
     * Testing capacity() normal functioning
     */
    @Test
    public void testCapacity2() {
        assertEquals("Incorrect capacity", 4, b.capacity());
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
