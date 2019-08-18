package advent.InventoryManagementSystemTest;

import advent.InventoryManagementSystem.EqualCharDetector;
import org.junit.Test;

import static org.junit.Assert.*;

public class EqualCharDetectorTest {
    @Test
    public void shouldDetectIfStringContainsDouble() {
        int charsRepeatedTwice = 2;

        String input = "absacd";
        assertTrue(EqualCharDetector.hasRepeatingCharsAmount(input, charsRepeatedTwice));

        input = "abcdef";
        assertFalse(EqualCharDetector.hasRepeatingCharsAmount(input, charsRepeatedTwice));

        input = "bababc";
        assertTrue(EqualCharDetector.hasRepeatingCharsAmount(input, charsRepeatedTwice));

        input = "ababab";
        assertFalse(EqualCharDetector.hasRepeatingCharsAmount(input, charsRepeatedTwice));
    }

    @Test
    public void shouldDetectIfStringContainsTriple() {
        int charsRepeated3Times = 3;

        String input = "absacd";
        assertFalse(EqualCharDetector.hasRepeatingCharsAmount(input, charsRepeated3Times));

        input = "abcdef";
        assertFalse(EqualCharDetector.hasRepeatingCharsAmount(input, charsRepeated3Times));

        input = "bababc";
        assertTrue(EqualCharDetector.hasRepeatingCharsAmount(input, charsRepeated3Times));

        input = "ababab";
        assertTrue(EqualCharDetector.hasRepeatingCharsAmount(input, charsRepeated3Times));
    }

    @Test
    public void shouldCountCorrectlyIfFirstRepeatingCharIsAtTheEndOfTheString() {
        int charsRepeating = 2;
        String input = "abcdd";
        assertTrue(EqualCharDetector.hasRepeatingCharsAmount(input, charsRepeating));

        charsRepeating = 3;
        input = "abcddd";
        assertTrue(EqualCharDetector.hasRepeatingCharsAmount(input, charsRepeating));
    }
}
