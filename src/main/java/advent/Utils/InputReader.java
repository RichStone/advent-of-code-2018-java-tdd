package advent.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class InputReader {
    private URL url;

    /**
     * Initialize the input reader with a filename.
     * @param filename - filename of the input file lying in the resources directory
     */
    public InputReader(String filename) {
        url = ClassLoader.getSystemClassLoader().getResource(filename);
    }

    public File getFile() {
        return new File(url.getFile());
    }

    public Scanner getScanner() {
        try {
            File file = getFile();
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("No such file");
        }
        return null;
    }

    public String [] getStringArray() {
        Scanner inputs = getScanner();
        int arraySize = getScannerLineCount(inputs);
        String [] strings = new String[arraySize];

        // reinitialize inputs after the scanner object was exhausted in the counting operation
        inputs = getScanner();
        for (int i = 0; i < arraySize; i++) {
            String s = inputs.next();
            strings[i] = s;
        }

        return strings;
    }

    private int getScannerLineCount(Scanner scanner) {
        int count = 0;
        while (scanner.hasNext()) {
            count++;
            scanner.next();
        }
        return count;
    }
}
