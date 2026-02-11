
public class Administrator implements UserActions {
    private String name;

    public Administrator(String name) {
        this.name = name;
    }

    @Override
    public void performAction() {
        System.out.println(name + " (Administrator) is managing user accounts.");
    }
}
