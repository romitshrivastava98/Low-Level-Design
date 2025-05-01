# Interface Segregation Principle (ISP)

## Introduction
The Interface Segregation Principle (ISP) is one of the SOLID principles of object-oriented design. It advocates that no client should be forced to depend on methods it does not use. In other words, classes should not be burdened with interfaces that require them to implement methods they do not need.

ISP is a way of reducing the impact of changes by splitting large, complex interfaces into smaller, more specific ones that are tailored to particular client needs.

## What is Interface Segregation Principle?
The principle states:

> "Clients should not be forced to depend on interfaces they do not use."

Instead of having one large, all-encompassing interface, ISP encourages breaking the interface down into smaller, more specific interfaces that clients can implement based on their needs. This minimizes the number of unused methods that clients may be forced to implement.

## Key Characteristics of ISP
- **Focused Interfaces**: An interface should only include methods that are relevant to the implementing class. Clients should implement only the functionality they require.
- **Client-Specific Interfaces**: Design interfaces specific to the needs of different client types instead of one "catch-all" interface.
- **Loose Coupling**: ISP leads to better separation of concerns by ensuring that classes are not unnecessarily coupled to methods that they will not use.

## Benefits of ISP
- **Improved Maintainability**: By designing smaller and more focused interfaces, changes in a client’s requirements will not break unrelated implementations.
- **Increased Flexibility**: Clients can choose to implement only the interfaces that meet their needs, leading to more flexible and adaptable code.
- **Reduced Code Duplication**: Specialized interfaces avoid the need for redundant code in implementing classes that do not require certain methods.
- **Easier Testing**: Testing is simplified as smaller interfaces reduce the complexity of the classes being tested.

## Example Scenarios for ISP

### 1. Bad Design: Vehicle Interface Example
Consider a scenario where we are dealing with different types of vehicles. Initially, a single Vehicle interface is created with several methods related to different vehicle functionalities. However, not all vehicles will need to implement all methods.

#### Bad Design (One large interface):

```java
// Vehicle interface with unrelated methods
public interface Vehicle {
    void start();
    void stop();
    void fly();
    void sail();
}

// Car class implementing Vehicle interface
public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    @Override
    public void fly() {
        // Not applicable for Car, but forced to implement
    }

    @Override
    public void sail() {
        // Not applicable for Car, but forced to implement
    }
}

// Boat class implementing Vehicle interface
public class Boat implements Vehicle {
    @Override
    public void start() {
        System.out.println("Boat started");
    }

    @Override
    public void stop() {
        System.out.println("Boat stopped");
    }

    @Override
    public void fly() {
        // Not applicable for Boat, but forced to implement
    }

    @Override
    public void sail() {
        System.out.println("Boat sailing");
    }
}
```

In this example, both Car and Boat are forced to implement methods (`fly()` and `sail()`) that do not apply to their respective classes, violating ISP.

### Good Design: Applying ISP

To follow ISP, we split the `Vehicle` interface into more focused interfaces. Each class only implements the interfaces that are relevant to it.

### Good Design (Applying ISP):

```java
// Vehicle interface for common methods
public interface Vehicle {
    void start();
    void stop();
}

// Flight interface for vehicles that can fly
public interface Flyable {
    void fly();
}

// Sailing interface for vehicles that can sail
public interface Sailable {
    void sail();
}

// Car class implementing only Vehicle interface
public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
}

// Boat class implementing Vehicle and Sailable interfaces
public class Boat implements Vehicle, Sailable {
    @Override
    public void start() {
        System.out.println("Boat started");
    }

    @Override
    public void stop() {
        System.out.println("Boat stopped");
    }

    @Override
    public void sail() {
        System.out.println("Boat sailing");
    }
}

// Airplane class implementing Vehicle and Flyable interfaces
public class Airplane implements Vehicle, Flyable {
    @Override
    public void start() {
        System.out.println("Airplane started");
    }

    @Override
    public void stop() {
        System.out.println("Airplane stopped");
    }

    @Override
    public void fly() {
        System.out.println("Airplane flying");
    }
}
```
## Explanation:
The `Vehicle` interface now contains only the essential methods shared by all vehicles: `start()` and `stop()`.

The `Flyable` interface contains the `fly()` method for air-based vehicles, while the `Sailable` interface contains the `sail()` method for water-based vehicles.

Now, `Car` only implements `Vehicle`, `Boat` implements `Vehicle` and `Sailable`, and `Airplane` implements `Vehicle` and `Flyable`. Each class only has to implement what is relevant to it.

## More Real-World Scenarios

### 1. Bad Design: Employee Management System
In a company, you might have different roles like Manager, Developer, and Tester. A large interface that includes methods for all roles might look like this:

```java
public interface Employee {
    void writeCode();
    void testCode();
    void manageTeam();
    void conductMeetings();
}
```

### Bad Design: Employee Management System
The Manager is forced to implement methods like `writeCode()` and `testCode()`, and the Developer is forced to implement `manageTeam()` and `conductMeetings()` — neither of which make sense for their roles.

### 2. Good Design: Role-Specific Interfaces
The `Employee` interface can be divided into more specific roles:

```java
public interface Developer {
    void writeCode();
    void testCode();
}

public interface Manager {
    void manageTeam();
    void conductMeetings();
}

public interface Tester {
    void testCode();
}
```

### Each role implements only the relevant interface, respecting the Interface Segregation Principle.

## Benefits of ISP
- **High Cohesion**: By splitting interfaces based on functionality, classes become more cohesive and focused on specific tasks.
- **Flexibility**: New types of clients can implement only the interfaces that are relevant to them without having to deal with unnecessary methods.
- **Low Coupling**: Reduces the dependency between unrelated classes, making the codebase more decoupled and easier to maintain.
- **Improved Code Readability**: Smaller interfaces that deal with one responsibility are easier to read and understand.
- **Easier Refactoring**: Changing a single method in a large interface won’t require changing all implementing classes. Instead, refactoring is localized to the relevant interface.

## Common Mistakes
- **Creating Large Interfaces**: Designing interfaces with too many methods, causing unrelated clients to implement methods they don't need.
- **Lack of Granularity**: Not breaking down large interfaces into smaller, more specific ones when the need arises.
- **Overuse of Inheritance**: Relying too heavily on class inheritance for interface implementation rather than using composition and delegation.

## Best Practices
- **Divide Interfaces by Responsibility**: Ensure that each interface only includes methods relevant to the client using it.
- **Use Multiple Interfaces**: Don’t try to create a one-size-fits-all interface. Create specific interfaces for specific client needs.
- **Refactor Unused Methods**: If you notice a class implementing methods that are irrelevant to its functionality, split the interface into smaller, more appropriate interfaces.
- **Use Interface Segregation Early**: Apply ISP in the early stages of design, as it’s harder to refactor interfaces after they have been widely implemented.

## Summary
ISP ensures that classes are not forced to implement unnecessary methods, improving flexibility and maintainability.

Small, client-specific interfaces help prevent bloat and reduce coupling between unrelated classes.

The goal of ISP is to design software in a way that allows classes to implement only the methods that are relevant to them, avoiding unnecessary dependencies.

### Quote to Remember:
"Clients should not be forced to depend on methods they do not use." – Robert C. Martin (Uncle Bob)
