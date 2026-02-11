
/*
 * Differences between Interfaces and Abstract Classes:
 *
 * 1.  Multiple Inheritance: A class can implement multiple interfaces, but it can only extend one abstract class.
 * 2.  Method Implementation: Interfaces can only have abstract methods (before Java 8), while abstract classes can have both abstract and concrete methods. (Java 8 introduced default and static methods in interfaces, and Java 9 introduced private methods).
 * 3.  Fields: Interfaces can only have public, static, and final fields (constants), while abstract classes can have any type of field (instance, static, final).
 * 4.  Constructors: Abstract classes can have constructors, while interfaces cannot.
 * 5.  Access Modifiers: Interface methods are implicitly public and abstract. Abstract class methods can have any access modifier (public, protected, private, default).
 *
 *
 * Converting Shape Abstract Class to an Interface:
 */

// Original Abstract Class (for reference, not part of the solution directly)
/*
public abstract class Shape {
    public abstract double area();

    public void display() {
        System.out.println("This is a shape.");
    }
}
*/

// Converted to Interface
public interface NewShape {
    double area(); // Methods in interfaces are implicitly public and abstract

    // Since Java 8, interfaces can have default methods
    default void display() {
        System.out.println("This is a shape (from interface).");
    }
}
