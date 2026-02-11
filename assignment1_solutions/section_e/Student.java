
public class Student implements UserActions {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void performAction() {
        System.out.println(name + " (Student) is enrolling in courses.");
    }
}
