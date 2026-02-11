
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Alice", "Computer Science");
        Student student2 = new Student(2, "Bob", "Information Technology");

        System.out.println("Details of Student 1:");
        student1.displayDetails();

        System.out.println("\nDetails of Student 2:");
        student2.displayDetails();
    }
}

