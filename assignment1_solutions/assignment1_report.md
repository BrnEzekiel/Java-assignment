# Assignment 1: OOP Foundations & Interfaces - Solutions

**Note on Code Snippets:** Due to the nature of this AI environment, I cannot provide "snaps" (screenshots) of code as requested. All code examples are embedded directly as text within Markdown code blocks. If a visual representation of the code were strictly required, a human would typically insert screenshots here.

---

## Section A: Conceptual Exercises

**1. Define the following terms as used in Object-Oriented Programming:**

*   **Class:**
    A class is a blueprint or a template for creating objects. It defines the structure (data/attributes) and behavior (methods/functions) that all objects of that type will have. It's a logical construct that doesn't occupy memory until an object is created from it. For example, a `Car` class might define that all cars have `color`, `make`, `model` (attributes) and can `start()`, `stop()`, `accelerate()` (behaviors).

*   **Object:**
    An object is an instance of a class. It's a real-world entity that has a state (values of its attributes) and behavior (actions it can perform). When an object is created from a class, memory is allocated for it. For example, `myCar = new Car("Red", "Toyota", "Camry")` creates an object `myCar` from the `Car` class.

*   **Encapsulation:**
    Encapsulation is the bundling of data (attributes) and methods that operate on the data into a single unit (class), and restricting direct access to some of the object's components. This is typically achieved by making the attributes `private` and providing `public` methods (getters and setters) to access and modify them. The main benefits are data hiding, protecting data from unauthorized access, and better control over data manipulation.

*   **Abstraction:**
    Abstraction is the concept of hiding the complex implementation details and showing only the essential features of an object or system. It focuses on *what* an object does rather than *how* it does it. This can be achieved using abstract classes and interfaces. It helps in managing complexity by presenting a simplified view to the user. For example, when you press the accelerator pedal in a car, you don't need to know the intricate details of the engine's operation; you only care that the car speeds up.

**2. State four advantages of using Object-Oriented Programming compared to procedural programming.**

1.  **Modularity/Reusability:** OOP promotes breaking down a program into smaller, self-contained units (objects/classes). These modules can be reused in different parts of the program or in other projects, saving development time and effort.
2.  **Maintainability:** Encapsulation and abstraction make it easier to maintain and modify existing code. Changes made within one class are less likely to affect other parts of the system, as long as the public interface remains consistent.
3.  **Flexibility/Extensibility:** Inheritance and polymorphism allow new features to be added easily without altering existing code. New classes can inherit from existing ones, and polymorphic behavior allows treatment of objects of different classes in a uniform way.
4.  **Problem Solving Effectiveness:** OOP maps real-world entities directly into software objects, making it easier to model complex systems and solve real-world problems intuitively.

**3. Distinguish between:**

*   **a) A class and an object:**
    *   **Class:** A blueprint, template, or a logical construct that defines the structure and behavior. It does not consume memory directly. (e.g., `Car` blueprint).
    *   **Object:** An instance of a class, a concrete entity created from the blueprint. It occupies memory and has a state. (e.g., `myRedToyota` actual car).

*   **b) Encapsulation and abstraction:**
    *   **Encapsulation:** Focuses on *how* data is protected and organized within an object. It's the mechanism of binding data and methods into a single unit and restricting direct access. (Achieved via access modifiers like `private`).
    *   **Abstraction:** Focuses on *what* is exposed to the user. It's the concept of hiding complex implementation details and showing only essential features. (Achieved via abstract classes and interfaces).
    *   They are complementary: Encapsulation helps achieve abstraction by hiding internal state, while abstraction provides the simplified view.

*   **c) Inheritance and polymorphism:**
    *   **Inheritance:** A mechanism where one class (subclass/child) acquires the properties and behaviors of another class (superclass/parent). It promotes code reusability and establishes an "is-a" relationship. (e.g., `SportsCar` inherits from `Car`).
    *   **Polymorphism:** The ability of an object to take on many forms. In OOP, it means that a single interface can be used for different underlying data types or classes. It allows objects of different classes to be treated as objects of a common type. (e.g., `Car myCar = new SportsCar();` where `myCar` can refer to different types of `Car` objects, and `myCar.accelerate()` might behave differently for each).

