
public class PassTest {
    static void modify(Number n) {
        n.value = 50;
    }

    public static void main(String[] args) {
        Number obj = new Number();
        obj.value = 10;
        modify(obj);
        System.out.println(obj.value);
    }
}
