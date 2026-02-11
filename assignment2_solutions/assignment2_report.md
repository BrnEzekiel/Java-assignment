# Assignment 2: Memory and Object Lifecycle in Java - Solutions

**Note on Code Snippets:** Due to the nature of this AI environment, I cannot provide "snaps" (screenshots) of code as requested. All code examples are embedded directly as text within Markdown code blocks. If a visual representation of the code were strictly required, a human would typically insert screenshots here.

---

## Exercise 1: Object Creation and Constructors (Basics) 

**Question:**
a) Define what happens in memory when an object is created using the `new` keyword in Java.
b) Write a Java class `Student` with instance variables `name`, `regNo` and a constructor to initialize them.
c) Create two objects of the class and explain whether they share memory.

**Answer (a) - What happens in memory when an object is created using `new`:**
When the `new` keyword is used in Java to create an object:
1.  **Memory Allocation:** The Java Virtual Machine (JVM) allocates memory on the **heap** for the new object. This memory includes space for all instance variables (both inherited and declared in the class) and any overhead required by the JVM.
2.  **Memory Initialization (Zero-filling):** All instance variables of the newly allocated object are initialized to their default values (e.g., `0` for numeric primitives, `false` for boolean, `null` for reference types).
3.  **Constructor Execution:** The constructor of the class is invoked to initialize the object's state, typically by assigning meaningful values to its instance variables.
4.  **Reference Return:** The `new` operator returns a **reference** (memory address) to the newly created and initialized object.

**Code (b) - `Student` class:**
**`Student.java`**
```java
public class Student {
    String name;
    String regNo;

    // Constructor to initialize instance variables
    public Student(String name, String regNo) {
        this.name = name;
        this.regNo = regNo;
    }

    public void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Registration No: " + regNo);
    }
}
```

**Code & Explanation (c) - Creating objects and memory sharing:**
**`StudentMemoryTest.java`**
```java
public class StudentMemoryTest {
    public static void main(String[] args) {
        // Create two Student objects
        Student student1 = new Student("Alice", "1001");
        Student student2 = new Student("Bob", "1002");

        System.out.println("Details of Student 1:");
        student1.displayDetails();

        System.out.println("\nDetails of Student 2:");
        student2.displayDetails();

        /*
         * Explanation of memory sharing:
         *
         * No, student1 and student2 objects do NOT share memory for their instance data.
         *
         * When 'new Student("Alice", "1001")' is executed, a new Student object is created
         * on the heap memory, and its instance variables ('name' and 'regNo') are allocated
         * and initialized within that specific object's memory space. The 'student1' variable
         * then holds a reference (memory address) to this unique object.
         *
         * Similarly, when 'new Student("Bob", "1002")' is executed, another completely separate
         * Student object is created on the heap, at a different memory location. Its own
         * instance variables are allocated and initialized independently. The 'student2' variable
         * holds a reference to this second unique object.
         *
         * While both 'student1' and 'student2' are of the 'Student' type and share the same
         * class definition (blueprint), they are distinct objects in memory, each with its
         * own copy of instance variables. Changes to 'student1.name' will not affect 'student2.name'
         * because they reside in different memory locations.
         *
         * The only "shared" aspect is the class definition itself, which is loaded once
         * into memory (e.g., method code), but the data for each object is independent.
         */
    }
}
```
**Output:**
```
Details of Student 1:
Student Name: Alice
Registration No: 1001

Details of Student 2:
Student Name: Bob
Registration No: 1002
```

---

## Exercise 2: Default vs Parameterized Constructors

**Question:**
Consider the following class:
```java
class Book {
    String title;
    int pages;
}
```
a) What values will `title` and `pages` have when an object is created?
b) Modify the class to include a parameterized constructor.
c) Explain how constructors affect object initialization in memory.

**Answer (a) - Default values without a constructor:**
If an object of the `Book` class is created without an explicit constructor being defined, the instance variables will be initialized to their **default values**:
*   `title` (a `String`, a reference type) will have the value `null`.
*   `pages` (an `int`, a primitive type) will have the value `0`.

**Code (b) - `Book` class with parameterized constructor:**
**`Book.java`**
```java
public class Book {
    String title;
    int pages;

    // Parameterized constructor
    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Pages: " + pages);
    }
}
```