**4. Explain why interfaces are important in Java. Give two practical use cases.**

Interfaces are crucial in Java for several reasons:
*   **Achieving Abstraction:** They define a contract of behavior without providing any implementation details (pre-Java 8). This forces implementing classes to provide their own specific implementations for the defined methods, ensuring a clear separation between *what* to do and *how* to do it.
*   **Supporting Multiple Inheritance of Type:** Java does not support multiple inheritance of implementation with classes to avoid the "diamond problem." However, a class can implement multiple interfaces, allowing it to inherit multiple type definitions and adhere to multiple contracts, which is a form of multiple inheritance of type.
*   **Promoting Loose Coupling:** Interfaces enable loose coupling between components. Code can interact with objects through their interface types rather than concrete class types, making the system more flexible and easier to change or extend.
*   **Enabling Polymorphism:** Interfaces are fundamental to polymorphism. An interface reference variable can refer to any object of a class that implements that interface. This allows for generic programming and consistent handling of diverse objects.

**Two Practical Use Cases:**

1.  **Defining APIs/Contracts:** Major frameworks and libraries use interfaces to define standard APIs. For example, `java.util.List` is an interface. Various classes like `ArrayList` and `LinkedList` implement it, each with different internal data structures and performance characteristics, but they all adhere to the `List` contract. This allows developers to write code that works with any `List` implementation without knowing its specifics.
2.  **Callback Mechanisms:** Interfaces are commonly used for implementing callback mechanisms. For instance, in UI programming, an `ActionListener` interface defines the `actionPerformed()` method. A button object (the caller) doesn't know *what* will happen when it's clicked, only that it will call `actionPerformed()` on its registered listener (the callback). The listener (implementing class) then defines the specific action to take.

**5. Why does Java not support multiple inheritance using classes? How do interfaces solve this problem?**

*   **Why Java does not support multiple inheritance using classes:**
    Java does not support multiple inheritance of *implementation* with classes primarily to avoid the **"Diamond Problem"**. This problem arises when a class inherits from two parent classes that both inherit from a common grandparent class, and both parent classes override a method from the grandparent. If the child class doesn't explicitly override that method, it becomes ambiguous which parent's implementation should be inherited (e.g., Grandparent `A` has method `foo()`, Parent `B` inherits from `A` and overrides `foo()`, Parent `C` also inherits from `A` and overrides `foo()`. If Child `D` tries to inherit from both `B` and `C`, and calls `foo()`, which `foo()` should it execute?). This ambiguity can lead to complex and hard-to-debug code.

*   **How interfaces solve this problem:**
    Interfaces solve the Diamond Problem because they define a *contract* of behavior (`what` to do) but traditionally provide *no implementation* (`how` to do it).
    *   A class can implement multiple interfaces (e.g., `class MyClass implements InterfaceA, InterfaceB`).
    *   If `InterfaceA` and `InterfaceB` both declare a method `foo()`, the implementing class `MyClass` is *forced* to provide its own single implementation of `foo()`. There is no ambiguity because `MyClass` provides the *only* implementation.
    *   (With Java 8, default methods were introduced in interfaces, which can lead to a *limited* form of the diamond problem if two interfaces provide the same default method and a class implements both. However, Java resolves this by requiring the implementing class to explicitly override the conflicting method, or specify which interface's default method to use, thereby eliminating ambiguity.)

**6. a) Explain the concept of interface inheritance in Java**
    **b) With the help of a diagram and code example, demonstrate how interfaces promote loose coupling.**

