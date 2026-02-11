
public class Main {
    public static void main(String[] args) {
        Test t1 = new Test();
        t1.x = 10;

        Test t2 = t1;
        t2.x = 20;

        System.out.println(t1.x);
    }
}
