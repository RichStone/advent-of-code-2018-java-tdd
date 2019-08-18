package advent.InventoryManagementSystem;

import advent.Utils.InputReader;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class SystemRunner {
    public static void main(String[] args) {
        runSystem();
    }

    public static void runSystem() {
        try {
            Scanner inputStrings = new InputReader("inputDay2.txt").getScanner();
            int checksum = new SystemRunner().detectAndCount(inputStrings);
            System.out.println(checksum);
        } catch (FileNotFoundException e) {
            System.out.println("No file with that name.");
        }
    }

    public int detectAndCount(Scanner inputStrings) {
        while (inputStrings.hasNext()) {
            String input = inputStrings.next();
            if (EqualCharDetector.hasRepeatingCharsAmount(input, 2)) {
                EqualCharCounter.countUpDoubles();
            }
            if (EqualCharDetector.hasRepeatingCharsAmount(input, 3)) {
                EqualCharCounter.countUpTriples();
            }
        }
        return EqualCharCounter.getChecksum();
    }
}
