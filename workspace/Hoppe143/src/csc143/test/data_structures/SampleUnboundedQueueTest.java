package csc143.test.data_structures;

import static org.junit.Assert.*;

import org.junit.*;

import csc143.data_structures.*;

/**
 * This class tests the functionality of the SampleUnboundedQueue class
 * @author Alexander Hoppe
 * @version May 3, 2015
 */
public class SampleUnboundedQueueTest {
    
    //fields
    /**
     * A SampleUnboundedQueue with 2 elements
     */
    SampleUnboundedQueue a;
    
    /**
     * A SampleUnboundedQueue with 4 elements
     */
    SampleUnboundedQueue b; 
    
    /**
     * An empty SampleUnboundedQueue with 0 elements
     */
    SampleUnboundedQueue e;
    
    /**
     * A SampleUnboundedQueue that will be partially filled, size 3
     */
    SampleUnboundedQueue p1;
    
    /**
     * A SampleUnboundedQueue that will be partially filled, size 2
     */
    SampleUnboundedQueue p2;
    
    /**
     * A SampleUnboundedQueue that is almost empty, size 1,
     */
    SampleUnboundedQueue ae;
    

    /**
     * Setting up test instances to run methods on
     */
    @Before
    public void setup() {
        a = new SampleUnboundedQueue();
        b = new SampleUnboundedQueue();
        e = new SampleUnboundedQueue();
        p1 = new SampleUnboundedQueue();
        p2 = new SampleUnboundedQueue();
        ae = new SampleUnboundedQueue();
        
        //filling up Queues with nonzero values
            for (int i = 1; i < 3; i++) a.add(Integer.toString(i));
            for (int i = 1; i < 5; i++) b.add(Integer.toString(i));
            for (int i = 1; i < 4; i++) p1.add(Integer.toString(i));
            for (int i = 1; i < 3; i++) p2.add(Integer.toString(i));
            ae.add(Integer.toString(1));
    }

    /**
     * Testing constructor normal conditions (only one case)
     */
    @Test
    public void testConstructor1() {
        new SampleUnboundedQueue();
    }
    
    
    /**
     * Testing add normal case
     * @throws TheQueueIsDieting
     */
    @Test
    public void testAdd1() throws TheQueueIsDieting {
        p1.add("0");
        assertEquals("improper size", 4, p1.size());
        for (int i = 0; i < 3; i++) p1.remove();
        assertEquals("improper adding", "0", p1.front());
    }
    
    /**
     * Testing add normal case
     * @throws TheQueueIsDieting
     */
    @Test
    public void testAdd2() throws TheQueueIsDieting {
        p2.add("0");
        assertEquals("improper size", 3, p2.size());
        for (int i = 0; i < 2; i++) p2.remove();
        assertEquals("improper adding", "0", p2.front());
    }
    
    /**
     * Testing add boundary case with empty list
     * @throws TheQueueIsDieting
     */
    @Test
    public void testAddBoundaryEmpty() throws TheQueueIsDieting {
        e.add("0");
        assertEquals("improper size", 1, e.size());
        assertEquals("improper adding", "0", e.front());
    }
    
    /**
     * Testing remove() normal case
     * @throws TheQueueIsDieting 
     */
    @Test
    public void testRemove1() throws TheQueueIsDieting {
        assertEquals("Improper remove", "1", p1.remove());
        assertEquals("improper size", 2, p1.size());
    }
    
    /**
     * Testing remove() normal case
     * @throws TheQueueIsDieting 
     */
    @Test
    public void testRemove2() throws TheQueueIsDieting {
        assertEquals("Improper remove", "1", p2.remove());
        assertEquals("improper size", 1, p2.size());
    }
    
    /**
     * Testing remove() boundary case
     * @throws TheQueueIsDieting 
     */
    @Test
    public void testRemoveBoundaryEmpty() throws TheQueueIsDieting {
        assertEquals("Improper remove", "1", ae.remove());
        assertEquals("improper size", 0, ae.size());
    }
    
    /**
     * Testing remove() exception case
     * @throws TheQueueIsDieting 
     */
    @Test (expected = TheQueueIsDieting.class)
    public void testRemoveExceptionEmpty() throws TheQueueIsDieting {
        e.remove();
    }

    /**
     * Testing front() normal case
     * @throws TheQueueIsDieting
     */
    @Test
    public void testFront1() throws TheQueueIsDieting {
        assertEquals("Incorrect Front", "1", a.front());
    }
    
    /**
     * Testing front() normal case
     * @throws TheQueueIsDieting
     */
    @Test
    public void testFront2() throws TheQueueIsDieting {
        assertEquals("Incorrect Front", "1", b.front());
    }
    
    /**
     * Testing front() boundary case
     * @throws TheQueueIsDieting
     */
    @Test
    public void testFrontBoundaryEmpty() throws TheQueueIsDieting {
        assertEquals("Incorrect Front", "1", ae.front());
    }
    
    /**
     * Testing front() exception case
     * @throws TheQueueIsDieting
     */
    @Test (expected = TheQueueIsDieting.class)
    public void testFrontExceptionEmpty() throws TheQueueIsDieting {
        e.front();
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
