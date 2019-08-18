package advent.InventoryManagementSystemTest;

import advent.InventoryManagementSystem.SimilarityDetector;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SimilarityDetectorTest {
    @Test
    public void shouldDetectSimilarityByOneChar() {
        String a = "abcde";
        String b = "abbde";
        assertTrue(SimilarityDetector.differByOneCharLocallySensitive(a, b));

        a = "abcde";
        b = "bbcde";
        assertTrue(SimilarityDetector.differByOneCharLocallySensitive(a, b));

        a = "abcde";
        b = "abcdd";
        assertTrue(SimilarityDetector.differByOneCharLocallySensitive(a, b));

        a = "abccc";
        b = "abcde";
        assertFalse(SimilarityDetector.differByOneCharLocallySensitive(a, b));

        a = "aaade";
        b = "abcde";
        assertFalse(SimilarityDetector.differByOneCharLocallySensitive(a, b));

        a = "abbbe";
        b = "abcde";
        assertFalse(SimilarityDetector.differByOneCharLocallySensitive(a, b));
    }

    @Test
    public void shouldGetCorrectSimilars() {
        String [] inputs = new String[7];
        inputs[0] = "abcde";
        inputs[1] = "fghij";
        inputs[2] = "klmno";
        inputs[3] = "pqrst";
        inputs[4] = "fguij";
        inputs[5] = "axcye";
        inputs[6] = "wvxyz";

        List<String> similars = SimilarityDetector.getSimilarsByOneCharLocallySensitive(inputs);

        assertEquals(2, similars.size());
        assertEquals("fghij", similars.get(0));
        assertEquals("fguij", similars.get(1));
    }

    @Test
    public void shouldReturnTheCommonChars() {
        String a = "abcde";
        String b = "abcdd";

        assertEquals("abcd", SimilarityDetector.getCommonChars(a, b));
    }
}