*   **a) Interface Inheritance:**
    Interface inheritance in Java refers to the ability of an interface to inherit from one or more other interfaces. An interface that inherits from another interface acquires all the abstract methods (and default/static methods from Java 8+) of its parent interfaces. The implementing class then must provide implementations for all methods from the entire inheritance hierarchy. This creates a hierarchy of contracts, allowing for more specialized interfaces while maintaining a common base.

    Example:
    ```java
    interface Drawable {
        void draw();
    }

    interface Movable {
        void move(int x, int y);
    }

    interface Draggable extends Drawable, Movable { // Draggable inherits draw() and move()
        void drag(int x, int y);
    }

    class Shape implements Draggable { // Must implement draw(), move(), and drag()
        @Override public void draw() { /* ... */ }
        @Override public void move(int x, int y) { /* ... */ }
        @Override public void drag(int x, int y) { /* ... */ }
    }
    ```

*   **b) How interfaces promote loose coupling (Diagram & Code Example):**

    **Diagram Description:**
    Imagine two boxes, "Client" and "Service," that need to interact. Instead of the "Client" directly knowing the "Service" (tight coupling), they both interact with an intermediate "Interface." The "Client" uses the "Interface," and the "Service" implements the "Interface." This way, the "Client" doesn't need to know the specifics of the "Service" implementation; it only cares that the "Service" adheres to the "Interface's" contract.

    **Code Example:**

    ```java
    // Interface: Defines the contract
    interface MessageService {
        void sendMessage(String message, String recipient);
    }

    // Concrete Implementation 1: Email Service
    class EmailService implements MessageService {
        @Override
        public void sendMessage(String message, String recipient) {
            System.out.println("Sending Email to " + recipient + ": " + message);
        }
    }

    // Concrete Implementation 2: SMSService
    class SMSService implements MessageService {
        @Override
        public void sendMessage(String message, String recipient) {
            System.out.println("Sending SMS to " + recipient + ": " + message);
        }
    }

    // Client: Depends only on the interface, not concrete classes
    public class NotificationSender {
        private MessageService service; // Depends on the interface

        // Constructor for Dependency Injection
        public NotificationSender(MessageService service) {
            this.service = service;
        }

        public void sendNotification(String message, String recipient) {
            service.sendMessage(message, recipient);
        }

        public static void main(String[] args) {
            // Loose Coupling in action:
            // The NotificationSender doesn't care if it's an EmailService or SMSService,
            // as long as it implements MessageService.

            // Use EmailService
            MessageService emailService = new EmailService();
            NotificationSender emailSender = new NotificationSender(emailService);
            emailSender.sendNotification("Hello via Email!", "alice@example.com");

            // Switch to SMSService without changing NotificationSender's code
            MessageService smsService = new SMSService();
            NotificationSender smsSender = new NotificationSender(smsService);
            smsSender.sendNotification("Hello via SMS!", "123-456-7890");
        }
    }
    ```
    In this example, `NotificationSender` (the client) is loosely coupled because it depends on the `MessageService` interface, not on `EmailService` or `SMSService` directly. We can easily swap the messaging mechanism without modifying the `NotificationSender` class.

**7. Discuss how encapsulation and interfaces together improve software maintainability.**

Encapsulation and interfaces are powerful OOP concepts that synergistically enhance software maintainability:

*   **Encapsulation's Role in Maintainability:**
    *   **Data Protection:** By hiding internal data (`private` attributes) and exposing controlled access through public methods (getters/setters), encapsulation prevents external code from directly manipulating an object's state in unforeseen ways. This makes it easier to track down bugs and ensure data integrity.
    *   **Reduced Side Effects:** Changes to an object's internal implementation (e.g., changing a data structure or algorithm) are localized within the class. As long as the public methods' signatures and behaviors remain consistent, external code using the class does not need to be modified. This significantly reduces ripple effects during maintenance.
    *   **Easier Refactoring:** Because internal details are hidden, refactoring the internals of a class becomes safer and simpler.

*   **Interfaces' Role in Maintainability:**
    *   **Clear Contracts:** Interfaces define clear contracts for behavior. This means that any class implementing an interface *must* adhere to that contract. This predictability makes it easier for developers to understand how different components interact and what behavior to expect.
    *   **Loose Coupling:** As discussed before, interfaces promote loose coupling. Components interact through abstractions rather than concrete implementations. This allows individual components to be developed, tested, and maintained independently. If a specific implementation needs to be updated or replaced, it can often be done without affecting other parts of the system, provided the interface contract is still met.
    *   **Extensibility:** Interfaces make it easy to introduce new implementations or variations of a component without altering existing code that uses the interface. This is crucial for adding new features or adapting to new requirements during maintenance.

