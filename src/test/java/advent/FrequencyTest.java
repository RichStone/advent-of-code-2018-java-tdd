package advent;

import advent.ChronalCalibration.Frequency;
import org.junit.Test;
import static org.junit.Assert.*;

public class FrequencyTest {
    @Test
    public void initialSumShouldBeZero() {
        Frequency frequency = new Frequency();
        int currentFrequency = frequency.getCurrent();
        assertEquals(currentFrequency, 0);
    }

    @Test
    public void newFrequencyShouldBeOneAfterChangingFrequencyByPlusOne() {
        Frequency frequency = new Frequency();
        frequency.changeBy(1);
        assertEquals(frequency.getCurrent(), 1);
    }

    @Test
    public void newFrequencyShouldBeMinusTwoAfterChangingByMinusTwo() {
        Frequency frequency = new Frequency();
        frequency.changeBy(-2);
        assertEquals(frequency.getCurrent(), -2);
    }

    @Test
    public void frequencyShouldBe3After3ChangesByOne() {

    }
}
