public class StudentMemoryTest {
    public static void main(String[] args) {
        // Create two Student objects
        Student student1 = new Student("Alice", "1001");
        Student student2 = new Student("Bob", "1002");

        System.out.println("Details of Student 1:");
        student1.displayDetails();

        System.out.println("\nDetails of Student 2:");
        student2.displayDetails();

        /*
         * Explanation of memory sharing:
         *
         * No, student1 and student2 objects do NOT share memory for their instance data.
         *
         * When 'new Student("Alice", "1001")' is executed, a new Student object is created
         * on the heap memory, and its instance variables ('name' and 'regNo') are allocated
         * and initialized within that specific object's memory space. The 'student1' variable
         * then holds a reference (memory address) to this unique object.
         *
         * Similarly, when 'new Student("Bob", "1002")' is executed, another completely separate
         * Student object is created on the heap, at a different memory location. Its own
         * instance variables are allocated and initialized independently. The 'student2' variable
         * holds a reference to this second unique object.
         *
         * While both 'student1' and 'student2' are of the 'Student' type and share the same
         * class definition (blueprint), they are distinct objects in memory, each with its
         * own copy of instance variables. Changes to 'student1.name' will not affect 'student2.name'
         * because they reside in different memory locations.
         *
         * The only "shared" aspect is the class definition itself, which is loaded once
         * into memory (e.g., method code), but the data for each object is independent.
         */
    }
}
