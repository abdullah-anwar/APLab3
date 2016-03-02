package APLab3;

import org.junit.Test;
import static org.junit.Assert.*;

public class Test {
    
    @Test
    public void testName() {
        System.out.println("Test of getUser function");
        Data instance = new Data("Abdullah", "Hello World", 1);
        String expResult = "Abdullah";
        String result = instance.getUser();
        assertEquals(expResult, result);
        System.out.println("Test Passed");
    }

    
    @Test
    public void testNotes() {
        System.out.println("Test of  getNotes function");
        Data instance = new Data("Abdullah", "Hello World", 1);
        String expResult = "Hello World";
        String result = instance.getNotes();
        assertEquals(expResult, result);
        System.out.println("Test Passed");
    }
    
}
