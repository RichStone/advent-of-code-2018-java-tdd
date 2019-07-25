package advent.ChronalCalibration;

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
}
