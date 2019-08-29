package advent.FabricSlicing;

import advent.Utils.InputReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Slice {
    public static void main(String[] args) {
        InputReader reader = new InputReader("inputDay3.txt");
        ArrayList<String> inputs = reader.getStringLinesArrayList();
        System.out.println(getCoordinateDoublesAmountFrom(inputs));
    }

    public static int getCoordinateDoublesAmountFrom(ArrayList<String> inputs) {
        List<Set<String>> coordinateSets = new ArrayList<>();
        for (String input : inputs) {
            coordinateSets.add(createSliceFrom(input));
        }
        Set<String> repeatingCoordinates = new HashSet<>();
        for (int i = 0; i < coordinateSets.size(); i++) {
            for (int j = i + 1; j < coordinateSets.size(); j++) {
                Set<String> intersection = new HashSet<>(coordinateSets.get(i));
                Set<String> nextSet = new HashSet<>(coordinateSets.get(j));
                intersection.retainAll(nextSet);
                repeatingCoordinates.addAll(intersection);
            }
        }
        return repeatingCoordinates.size();
    }

    public static Set<String> createSliceFrom(String input) {
        Set<String> coordinates = new HashSet<>();

        String [] indicators = input.split(" ");
        String [] sizeIndicators = indicators[3].split("x");
        int width = Integer.parseInt(sizeIndicators[0]);
        int height = Integer.parseInt(sizeIndicators[1]);
        String [] locationIndicators = indicators[2].split(",");
        int marginLeft = Integer.parseInt(locationIndicators[0]);
        int marginTop = Integer.parseInt(locationIndicators[1].replace(":", ""));

        for (int x = marginLeft + 1; x <= marginLeft + width; x++ ) {
            for (int y = marginTop + 1; y <= marginTop + height; y++) {
                coordinates.add(x + "-" + y);
            }
        }
        return coordinates;
    }
}
