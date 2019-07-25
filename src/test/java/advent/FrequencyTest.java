package advent;

import org.junit.Test;
import static org.junit.Assert.*;

public class FrequencyTest {
    @Test
    public void initialSumShouldBeZero() {
        Frequency frequency = new Frequency();
        int currentFrequency = frequency.getCurrent();
        assertEquals(currentFrequency, 0);
    }
}
