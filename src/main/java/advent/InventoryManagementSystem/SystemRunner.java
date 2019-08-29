package advent.InventoryManagementSystem;

import advent.Utils.InputReader;

import java.util.List;
import java.util.Scanner;

public class SystemRunner {
    public static void main(String[] args) {
        runSystem();
    }

    private static void runSystem() {
        InputReader inputReader = new InputReader("inputDay2.txt");

        // part 1
        Scanner inputStrings = inputReader.getScanner();
        int checksum = new SystemRunner().detectAndCount(inputStrings);
        System.out.println("Part 1 checksum: " + checksum);

        // part 2
        String [] inputStringsArr = inputReader.getStringTokenArray();
        List<String> similars = SimilarityDetector.getSimilarsByOneCharLocallySensitive(inputStringsArr);
        String commonChars = SimilarityDetector.getCommonChars(similars.get(0), similars.get(1));
        System.out.println(commonChars);
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