**Explanation (c) - How constructors affect object initialization in memory:**
Constructors play a crucial role in object initialization in memory by allowing developers to set the initial state of an object in a controlled and meaningful way. After the JVM allocates memory for an object and initializes its instance variables to default values, the constructor is immediately invoked. Its primary purpose is to establish a valid initial state for the object by assigning meaningful values to its instance variables, overriding the default initialization. Constructors also help in enforcing constraints and injecting dependencies, ensuring the object is ready for use as soon as it's created.

**Code to demonstrate (c):**
**`BookTest.java`**
```java
public class BookTest {
    public static void main(String[] args) {
        // Book object created using the parameterized constructor
        Book myBook = new Book("The Java Programming Language", 1200);
        System.out.println("Book details after constructor initialization:");
        myBook.displayBookDetails();
    }
}
```
**Output:**
```
Book details after constructor initialization:
Title: The Java Programming Language
Pages: 1200
```

---

## Exercise 3: Java References

**Question:**
Study the code below:
```java
class Test {
    int x;
}
public class Main {
    public static void main(String[] args) {
        Test t1 = new Test();
        t1.x = 10;

        Test t2 = t1;
        t2.x = 20;

        System.out.println(t1.x);
    }
}
```
a) Predict the output.
b) Explain the role of references in this program.
c) Draw a simple memory diagram showing heap and stack usage.

**Answer (a) - Predicted Output:**
```
20
```

**Answer (b) - Role of references in this program:**
In this program, `t1` and `t2` are **reference variables**. They do not store the `Test` objects themselves, but rather store the memory addresses of where the `Test` object resides in the heap.
*   `t1 = new Test();` creates an object on the heap and `t1` points to it.
*   `t2 = t1;` copies the memory address from `t1` to `t2`. Now both `t1` and `t2` point to the *exact same* `Test` object on the heap.
Any modification made to the object through `t1` will be visible through `t2`, and vice-versa, because they are manipulating the same underlying object data.

**Answer (c) - Simple memory diagram showing heap and stack usage:**

**Stack Memory:**
*   `main` method frame:
    *   `t1`: A reference variable storing a memory address (e.g., `0x1000`).
    *   `t2`: A reference variable storing the *same* memory address (e.g., `0x1000`).

**Heap Memory:**
*   At memory address `0x1000`:
    *   `Test` Object:
        *   `x`: `20`

---

## Exercise 4: Object Eligibility for Garbage Collection

**Question:**
Consider the code:
```java
class Demo {
    int value;
}
public class GCExample {
    public static void main(String[] args) {
        new Demo();
        Demo d1 = new Demo();
        Demo d2 = new Demo();

        d1 = null;
        d2 = d1;
    }
}
```
a) At what point does an object become eligible for garbage collection?
b) How many objects are eligible for garbage collection at the end of the program?
c) Justify your answer.

**Answer (a) - Object eligibility for garbage collection:**
An object becomes eligible for garbage collection when there are no longer any strong references pointing to it from any active part of the program (e.g., from local variables on the stack, static variables, or other objects on the heap that are themselves reachable). If a program can no longer access or use an object, it becomes eligible for GC.

**Answer (b) - Number of eligible objects:**
At the end of the `main` method in `GCExample.java`, **three (3)** `Demo` objects are eligible for garbage collection.

**Answer (c) - Justification:**
1.  `new Demo();`: A `Demo` object (Object A) is created but never referenced by any variable. It is immediately eligible for GC.
2.  `Demo d1 = new Demo();`: A `Demo` object (Object B) is created and referenced by `d1`.
3.  `Demo d2 = new Demo();`: A `Demo` object (Object C) is created and referenced by `d2`.
4.  `d1 = null;`: The reference `d1` is set to `null`. Object B is no longer referenced, making it eligible for GC.
5.  `d2 = d1;`: The `null` value of `d1` is assigned to `d2`. Object C is no longer referenced, making it eligible for GC.
Therefore, all three `Demo` objects become unreferenced and eligible for garbage collection by the end of the `main` method.

---

## Exercise 5: Garbage Collection Concepts

**Question:**
a) Define garbage collection in Java.
b) Explain two conditions under which an object becomes eligible for garbage collection.
c) Why does Java not allow programmers to explicitly destroy objects?

