package advent.FabricSlicing;

import java.util.ArrayList;
import java.util.List;

public class FabricField {

    private List<List> rows = new ArrayList<>();

    public FabricField(int width, int height) {
        initialize(width, height);
    }

    private void initialize(int width, int height) {
        for (int x = 0; x < width; x++) {
            List<Integer> column = new ArrayList<>();
            for (int y = 0; y < height; y++) {
                column.add(0);
            }
            rows.add(column);
        }
    }

    public List<List> getRows() {
        return rows;
    }
}
