package advent.ChronalCalibration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Frequency {

    private int current;

    public Frequency() {
        this.current = 0;
    }

    public int getCurrent() {
        return current;
    }

    public void changeBy(int value) {
        current += value;
    }

    public int getFrequencyChangeFrom(InputStream frequencyHistory) {
        Scanner s = new Scanner(frequencyHistory);
        int frequencyChange = 0;

        while(s.hasNextInt()) {
            frequencyChange += s.nextInt();
        }
        return frequencyChange;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Frequency frequency = new Frequency();
        File inputFile = new File("/Users/rich/code/src/github.com/AoC-2018/src/main/java/advent/ChronalCalibration/input.txt");
        InputStream input = new FileInputStream(inputFile);

        System.out.println(frequency.getFrequencyChangeFrom(input));
    }
}