**Answer (a) - Definition of garbage collection:**
Garbage Collection (GC) in Java is an automatic memory management process that identifies and reclaims memory occupied by objects that are no longer referenced or reachable by the running program. Its primary purpose is to free up memory resources, preventing memory leaks and allowing developers to focus on application logic rather than manual memory deallocation.

**Answer (b) - Two conditions for GC eligibility:**
1.  **No Strong References:** An object becomes eligible when all strong reference variables pointing to it are set to `null`, go out of scope, or are reassigned to other objects.
2.  **Island of Isolation:** A group of objects that refer to each other but are not referenced by any external live objects in the program (forming a cycle) become eligible for GC.

**Answer (c) - Why Java disallows explicit object destruction:**
Java does not allow programmers to explicitly destroy objects for several key reasons:
*   **Prevention of Memory Leaks and Dangling Pointers:** Automating memory management reduces errors like forgetting to deallocate memory (leaks) or deallocating too early (dangling pointers).
*   **Improved Program Robustness and Security:** It minimizes memory-related bugs, making applications more stable and secure.
*   **Simplicity for Developers:** Developers can focus on business logic rather than complex, error-prone memory management.
*   **Platform Independence and JVM Optimization:** The JVM's highly optimized garbage collector works efficiently across platforms, and manual destruction would interfere with these optimizations.

---

## Exercise 6: `finalize()` Method (Conceptual)

**Question:**
a) What is the purpose of the `finalize()` method?
b) Why is the use of `finalize()` discouraged in modern Java?
c) State one alternative mechanism for resource management.

**Answer (a) - Purpose of `finalize()`:**
The `finalize()` method was intended to perform cleanup operations on an object just before it is garbage collected, typically for releasing non-Java resources (like file handles or network connections) that were not automatically managed by Java's garbage collector.

**Answer (b) - Why `finalize()` is discouraged:**
The use of `finalize()` is strongly discouraged due to:
*   **Unpredictable Execution Time:** There's no guarantee when or if `finalize()` will be called.
*   **Performance Overhead:** It can introduce significant performance penalties.
*   **Potential for Resource Leaks:** Unreliable execution can lead to critical resources remaining open.
*   **Security Vulnerabilities:** It can be exploited to "resurrect" objects, preventing GC.
*   **Exceptions in Finalizers:** Exceptions are ignored, potentially leaving objects in an inconsistent state.

**Answer (c) - Alternative mechanism for resource management:**
One highly recommended alternative is the **try-with-resources statement** (introduced in Java 7). It ensures that a resource (any object implementing `java.lang.AutoCloseable`) is automatically closed at the end of the `try` block, guaranteeing its release regardless of normal completion or exceptions.

---

## Exercise 7: Constructors and Object Lifecycle Order

**Question:**
Given the following code:
```java
class Sample {
    Sample() {
        System.out.println("Constructor called");
    }
}
public class TestLifeCycle {
    public static void main(String[] args) {
        Sample s = new Sample();
        s = null;
        System.gc();
        System.out.println("End of main method.");
    }
}
```
a) Identify the stages of the object lifecycle illustrated in this program.
b) Is garbage collection guaranteed to occur after calling `System.gc()`? Explain.

**Answer (a) - Object lifecycle stages illustrated:**
1.  **Creation and Initialization:** `Sample s = new Sample();` - Memory allocated, constructor executed.
2.  **Eligibility for Garbage Collection:** `s = null;` - The `Sample` object becomes unreferenced and thus eligible for GC.
3.  **Finalization (Potential) & Deallocation:** `System.gc();` - A hint for GC to run, potentially leading to `finalize()` calls (if overridden) and subsequent memory deallocation.

**Answer (b) - Is garbage collection guaranteed after `System.gc()`?**
**No, garbage collection is NOT guaranteed to occur after calling `System.gc()`**. The `System.gc()` method is merely a **hint** or a **suggestion** to the Java Virtual Machine (JVM) that it would be a good time to perform garbage collection. The JVM is free to ignore this hint, and the actual decision of when to run the garbage collector is left entirely to the JVM's discretion based on factors like memory pressure and its internal algorithms. Relying on `System.gc()` for timely resource release is unreliable.

---

## Exercise 8: Pass-by-Value and Object References

**Question:**
Consider:
```java
class Number {
    int value;
}
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
```
a) Predict the output.
b) Explain how Java handles object references when passed to methods.
c) Does Java support pass-by-reference? Justify your answer.

**Answer (a) - Predicted Output:**
```
50
```

