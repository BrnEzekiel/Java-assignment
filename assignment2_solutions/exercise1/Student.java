
public class Student {
    String name;
    String regNo;

    // Constructor to initialize instance variables
    public Student(String name, String regNo) {
        this.name = name;
        this.regNo = regNo;
    }

    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Registration No: " + regNo);
    }
}
