
class Demo {
    int value;

    // Optional: Add a finalize method to observe GC
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Demo object with value " + value + " garbage collected.");
        super.finalize();
    }
}
