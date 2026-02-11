
public class MarkerInterfaceTest {
    public static void main(String[] args) {
        Transaction transaction1 = new Transaction("T1001", 100.0);
        checkAuditable(transaction1);

        // Create an object of a class that does not implement Auditable
        Object obj = new Object();
        checkAuditable(obj);
    }

    public static void checkAuditable(Object obj) {
        if (obj instanceof Auditable) {
            System.out.println(obj.getClass().getSimpleName() + ": Auditing enabled");
        } else {
            System.out.println(obj.getClass().getSimpleName() + ": Auditing not enabled");
        }
    }
}
