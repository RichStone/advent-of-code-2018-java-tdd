package advent.ChronalCalibration;

import advent.ChronalCalibration.Frequency;
import org.junit.Test;

import java.io.*;
import java.util.*;

import static org.junit.Assert.*;

public class FrequencyTest {
    @Test
    public void initialSumShouldBeZero() {
        Frequency frequency = new Frequency();
        int currentFrequency = frequency.getCurrentFrequencySum();
        assertEquals(0, currentFrequency);
    }

    @Test
    public void shouldGetCorrectFrequencyChangeFromTestInputStream() {
        InputStream testInput = new ByteArrayInputStream("+1\n+1\n+1\n".getBytes());
        int frequencyChange = new Frequency().getFrequencyChangeFrom(testInput);
        assertEquals(3, frequencyChange);

        testInput = new ByteArrayInputStream("+1\n+1\n-2\n".getBytes());
        frequencyChange = new Frequency().getFrequencyChangeFrom(testInput);
        assertEquals(0, frequencyChange);

        testInput = new ByteArrayInputStream("-1\n-2\n-3\n".getBytes());
        frequencyChange = new Frequency().getFrequencyChangeFrom(testInput);
        assertEquals(-6, frequencyChange);
    }

    @Test
    public void shouldCacheSumOfFrequencies() {
        Frequency freq = new Frequency();
        InputStream testInput = new ByteArrayInputStream("+1\n+1\n+1\n".getBytes());
        int frequencyChange = freq.getFrequencyChangeFrom(testInput);
        Set<Integer> sums = freq.getFrequencyChangeSums();
        assertTrue(sums.contains(0));
        assertTrue(sums.contains(1));
        assertTrue(sums.contains(2));
        assertTrue(sums.contains(3));
    }

    @Test
    public void shouldGetTheFirstRepeatingFrequencySum() {
        InputStream testInput = new ByteArrayInputStream("+3\n+3\n+4\n-2\n-4\n".getBytes());
        Frequency freq = new Frequency(testInput);
        int repeatedSum = freq.getRepeatedSum();
        assertEquals(10, repeatedSum);

        testInput = new ByteArrayInputStream("-6\n+3\n+8\n+5\n-6\n".getBytes());
        freq = new Frequency(testInput);
        repeatedSum = freq.getRepeatedSum();
        assertEquals(5, repeatedSum);

        testInput = new ByteArrayInputStream("+7\n+7\n-2\n-7\n-4\n".getBytes());
        freq = new Frequency(testInput);
        repeatedSum = freq.getRepeatedSum();
        assertEquals(14, repeatedSum);
    }

    @Test
    public void shouldGetTheFirstRepeatingFrequencySumWhenZero() {
        InputStream testInput = new ByteArrayInputStream("+1\n-1\n-2\n".getBytes());
        Frequency freq = new Frequency(testInput);
        int repeatedSum = freq.getRepeatedSum();
        assertEquals(0, repeatedSum);
    }

    @Test
    public void shouldLoopUntilRepeatedSumIsFound() {
        InputStream testInput = new ByteArrayInputStream("+1\n-2\n+3\n+1\n".getBytes());
        Frequency freq = new Frequency(testInput);
        int repeatedSum = freq.getRepeatedSum();
        assertEquals(2, repeatedSum);
    }

    @Test
    public void shouldInitializeFrequencyHistoryCorrectly() {
        InputStream testInput = new ByteArrayInputStream("+1\n-1\n-2\n".getBytes());
        Frequency freq = new Frequency(testInput);
        List<Integer> frequencyHistory = freq.frequencyHistory;

        int frequencyHistoryLength = frequencyHistory.size();
        assertEquals(3, frequencyHistoryLength);

        int freq1 = frequencyHistory.get(0);
        int freq2 = frequencyHistory.get(1);
        int freq3 = frequencyHistory.get(2);
        assertEquals(1, freq1);
        assertEquals(-1, freq2);
        assertEquals(-2, freq3);
    }
}
