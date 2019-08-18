package advent.InventoryManagementSystem;

import java.util.Arrays;

public class EqualCharDetector {
    public static boolean hasRepeatingCharsAmount(String input, int amountRepeated) {
        char[] sortedInput = input.toCharArray();
        Arrays.sort(sortedInput);

        int charTimesRepeated = 0;
        for (int i = 0; i < sortedInput.length; i++) {
            char currChar = sortedInput[i];
            // the first letter has no lastChar
            if (i > 0) {
                char lastChar = sortedInput[i - 1];
                if (currChar == lastChar) {
                    charTimesRepeated++;
                    // return at last char if repeating char
                    if (i == sortedInput.length - 1) {
                        if (charTimesRepeated == amountRepeated) {
                            return true;
                        }
                    }
                } else {
                    // the last char is not repeated anymore
                    if (charTimesRepeated == amountRepeated) return true;
                    charTimesRepeated = 1;
                }
            } else {
                // set repeated count for the first char
                charTimesRepeated = 1;
            }
        }
        return false;
    }
}
