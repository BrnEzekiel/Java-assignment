
public class TestLifeCycle {
    public static void main(String[] args) {
        Sample s = new Sample(); // Object creation and initialization

        s = null; // Object becomes eligible for garbage collection

        System.gc(); // Hint to JVM to run garbage collector

        System.out.println("End of main method.");
    }
}
