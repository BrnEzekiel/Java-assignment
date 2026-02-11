
public class InterfaceAsTypeTest {
    public static void main(String[] args) {
        // An interface reference is used to refer to an implementing class
        Payable payable;

        payable = new Employee("Alice", 6000);
        System.out.println("Employee's pay: " + payable.calculatePay());

        payable = new Contractor("Bob", 60, 100);
        System.out.println("Contractor's pay: " + payable.calculatePay());

        // Demonstrate runtime polymorphism
        System.out.println("\nDemonstrating runtime polymorphism:");
        processPayable(new Employee("Charlie", 7000));
        processPayable(new Contractor("David", 70, 120));
    }

    public static void processPayable(Payable payable) {
        System.out.println("Processing payment of $" + payable.calculatePay());
    }

    /*
     * Explanation of what happens during execution:
     *
     * 1.  A reference variable 'payable' of type 'Payable' (an interface) is created.
     * 2.  This reference can point to any object of a class that implements the 'Payable' interface.
     * 3.  When 'payable' points to an 'Employee' object, calling 'calculatePay()' executes the 'Employee' class's implementation of the method.
     * 4.  When 'payable' points to a 'Contractor' object, calling 'calculatePay()' executes the 'Contractor' class's implementation.
     * 5.  This is called runtime polymorphism because the decision of which 'calculatePay()' method to execute is made at runtime, based on the actual object the 'payable' reference is pointing to.
     * 6.  The 'processPayable' method can accept any object that implements the 'Payable' interface, making the code more flexible and extensible.
     */
}