**Answer (b) - How Java handles object references when passed to methods:**
Java is strictly "pass-by-value." When an object reference is passed to a method, a *copy* of the reference (the memory address) is passed. Both the method's parameter and the original variable then point to the *same object* on the heap. Therefore, if the method modifies the *object's state* (e.g., `n.value = 50;`), these changes are visible outside the method because the modification occurs on the shared object. However, reassigning the *parameter itself* to a *new object* inside the method would only affect the local parameter, not the original variable.

**Answer (c) - Does Java support pass-by-reference? Justify:**
**No, Java does not support pass-by-reference.** Java is **strictly pass-by-value**. The confusion arises because when objects are passed, changes to the object's state are reflected externally. This is because a *copy of the object's reference* (memory address) was passed by value, making both the original variable and the parameter point to the *same object*. If Java were pass-by-reference, reassigning the method parameter to a *new object* would also make the original variable point to that new object, which does not happen in Java.

---

## Exercise 9: Stack vs Heap Memory

**Question:**
a) Distinguish between stack memory and heap memory in Java.
b) State two items stored in stack memory and two items stored in heap memory.
c) Why are local variables destroyed before objects?

**Answer (a) - Distinguishing Stack vs Heap Memory:**
| Feature             | Stack Memory                                       | Heap Memory                                          |
| :------------------ | :------------------------------------------------- | :--------------------------------------------------- |
| **Purpose**         | Stores local variables, method call information, and primitive data values. Holds references to objects on the heap. | Stores all objects created by the `new` keyword and their instance variables.                      |
| **Lifecycle**       | LIFO (Last-In, First-Out) order. Data is allocated when a method is called and deallocated when it returns. | Managed by the Garbage Collector. Objects persist as long as they are reachable.          |
| **Access Speed**    | Faster access                                      | Slower access compared to stack                      |
| **Memory Mgmt.**    | Automatic (JVM handles allocation/deallocation)    | Automatic (Garbage Collector handles deallocation)   |
| **Thread Specific** | Each thread has its own private stack              | Shared among all threads                             |

**Answer (b) - Items stored in Stack and Heap memory:**
*   **Stack Memory:** Local primitive variables (`int x`), Method parameters (`String[] args`).
*   **Heap Memory:** All objects (`new MyObject()`), Instance variables (fields of an object).

**Answer (c) - Why local variables are destroyed before objects:**
Local variables are stored on the **stack** and are part of a method's stack frame. When a method completes, its stack frame is popped, and all local variables within it are immediately destroyed/become inaccessible. Objects, however, are stored on the **heap** and are managed by the Garbage Collector. An object is only destroyed when it is no longer reachable by any strong references. Thus, a local variable (reference) is destroyed with its stack frame, but the object it pointed to on the heap persists until the GC determines it's unreferenced.

---

## Exercise 10: Short Answer

**Question:**
Answer any five:
1.  What is an object lifecycle in Java?
2.  What is a constructor?
3.  What happens if no constructor is defined in a class?
4.  What is a reference variable?
5.  State one role of the garbage collector.
6.  What does `System.gc()` do?

**Answers (chosen 1, 2, 3, 4, 5):**

**1. What is an object lifecycle in Java?**
The object lifecycle in Java refers to the various stages an object goes through from its creation (memory allocation, constructor execution), through its active use, to becoming eligible for garbage collection (no strong references), potential finalization, and ultimately deallocation of its memory by the Garbage Collector.

**2. What is a constructor?**
A constructor in Java is a special method automatically invoked when an object is created. Its purpose is to initialize the newly created object's state, ensuring it starts in a valid and consistent condition by setting initial values for its instance variables.

**3. What happens if no constructor is defined in a class?**
If no constructor is explicitly defined in a class, the Java compiler automatically provides a **default no-argument constructor**. This ensures that objects can still be created, and this default constructor calls the no-argument constructor of its superclass.

**4. What is a reference variable?**
A reference variable in Java is a variable that stores the memory address (or a reference) of an object on the heap. It acts as a handle to an object, allowing the program to interact with it, rather than storing the object's actual data directly.

**5. State one role of the garbage collector.**
One primary role of the garbage collector in Java is **automatic memory management**. It automatically identifies and reclaims memory occupied by objects that are no longer referenced by the running program, thereby preventing memory leaks and simplifying memory management for developers.
