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

    public Scanner getScanner() throws FileNotFoundException {
        File file = getFile();
        return new Scanner(file);
    }
}