*   **Synergy for Maintainability:**
    When used together, encapsulation and interfaces create highly maintainable software:
    *   An interface defines a public contract (`what`).
    *   An encapsulated class implements that contract (`how`), hiding its internal complexities.
    *   Any external client code interacts only with the interface, completely oblivious to the internal encapsulated details of the implementing class.

    This separation means:
    *   If the internal logic of an encapsulated class changes, as long as it still fulfills its interface contract, no client code needs to be touched.
    *   If a new implementation of an interface is needed, it can be plugged in seamlessly, as long as it adheres to the contract.
    *   Developers working on one part of the system don't need to understand the minutiae of another part, only its interface. This reduces cognitive load and the chances of introducing errors during maintenance.

    In essence, encapsulation protects the *internal* integrity of individual components, while interfaces define robust *external* boundaries and interaction points, collectively leading to systems that are easier to understand, modify, extend, and debug over their lifespan.

---

## Section B: Classes & Objects - Practical Exercises

### Exercise 1: Creating a Class

**Question:**
Create a Java class called `Student` with the following:
*   Attributes: `studentId`, `name`, `course`
*   Methods: `displayDetails()`
Write a main method to create two `Student` objects and display their details.

**Code:**
**`Student.java`**
```java
public class Student {
    int studentId;
    String name;
    String course;

    public void displayDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
}
```
**`Main.java`**
```java
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.studentId = 1;
        student1.name = "Alice";
        student1.course = "Computer Science";

        Student student2 = new Student();
        student2.studentId = 2;
        student2.name = "Bob";
        student2.course = "Information Technology";

        System.out.println("Details of Student 1:");
        student1.displayDetails();

        System.out.println("\nDetails of Student 2:");
        student2.displayDetails();
    }
}
```
**Output:**
```
Details of Student 1:
Student ID: 1
Name: Alice
Course: Computer Science

Details of Student 2:
Student ID: 2
Name: Bob
Course: Information Technology
```

### Exercise 2: Constructors

**Question:**
Modify the student class to:
*   Include a parameterized constructor
*   Initialize all attributes using the constructor
*   Demonstrate object creation using the constructor

**Code:**
**`Student.java` (Modified)**
```java
public class Student {
    int studentId;
    String name;
    String course;

    public Student(int studentId, String name, String course) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }

    public void displayDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
    }
}
```
**`Main.java` (Modified)**
```java
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Alice", "Computer Science");
        Student student2 = new Student(2, "Bob", "Information Technology");

        System.out.println("Details of Student 1:");
        student1.displayDetails();

        System.out.println("\nDetails of Student 2:");
        student2.displayDetails();
    }
}
```
**Output:**
```
Details of Student 1:
Student ID: 1
Name: Alice
Course: Computer Science

Details of Student 2:
Student ID: 2
Name: Bob
Course: Information Technology
```

### Exercise 3: Encapsulation

**Question:**
Create a class `BankAccount` with:
*   Private attributes: `accountNumber`, `balance`
*   Public methods: `deposit()`, `withdraw()`, `getBalance()`
Ensure that:
*   Balance cannot be directly accessed
*   Withdrawal amount does not exceed the balance
*   Demonstrate object creation using the constructor

**Code:**
**`BankAccount.java`**
```java
public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". New balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Withdrawal amount exceeds balance. Current balance: " + balance);
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
```
**`BankTest.java`**
```java
public class BankTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456", 1000);

        System.out.println("Initial balance: " + account.getBalance());

        account.deposit(500);
        System.out.println("Balance after deposit: " + account.getBalance());

        account.withdraw(200);
        System.out.println("Balance after withdrawal: " + account.getBalance());

        // Trying to withdraw more than the balance
        account.withdraw(2000);
        System.out.println("Balance after attempting to withdraw more than balance: " + account.getBalance());

        // Trying to access balance directly (would cause a compile error due to encapsulation)
        // System.out.println(account.balance);
    }
}
```
**Output:**
```
Initial balance: 1000.0
Deposited: 500.0. New balance: 1500.0
Balance after deposit: 1500.0
Withdrew: 200.0. New balance: 1300.0
Balance after withdrawal: 1300.0
Withdrawal amount exceeds balance. Current balance: 1300.0
Balance after attempting to withdraw more than balance: 1300.0
```

