package advent.InventoryManagementSystem;

public class EqualCharCounter {

    private static int doublesCount = 0;
    private static int triplesCount = 0;

    public static int getDoublesCount() {
        return doublesCount;
    }

    public static void countUpDoubles() {
        doublesCount++;
    }

    public static int getTriplesCount() {
        return triplesCount;
    }

    public static void countUpTriples() {
        triplesCount++;
    }

    public static int getChecksum() {
        return doublesCount * triplesCount;
    }
}
