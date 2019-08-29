package advent.FabricSlicingTest;

import advent.FabricSlicing.FabricField;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * THIS IS THE ABANDONED FIRST SPONTANEOUS THOUGHT SOLUTION
 */
public class FabricFieldTest {
    private int width = 100;
    private int height = 200;
    private FabricField field;

    @Before
    public void setUp() throws Exception {
        field = new FabricField(width, height);
    }

    @Test
    public void testFabricFieldCreation() {
        assertEquals(100, field.getRows().size());
        assertEquals(height, field.getRows().get(0).size());
        assertEquals(height, field.getRows().get(99).size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFieldBoundaries() {

    }
}
