public class GCExample {
    public static void main(String[] args) {
        new Demo(); // Object 1: created, not referenced, immediately eligible
        Demo d1 = new Demo(); // Object 2: created, referenced by d1
        Demo d2 = new Demo(); // Object 3: created, referenced by d2

        d1 = null; // Object 2 now eligible for GC (d1 no longer points to it)
        d2 = d1;   // d2 now points to null (same as d1). Object 3 now eligible for GC.

        // At this point, all three Demo objects are eligible for garbage collection.
        // The first object (new Demo()) was never referenced.
        // The second object (originally referenced by d1) lost its reference when d1 was set to null.
        // The third object (originally referenced by d2) lost its reference when d2 was set to null (d1 was null).

        // For demonstration purposes, suggest GC
        System.gc();
        System.out.println("End of main method.");
    }
}