# Object-Oriented Programming (OOP) Solutions

This repository contains solutions and exercises related to Object-Oriented Programming (OOP) concepts, likely implemented in Java. The project is structured into two main assignments, each with multiple sections or exercises demonstrating various OOP principles.

## Project Structure

The project is organized into two primary solution directories: `assignment1_solutions` and `assignment2_solutions`.

### `assignment1_solutions/`

This directory contains solutions for Assignment 1, broken down into several sections (a, b, c, d, e, f). Each section focuses on different OOP concepts, often including `.java` source files and their compiled `.class` counterparts, along with accompanying documentation.

-   **`assignment1_report.docx` / `assignment1_report.md`**: Reports or documentation for Assignment 1.
-   **`section_a/`**: Contains explanations related to a specific topic.
    -   `section_a_explanations.md`
-   **`section_b/`**: Likely covers basic class and object interaction.
    -   `BankAccount.java`, `BankTest.java`, `Main.java`, `Student.java` (and their compiled `.class` files)
-   **`section_c/`**: Focuses on interfaces, inheritance, and polymorphism.
    -   `Contractor.java`, `Employee.java`, `InterfaceAsTypeTest.java`, `MultiFunctionPrinter.java`, `Payable.java`, `Printable.java`, `Scannable.java` (and their compiled `.class` files)
-   **`section_d/`**: Deals with shape hierarchies, likely demonstrating inheritance and abstract classes.
    -   `Circle.java`, `NewShape.java`, `Rectangle.java`, `Shape.java`, `ShapeTest.java` (and their compiled `.class` files)
-   **`section_e/`**: Explores marker interfaces, auditing, and user actions.
    -   `Administrator.java`, `Auditable.java`, `Lecturer.java`, `MarkerInterfaceTest.java`, `Student.java`, `Transaction.java`, `UserActions.java`, `UserActionsTest.java` (and their compiled `.class` files)
-   **`section_f/`**: Implements a library system, potentially using interfaces for search functionality.
    -   `Book.java`, `Library.java`, `LibraryTest.java`, `Member.java`, `Searchable.java` (and their compiled `.class` files)

### `assignment2_solutions/`

This directory holds solutions for Assignment 2, organized by exercise number. Similar to Assignment 1, it includes `.java` source files, `.class` files, and sometimes explanation documents.

-   **`assignment2_report.docx` / `assignment2_report.md`**: Reports or documentation for Assignment 2.
-   **`exercise1/`**: Appears to relate to student memory or object lifecycle.
    -   `Student.java`, `StudentMemoryTest.java` (and their compiled `.class` files)
-   **`exercise2/`**: Likely involves a `Book` class and its testing.
    -   `Book.java`, `BookTest.java` (and their compiled `.class` files)
-   **`exercise3/`**: Generic `Main` and `Test` classes.
    -   `Main.java`, `Test.java` (and their compiled `.class` files)
-   **`exercise4/`**: Examples related to garbage collection (`GCExample.java`).
    -   `Demo.java`, `GCExample.java` (and their compiled `.class` files)
-   **`exercise5/`**:
    -   `explanation.txt`
-   **`exercise6/`**:
    -   `explanation.txt`
-   **`exercise7/`**: Focuses on object lifecycle (`TestLifeCycle.java`).
    -   `Sample.java`, `TestLifeCycle.java` (and their compiled `.class` files)
-   **`exercise8/`**: Likely deals with pass-by-value/reference or number manipulation.
    -   `Number.java`, `PassTest.java` (and their compiled `.class` files)
-   **`exercise9/`**:
    -   `explanation.txt`
-   **`exercise10/`**:
    -   `explanation.txt`

## Technologies Used

-   **Java**: The primary programming language for the OOP solutions.

## How to Compile and Run (Java)

To compile and run the Java code, navigate to the directory containing the `.java` files (e.g., `assignment1_solutions/section_b/`) and use a Java Development Kit (JDK):

1.  **Compile**:
    ```bash
    javac YourFileName.java
    ```
    This will generate a `.class` file (e.g., `YourFileName.class`).

2.  **Run**:
    ```bash
    java YourFileName
    ```
    Replace `YourFileName` with the actual name of the Java file containing the `main` method.

Please note that some exercises might require specific classpaths or dependencies, which are not explicitly detailed here but can be inferred from the code within each section.