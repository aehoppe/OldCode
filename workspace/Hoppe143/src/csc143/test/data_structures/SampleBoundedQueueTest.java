package csc143.test.data_structures;

import static org.junit.Assert.*;

import org.junit.*;

import csc143.data_structures.*;

/**
 * This class tests the functionality of the SampleBoundedQueue class
 * @author Alexander Hoppe
 * @version May 3, 2015
 */
public class SampleBoundedQueueTest {
    
    //fields
    /**
     * A filled SampleBoundedQueue with 2 elements
     */
    SampleBoundedQueue a;
    
    /**
     * A filled SampleBoundedQueue with 4 elements
     */
    SampleBoundedQueue b; 
    
    /**
     * An empty SampleBoundedQueue with 0 elements
     */
    SampleBoundedQueue e;
    
    /**
     * A SampleBoundedQueue that will be partially filled, size 3 of capacity 6
     */
    SampleBoundedQueue p1;
    
    /**
     * A SampleBoundedQueue that will be partially filled, size 2 of capacity 7
     */
    SampleBoundedQueue p2;
    
    /**
     * A SampleBoundedQueue that is almost empty, size 1, capacity 2
     */
    SampleBoundedQueue ae;
    
    /**
     * A SampleBoundedQueue that will be almost full, size 4 of capacity 5
     */
    SampleBoundedQueue af1;
    
    /**
     * A SampleBoundedQueue that will be almost full, size 2 of capacity 3
     */
    SampleBoundedQueue af2;
    
    /**
     * Setting up test instances to run methods on
     */
    @Before
    public void setup() {
        a = new SampleBoundedQueue(2);
        b = new SampleBoundedQueue(4);
        e = new SampleBoundedQueue(4);
        p1 = new SampleBoundedQueue(6);
        p2 = new SampleBoundedQueue(7);
        ae = new SampleBoundedQueue(2);
        af1 = new SampleBoundedQueue(5);
        af2 = new SampleBoundedQueue(3);
        
        //filling up Queues with string values
        try {
            for (int i = 1; i < 3; i++) a.add(Integer.toString(i));
            for (int i = 1; i < 5; i++) b.add(Integer.toString(i));
            for (int i = 1; i < 4; i++) p1.add(Integer.toString(i));
            for (int i = 1; i < 3; i++) p2.add(Integer.toString(i));
            ae.add(Integer.toString(1));
            for (int i = 1; i < 5; i++) af1.add(Integer.toString(i));
            for (int i = 1; i < 3; i++) af2.add(Integer.toString(i));
        } catch (TheQueueIsOutTheDoor exception) {}
    }

    /**
     * Testing constructor normal conditions
     */
    @Test
    public void testConstructor1() {
        SampleBoundedQueue x = new SampleBoundedQueue(3);
        assertEquals("improper capacity", 3, x.capacity());
    }
    
    /**
     * Testing constructor normal conditions
     */
    @Test
    public void testConstructor2() {
        SampleBoundedQueue x = new SampleBoundedQueue(120);
        assertEquals("Improper capacity", 120, x.capacity());
    }
    
    /**
     * Testing constructor lower boundary
     */
    @Test
    public void testConstructorBoundaryAt0() {
        new SampleBoundedQueue(0);
    }
    
    /**
     * Testing constructor lower exception
     */
    @Test (expected = NegativeArraySizeException.class)
    public void testConstructorNegativeException() {
        new SampleBoundedQueue(-1);
    }
    
    /**
     * Testing add normal case
     * @throws TheQueueIsOutTheDoor
     * @throws TheQueueIsDieting
     */
    @Test
    public void testAdd1() throws TheQueueIsOutTheDoor, TheQueueIsDieting {
        p1.add("0");
        assertEquals("improper size", 4, p1.size());
        for (int i = 0; i < 3; i++) p1.remove();
        assertEquals("improper adding", "0", p1.front());
    }
    
    /**
     * Testing add normal case
     * @throws TheQueueIsOutTheDoor
     * @throws TheQueueIsDieting
     */
    @Test
    public void testAdd2() throws TheQueueIsOutTheDoor, TheQueueIsDieting {
        p2.add("0");
        assertEquals("improper size", 3, p2.size());
        for (int i = 0; i < 2; i++) p2.remove();
        assertEquals("improper adding", "0", p2.front());
    }
    
    /**
     * Testing add boundary case with empty list
     * @throws TheQueueIsOutTheDoor
     * @throws TheQueueIsDieting
     */
    @Test
    public void testAddBoundaryEmpty() throws TheQueueIsOutTheDoor, TheQueueIsDieting {
        e.add("0");
        assertEquals("improper size", 1, e.size());
        assertEquals("improper adding", "0", e.front());
    }
    
    /**
     * Testing add boundary almost full
     * @throws TheQueueIsOutTheDoor
     * @throws TheQueueIsDieting
     */
    @Test
    public void testAddBoundaryFull1() throws TheQueueIsOutTheDoor, TheQueueIsDieting {
        af1.add("0");
        assertEquals("improper size", 5, af1.size());
        for (int i = 0; i < 4; i++) af1.remove();
        assertEquals("improper adding", "0", af1.front());
    }
    
    /**
     * Testing add boundary almost full
     * @throws TheQueueIsOutTheDoor
     * @throws TheQueueIsDieting
     */
    @Test
    public void testAddBoundaryFull2() throws TheQueueIsOutTheDoor, TheQueueIsDieting {
        af2.add("0");
        assertEquals("improper size", 3, af2.size());
        for (int i = 0; i < 2; i++) af2.remove();
        assertEquals("improper adding", "0", af2.front());
    }
    
    /**
     * Testing add exception full
     * @throws TheQueueIsOutTheDoor 
     */
    @Test (expected = TheQueueIsOutTheDoor.class)
    public void testAddExceptionFull1() throws TheQueueIsOutTheDoor {
        a.add("0");
    }
    
    /**
     * Testing add exception full
     * @throws TheQueueIsOutTheDoor 
     */
    @Test (expected = TheQueueIsOutTheDoor.class)
    public void testAddExceptionFull2() throws TheQueueIsOutTheDoor {
        b.add("0");
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