---

## Section C: Interfaces (Core Focus)

### Exercise 4: Implementing an Interface

**Question:**
Create an interface called `Payable` with a method: `double calculatePay();`
Create two classes: `Employee` and `Contractor`.
Both classes should implement the `Payable` interface and provide their own implementation of `calculatePay()`.
Demonstrate the implementation.

**Code:**
**`Payable.java`**
```java
public interface Payable {
    double calculatePay();
}
```
**`Employee.java`**
```java
public class Employee implements Payable {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calculatePay() {
        return salary;
    }

    public String getName() {
        return name;
    }
}
```
**`Contractor.java`**
```java
public class Contractor implements Payable {
    private String name;
    private double hourlyRate;
    private int hoursWorked;

    public Contractor(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    public String getName() {
        return name;
    }
}
```
**`PayableTest.java`**
```java
public class PayableTest {
    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 5000);
        Contractor contractor = new Contractor("Jane Smith", 50, 160);

        System.out.println("Employee: " + employee.getName());
        System.out.println("Pay: $" + employee.calculatePay());

        System.out.println("\nContractor: " + contractor.getName());
        System.out.println("Pay: $" + contractor.calculatePay());
    }
}
```
**Output:**
```
Employee: John Doe
Pay: $5000.0

Contractor: Jane Smith
Pay: $8000.0
```

### Exercise 5: Multiple Interfaces

**Question:**
Create two interfaces: `Printable` and `Scannable`.
Each interface should have one method.
Create a class `MultiFunctionPrinter` that implements both interfaces.
Demonstrate the implementation.

**Code:**
**`Printable.java`**
```java
public interface Printable {
    void print();
}
```
**`Scannable.java`**
```java
public interface Scannable {
    void scan();
}
```
**`MultiFunctionPrinter.java`**
```java
public class MultiFunctionPrinter implements Printable, Scannable {
    @Override
    public void print() {
        System.out.println("Printing...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning...");
    }
}
```
**`MultiFunctionPrinterTest.java`**
```java
public class MultiFunctionPrinterTest {
    public static void main(String[] args) {
        MultiFunctionPrinter printer = new MultiFunctionPrinter();
        printer.print();
        printer.scan();
    }
}
```
**Output:**
```
Printing...
Scanning...
```

### Exercise 6: Interface as a Data Type (Very Important)

**Question:**
Write a program where:
*   An interface reference is used to refer to an implementing class
*   Demonstrate runtime polymorphism
*   Explain what happens during execution.

**Code:**
**`InterfaceAsTypeTest.java`**
```java
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
```
**Output:**
```
Employee's pay: 6000.0
Contractor's pay: 6000.0

Demonstrating runtime polymorphism:
Processing payment of $7000.0
Processing payment of $8400.0
```

---

## Section D: Abstract Classes vs Interfaces

### Exercise 7: Abstract Class

**Question:**
Create an abstract class `Shape` with:
*   An abstract method `area()`
*   A concrete method `display()`
Create subclasses `Circle` and `Rectangle` that extend `Shape` and implement the `area()` method.
Demonstrate the implementation.

**Code:**
**`Shape.java`**
```java
public abstract class Shape {
    public abstract double area();

    public void display() {
        System.out.println("This is a shape.");
    }
}
```
**`Circle.java`**
```java
public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
```
**`Rectangle.java`**
```java
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
```
**`ShapeTest.java`**
```java
public class ShapeTest {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 5);

        System.out.println("Circle:");
        circle.display();
        System.out.println("Area: " + circle.area());

        System.out.println("\nRectangle:");
        rectangle.display();
        System.out.println("Area: " + rectangle.area());
    }
}
```
**Output:**
```
Circle:
This is a shape.
Area: 78.53981633974483

Rectangle:
This is a shape.
Area: 20.0
```

