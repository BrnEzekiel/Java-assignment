
public class Lecturer implements UserActions {
    private String name;

    public Lecturer(String name) {
        this.name = name;
    }

    @Override
    public void performAction() {
        System.out.println(name + " (Lecturer) is conducting a lecture.");
    }
}
