package csc143.test.data_structures;

import static org.junit.Assert.*;
import csc143.data_structures.*;

import org.junit.*;

public class MySimpleSetTest {
    
    //fields
    MySimpleSet<String> empty, one, four;
    
    //methods

    @Before
    public void setup() {
        empty = new MySimpleSet<>();
        one = new MySimpleSet<>();
        four = new MySimpleSet<>();
        
        //set up with values
        one.add("x");
        four.add("b");
        four.add("a");
        four.add("c");
        four.add("d");
    }
    @Test
    public void testAddTrue() {
        assertEquals("Invalid add boolean", true, four.add("f"));
        assertEquals("Invalid add operation", true, four.contains("f"));
    }
    
    @Test
    public void testAddFalse() {
        assertEquals("Invalid add boolean", false, four.add("a"));
    }
    
    @Test
    public void testClear() {
        four.clear();
        assertEquals("Invalid clear", "()", four.toString());
    }
    
    @Test
    public void testisEmptyTrue() {
        assertEquals("Invalid isEmpty", false, four.isEmpty());
    }
    
    @Test
    public void testisEmptyFalse() {
        assertEquals("Invalid isEmpty", true, empty.isEmpty());
    }
    
    @Test
    public void testSize1() {
        assertEquals("Invalid size", 4, four.size());
    }
    
    @Test
    public void testSize2() {
        assertEquals("Invalid size", 1, one.size());
    }
    
    @Test
    public void testContainsTrue() {
        assertEquals("Invalid Contains", true, four.contains("a"));
    }
    
    @Test
    public void testContainsFalse() {
        assertEquals("Invalid Contains", false, four.contains("9"));
    }
    
    
    @Test
    public void testToString1() {
        assertEquals("invalid toString", "()", empty.toString());
    }
    
    @Test
    public void testToString2() {
        assertEquals("invalid toString", "(b (a () ()) (c () (d () ())))", four.toString());
    }
    
    public void testToString3() {
        assertEquals("invalid toString", "(x () ())", one.toString());
    }

}