### Exercise 8: Interface vs Abstract Class (Theory + Code)

**Question:**
a) List four differences between interfaces and abstract classes.
b) Convert the shape abstract class into an interface and modify the subclasses accordingly.
Demonstrate the implementation.

**Answer (a) - Differences between Interfaces and Abstract Classes:**
*   **Multiple Inheritance:** A class can implement multiple interfaces, but it can only extend one abstract class.
*   **Method Implementation:** Interfaces can only have abstract methods (before Java 8), while abstract classes can have both abstract and concrete methods. (Java 8 introduced default and static methods in interfaces).
*   **Fields:** Interfaces can only have public, static, and final fields (constants), while abstract classes can have any type of field (instance, static, final).
*   **Constructors:** Abstract classes can have constructors, while interfaces cannot.
*   **Access Modifiers:** Interface methods are implicitly public and abstract. Abstract class methods can have any access modifier (public, protected, private, default).

**Code (b) - Converting Shape Abstract Class to an Interface and Modifications:**
**`NewShape.java` (Interface)**
```java
public interface NewShape {
    double area(); // Methods in interfaces are implicitly public and abstract

    // Since Java 8, interfaces can have default methods
    default void display() {
        System.out.println("This is a shape (from interface).");
    }
}
```
**`Circle.java` (Modified to implement `NewShape`)**
```java
public class Circle implements NewShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
```
**`Rectangle.java` (Modified to implement `NewShape`)**
```java
public class Rectangle implements NewShape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}
```
**`ShapeTest.java` (Modified to use `NewShape`)**
```java
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
```
**Output:**
```
Circle:
This is a shape (from interface).
Area: 78.53981633974483

Rectangle:
This is a shape (from interface).
Area: 20.0
```

---

## Section E: Applied / Scenario-Based Exercises

### Exercise 9: Real-World Modeling

**Question:**
Design a system for a University Management System using OOP concepts:
*   Create an interface `UserActions`
*   Classes: `Student`, `Lecturer`, `Administrator`
*   Each class should implement the interface differently
Demonstrate the implementation.

**Code:**
**`UserActions.java`**
```java
public interface UserActions {
    void performAction();
}
```
**`Student.java`**
```java
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
```
**`Lecturer.java`**
```java
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
```
**`Administrator.java`**
```java
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
```
**`UserActionsTest.java`**
```java
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
```
**Output:**
```
Alice (Student) is enrolling in courses.
Dr. Smith (Lecturer) is conducting a lecture.
Mr. Jones (Administrator) is managing user accounts.
```

### Exercise 10: Marker Interface (Advanced)

**Question:**
Create a marker interface called `Auditable`.
*   Implement it in a class `Transaction`.
*   Write a method that checks if an object implements `Auditable` and prints "Auditing enabled".
Demonstrate the implementation.

**Code:**
**`Auditable.java`**
```java
public interface Auditable {
    // This is a marker interface, so it doesn't have any methods.
}
```
**`Transaction.java`**
```java
public class Transaction implements Auditable {
    private String transactionId;
    private double amount;

    public Transaction(String transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public void process() {
        System.out.println("Processing transaction " + transactionId + " with amount " + amount);
    }
}
```
**`MarkerInterfaceTest.java`**
```java
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
```
**Output:**
```
Transaction: Auditing enabled
Object: Auditing not enabled
```

---

## Section F: Mini Practical Assignment

### Exercise 11: Mini Project (CAT-Level)

**Question:**
Design a Library Management System using OOP concepts:
*   At least 3 classes
*   At least 1 interface
*   Encapsulation (private attributes)
*   Constructor overloading
*   Submit: Java source code and a brief explanation of how OOP principles were applied

