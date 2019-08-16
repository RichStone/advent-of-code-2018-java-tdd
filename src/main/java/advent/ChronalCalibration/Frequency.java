package advent.ChronalCalibration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class Frequency {

    private int currentFrequencySum;
    private Set<Integer> sums;
    public List<Integer> frequencyHistory;
    private ListIterator<Integer> listIterator;

    public Frequency() {
        currentFrequencySum = 0;
        sums = new HashSet<>();
        sums.add(0);
    }

    public Frequency(InputStream frequencyHistory) {
        currentFrequencySum = 0;
        sums = new HashSet<>();
        sums.add(0);

        this.frequencyHistory = initializeFrequencyHistory(frequencyHistory);
        listIterator = this.frequencyHistory.listIterator(0);
    }

    private List<Integer> initializeFrequencyHistory(InputStream frequencyHistory) {
        Scanner s = new Scanner(frequencyHistory);
        List<Integer> parsedFrequencyHistory = new LinkedList<>();

        while (s.hasNextInt()) {
            parsedFrequencyHistory.add(s.nextInt());
        }
        return parsedFrequencyHistory;
    }

    public int getCurrentFrequencySum() {
        return currentFrequencySum;
    }

    private void addToFrequencySum(int value) {
        currentFrequencySum += value;
    }

    private void addToSumsCache(int currentSum) {
        sums.add(currentSum);
    }

    public int getFrequencyChangeFrom(InputStream frequencyHistory) {
        Scanner s = new Scanner(frequencyHistory);

        while(s.hasNextInt()) {
            addToFrequencySum(s.nextInt());
            addToSumsCache(currentFrequencySum);
        }
        return currentFrequencySum;
    }

    public Integer getRepeatedSum() {
        while (listIterator.hasNext()) {
            int nextFrequency = listIterator.next();
            currentFrequencySum += nextFrequency;

            if (isRepeatedSum(currentFrequencySum)) {
                return currentFrequencySum;
            }

            addToSumsCache(currentFrequencySum);

            if (!listIterator.hasNext()) {
                listIterator = frequencyHistory.listIterator(0);
            }
        }
        return null;
    }

    private boolean isRepeatedSum(int frequencySum) {
        return sums.contains(frequencySum);
    }

    public Set<Integer> getFrequencyChangeSums() {
        return sums;
    }

    public static void main(String[] args) throws FileNotFoundException {
        URL url = ClassLoader.getSystemClassLoader().getResource("inputDay1.txt");
        assert url != null;
        File inputFile = new File(url.getFile());

        // Solution of 1st part
        Frequency frequency = new Frequency();
        InputStream input = new FileInputStream(inputFile);
        System.out.println(frequency.getFrequencyChangeFrom(input));

        // Solution of 2nd part
        input = new FileInputStream(inputFile);
        Frequency frequency2 = new Frequency(input);
        System.out.println(frequency2.getRepeatedSum());
    }
}
