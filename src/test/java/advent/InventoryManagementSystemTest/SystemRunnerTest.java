package advent.InventoryManagementSystemTest;

import advent.InventoryManagementSystem.SystemRunner;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Scanner;

public class SystemRunnerTest {
    @Test
    public void shouldCountUpCorrectly() {
        Scanner inputStrings = new Scanner(
                 "abcdef\n" +
                        "bababc\n" +
                        "abbcde\n" +
                        "abcccd\n" +
                        "aabcdd\n" +
                        "abcdee\n" +
                        "ababab\n"
        );
        assertEquals(12, new SystemRunner().detectAndCount(inputStrings));
    }
}