**Code:**
**`Book.java`**
```java
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Constructor with all details
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true; // By default, a new book is available
    }

    // Constructor with title and author (overloading)
    public Book(String title, String author) {
        this(title, author, "N/A"); // Call the main constructor
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setters
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Available: " + isAvailable;
    }
}
```
**`Member.java`**
```java
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<Book> borrowedBooks;

    // Constructor with all details
    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Constructor with only name (overloading)
    public Member(String name) {
        this(name, generateMemberId()); // Call the main constructor with a generated ID
    }

    // A simple method to generate a unique member ID (for demonstration purposes)
    private static String generateMemberId() {
        return "M" + System.currentTimeMillis();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Methods to manage borrowed books
    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println(name + " borrowed: " + book.getTitle());
        } else {
            System.out.println(book.getTitle() + " is currently not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailable(true);
            System.out.println(name + " returned: " + book.getTitle());
        } else {
            System.out.println(name + " did not borrow: " + book.getTitle());
        }
    }

    @Override
    public String toString() {
        return "Member Name: " + name + ", Member ID: " + memberId + ", Books Borrowed: " + borrowedBooks.size();
    }
}
```
**`Searchable.java`**
```java
import java.util.List;

public interface Searchable {
    List<Book> searchBooks(String query);
    List<Member> searchMembers(String query);
}
```
**`Library.java`**
```java
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library implements Searchable {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    // Book management
    public void addBook(Book book) {
        this.books.add(book);
        System.out.println("Added book: " + book.getTitle());
    }

    public void removeBook(Book book) {
        if (this.books.remove(book)) {
            System.out.println("Removed book: " + book.getTitle());
        } else {
            System.out.println("Book not found: " + book.getTitle());
        }
    }

    // Member management
    public void addMember(Member member) {
        this.members.add(member);
        System.out.println("Registered member: " + member.getName());
    }

    public void removeMember(Member member) {
        if (this.members.remove(member)) {
            System.out.println("Deregistered member: " + member.getName());
        } else {
            System.out.println("Member not found: " + member.getName());
        }
    }

    // Borrow and Return
    public void borrowBook(Member member, Book book) {
        member.borrowBook(book);
    }

    public void returnBook(Member member, Book book) {
        member.returnBook(book);
    }

    @Override
    public List<Book> searchBooks(String query) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                                 book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                                 book.getIsbn().contains(query))
                .collect(Collectors.toList());
    }

    @Override
    public List<Member> searchMembers(String query) {
        return members.stream()
                .filter(member -> member.getName().toLowerCase().contains(query.toLowerCase()) ||
                                 member.getMemberId().contains(query))
                .collect(Collectors.toList());
    }

    public void displayAllBooks() {
        System.out.println("\n--- All Books in Library ---");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        books.forEach(System.out::println);
    }

    public void displayAllMembers() {
        System.out.println("\n--- All Members of Library ---");
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        members.forEach(System.out::println);
    }
}
```
**`LibraryTest.java`**
```java
public class LibraryTest {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        // --- Demonstrate Constructor Overloading & Encapsulation (Book) ---
        Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien", "978-0618053267");
        Book book2 = new Book("The Hobbit", "J.R.R. Tolkien"); // Uses overloaded constructor
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.displayAllBooks();

        // --- Demonstrate Member Management (Constructor Overloading & Encapsulation) ---
        Member member1 = new Member("Alice Smith", "M001");
        Member member2 = new Member("Bob Johnson"); // Uses overloaded constructor with auto-generated ID
        myLibrary.addMember(member1);
        myLibrary.addMember(member2);
        myLibrary.displayAllMembers();

        // --- Demonstrate Borrowing and Returning (Interaction between objects) ---
        myLibrary.borrowBook(member1, book1);
        myLibrary.borrowBook(member1, book2);
        myLibrary.borrowBook(member2, book1); // book1 is not available

        myLibrary.displayAllBooks();
        System.out.println("\n" + member1.getName() + "'s borrowed books:");
        member1.getBorrowedBooks().forEach(b -> System.out.println("- " + b.getTitle()));

        myLibrary.returnBook(member1, book1);
        myLibrary.displayAllBooks();
        System.out.println("\n" + member1.getName() + "'s borrowed books:");
        member1.getBorrowedBooks().forEach(b -> System.out.println("- " + b.getTitle()));

        // --- Demonstrate Searchable Interface ---
        System.out.println("\n--- Search Results for 'Lord' ---");
        myLibrary.searchBooks("Lord").forEach(System.out::println);

        System.out.println("\n--- Search Results for 'M001' ---");
        myLibrary.searchMembers("M001").forEach(System.out::println);
    }

    /*
     * Explanation of OOP Principles Applied:
     *
     * 1.  Classes and Objects: The system is built using classes like Book, Member, and Library, which serve as blueprints for creating objects.
     *     Objects (e.g., 'book1', 'member1', 'myLibrary') are instances of these classes, representing real-world entities.
     *
     * 2.  Encapsulation: All attributes (e.g., Book's title, Member's name, Library's lists) are declared as 'private'.
     *     Access to and modification of these attributes are controlled through 'public' getter and setter methods.
     *     This protects the internal state of objects and ensures data integrity.
     *
     * 3.  Abstraction: The 'Searchable' interface provides a contract for searching books and members without revealing the underlying implementation details.
     *     The 'Library' class implements this interface, providing concrete implementations for the search methods. Users of the 'Library' class
     *     interact with the abstract 'Searchable' behavior without needing to know how the searching is performed internally.
     *
     * 4.  Inheritance: Although not explicitly used for class hierarchy in this mini-project (as per the minimal requirement),
     *     the concept is implicitly demonstrated in how 'Book' and 'Member' objects are managed by the 'Library'
     *     and how they interact, representing a "has-a" relationship (composition). If there were different types of books (e.g., EBook, Audiobook),
     *     inheritance would be directly applied.
     *
     * 5.  Polymorphism:
     *     -   Interface Polymorphism: The 'Searchable' interface allows for a common way to interact with different search functionalities.
     *         If other classes were to implement 'Searchable', they could be treated uniformly.
     *     -   Method Overloading (Constructor Overloading): The 'Book' and 'Member' classes have multiple constructors with different parameter lists.
     *         This allows creating objects in various ways, providing flexibility.
     *
     * The system demonstrates a clear separation of concerns, reusability of code (through classes and methods),
     * and maintainability due to well-defined interfaces and encapsulated data.
     */
}
```
**Output:**
```
Added book: The Lord of the Rings
Added book: The Hobbit

--- All Books in Library ---
Title: The Lord of the Rings, Author: J.R.R. Tolkien, ISBN: 978-0618053267, Available: true
Title: The Hobbit, Author: J.R.R. Tolkien, ISBN: N/A, Available: true
Registered member: Alice Smith
Registered member: Bob Johnson

--- All Members of Library ---
Member Name: Alice Smith, Member ID: M001, Books Borrowed: 0
Member Name: Bob Johnson, Member ID: M1770368032402, Books Borrowed: 0
Alice Smith borrowed: The Lord of the Rings
Alice Smith borrowed: The Hobbit
The Lord of the Rings is currently not available.

--- All Books in Library ---
Title: The Lord of the Rings, Author: J.R.R. Tolkien, ISBN: 978-0618053267, Available: false
Title: The Hobbit, Author: J.R.R. Tolkien, ISBN: N/A, Available: false

Alice Smith's borrowed books:
- The Lord of the Rings
- The Hobbit
Alice Smith returned: The Lord of the Rings

--- All Books in Library ---
Title: The Lord of the Rings, Author: J.R.R. Tolkien, ISBN: 978-0618053267, Available: true
Title: The Hobbit, Author: J.R.R. Tolkien, ISBN: N/A, Available: false

Alice Smith's borrowed books:
- The Hobbit

--- Search Results for 'Lord' ---
Title: The Lord of the Rings, Author: J.R.R. Tolkien, ISBN: 978-0618053267, Available: true

--- Search Results for 'M001' ---
Member Name: Alice Smith, Member ID: M001, Books Borrowed: 1
```
