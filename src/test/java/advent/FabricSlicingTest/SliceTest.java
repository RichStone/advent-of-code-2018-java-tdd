package advent.FabricSlicingTest;

import static org.junit.Assert.*;

import advent.FabricSlicing.Slice;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SliceTest {
    @Test
    public void testStoresTupleCoordinatesFromInput() {
        String input = "#123 @ 3,2: 2x2";
        Set<String> coordinates = Slice.createSliceFrom(input);
        assertEquals(coordinates.size(), 4);

        Set<String> expectedCoordinates = new HashSet<>();
        expectedCoordinates.add("4-3");
        expectedCoordinates.add("5-3");
        expectedCoordinates.add("4-4");
        expectedCoordinates.add("5-4");
        assertEquals(expectedCoordinates, coordinates);
    }

    @Test
    public void testGetSimpleCoordinateDoublesAmount() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("#1 @ 1,3: 4x4");
        inputs.add("#2 @ 3,1: 4x4");
        inputs.add("#3 @ 5,5: 2x2");

        int doubles = Slice.getCoordinateDoublesAmountFrom(inputs);
        assertEquals(4, doubles);
    }

    @Test
    public void testGetMoreCoordinateDoublesAmount() {
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("#1 @ 1,3: 4x4");
        inputs.add("#2 @ 3,1: 4x4");
        inputs.add("#3 @ 5,5: 2x2");
        inputs.add("#4 @ 4,4: 3x3");

        int doubles = Slice.getCoordinateDoublesAmountFrom(inputs);
        assertEquals(12, doubles);
    }
}
