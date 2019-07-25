package advent;

import advent.ChronalCalibration.Frequency;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FrequencyTest {
    @Test
    public void initialSumShouldBeZero() {
        Frequency frequency = new Frequency();
        int currentFrequency = frequency.getCurrent();
        assertEquals(0, currentFrequency);
    }

    @Test
    public void newFrequencyShouldBeOneAfterChangingFrequencyByPlusOne() {
        Frequency frequency = new Frequency();
        frequency.changeBy(1);
        assertEquals(1, frequency.getCurrent());
    }

    @Test
    public void newFrequencyShouldBeMinusTwoAfterChangingByMinusTwo() {
        Frequency frequency = new Frequency();
        frequency.changeBy(-2);
        assertEquals(-2, frequency.getCurrent());
    }

    @Test
    public void shouldGetCorrectFrequencyChangeFromTestInputStream() {
        Frequency frequency = new Frequency();
        InputStream testInput = new ByteArrayInputStream("+1\n+1\n+1\n".getBytes());
        int frequencyChange = frequency.getFrequencyChangeFrom(testInput);
        assertEquals(3, frequencyChange);

        testInput = new ByteArrayInputStream("+1\n+1\n-2\n".getBytes());
        frequencyChange = frequency.getFrequencyChangeFrom(testInput);
        assertEquals(0, frequencyChange);

        testInput = new ByteArrayInputStream("-1\n-2\n-3\n".getBytes());
        frequencyChange = frequency.getFrequencyChangeFrom(testInput);
        assertEquals(-6, frequencyChange);
    }
}
