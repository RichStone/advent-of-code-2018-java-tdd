package advent.InventoryManagementSystem;

import com.sun.codemodel.internal.JForEach;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SimilarityDetector {
    public static boolean differByOneCharLocallySensitive(String a, String b) {
        int differenceCount = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                differenceCount++;
                if (differenceCount > 1) {
                    return false;
                }
            }
        }

        // equals with zero difference count don't differ by one
        return differenceCount != 0;
    }

    public static List<String> getSimilarsByOneCharLocallySensitive(String[] strings) {
        List<String> similars = new ArrayList<>();

        for (int comparerIndex = 0; comparerIndex < strings.length; comparerIndex++) {
            for (int baseIndex = comparerIndex; baseIndex < strings.length; baseIndex++) {
                String comparer = strings[comparerIndex];
                String base = strings[baseIndex];
                if (differByOneCharLocallySensitive(comparer, base)) {
                    similars.add(comparer);
                    similars.add(base);
                    return similars;
                }
            }
        }

        return similars;
    }

    public static String getCommonChars(String a, String b) {
        StringBuilder commonChars = new StringBuilder();

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                commonChars.append(a.charAt(i));
            }
        }

        return commonChars.toString();
    }
}
