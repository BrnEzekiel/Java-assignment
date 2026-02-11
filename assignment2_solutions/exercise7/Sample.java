
class Sample {
    Sample() {
        System.out.println("Constructor called");
    }

    // Optional: Add a finalize method to observe GC (though not guaranteed)
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Sample object garbage collected.");
        super.finalize();
    }
}
