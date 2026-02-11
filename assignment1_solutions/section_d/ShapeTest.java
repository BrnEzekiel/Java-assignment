
public class ShapeTest {
    public static void main(String[] args) {
        NewShape circle = new Circle(5);
        NewShape rectangle = new Rectangle(4, 5);

        System.out.println("Circle:");
        circle.display(); // Now calling the default method from NewShape interface
        System.out.println("Area: " + circle.area());

        System.out.println("\nRectangle:");
        rectangle.display(); // Now calling the default method from NewShape interface
        System.out.println("Area: " + rectangle.area());
    }
}

