
public class UserActionsTest {
    public static void main(String[] args) {
        UserActions student = new Student("Alice");
        UserActions lecturer = new Lecturer("Dr. Smith");
        UserActions administrator = new Administrator("Mr. Jones");

        student.performAction();
        lecturer.performAction();
        administrator.performAction();
    }
}
