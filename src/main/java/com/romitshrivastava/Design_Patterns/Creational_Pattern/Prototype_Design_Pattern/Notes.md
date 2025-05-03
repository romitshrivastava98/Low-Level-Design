# Prototype Design Pattern (Creational)

## Intent / Purpose

The **Prototype Pattern** is a **creational design pattern** that is used to create **duplicate (clone) objects** while ensuring **performance optimization**. It lets you create new objects by copying an existing prototype instance instead of constructing one from scratch.

### Why use it?
- Avoid overhead of expensive object creation (e.g., database/network-heavy or computation-heavy objects).
- Clone objects dynamically at runtime.
- Enable instantiation of objects without binding code to their specific classes.

## Real-World Example

**Scenario:** In a game, instead of creating a new tree object for every forest tree, you clone one preconfigured `Tree` object (with textures, properties, etc.) for all trees to reduce load and speed up performance.

## Key Concepts

- **Prototype**: The base type or interface that declares the `clone()` method.
- **Concrete Prototype**: Implements the cloning logic (shallow or deep).
- **Client**: Uses the `clone()` method to create new objects.

## Advantages

- Improves performance for **resource-intensive objects**.
- Avoids subclassing for object creation.
- Simplifies object creation logic.
- Useful for **object registries** or **dynamic class instantiation**.

## Disadvantages

- Deep cloning can be **complex** to implement.
- Requires careful handling of **object references** (mutable fields).
- Maintenance overhead as class structure evolves.

## Shallow vs Deep Copy

| Type          | Description                                                                 | Use Case                                       |
|---------------|-----------------------------------------------------------------------------|------------------------------------------------|
| **Shallow**   | Copies primitive fields & references. Nested objects are **shared**.        | Faster, but shared references can be risky.    |
| **Deep**      | Recursively copies **all fields** and nested objects.                       | Slower but **safe** — full independence.       |

## Java Implementation

### 1. Prototype Interface
```java
public interface Prototype extends Cloneable {
    Prototype clone();
}
```

### 2. Concrete Class
```java
public class Employee implements Prototype {
    private int id;
    private String name;
    private Department department;

    public Employee(int id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    @Override
    public Prototype clone() {
        try {
            return (Prototype) super.clone(); // Shallow copy
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + department.getName();
    }
}
```

### 3. Department Class
```java
public class Department {
    private String name;
    public Department(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
```

### 4. Client Code
```java
public class Main {
    public static void main(String[] args) {
        Department devDept = new Department("Development");
        Employee original = new Employee(1, "John", devDept);

        Employee clone = (Employee) original.clone();
        clone.setName("Doe");

        System.out.println("Original: " + original);
        System.out.println("Clone   : " + clone);
    }
}
```

**Output:**
```
Original: 1 - John - Development
Clone   : 1 - Doe - Development
```

**Note:** Both still point to the same Department object due to shallow copy.

## Deep Copy (Manual Example)
```java
@Override
public Prototype clone() {
    Department newDept = new Department(this.department.getName());
    return new Employee(this.id, this.name, newDept);
}
```

## Common Use Cases

- Game development (cloning complex entities like characters or trees).
- GUI libraries (copying pre-configured widgets).
- Document editors (cloning templates).
- Spring Framework internal bean creation.

## Interview Q&A

**Q1. What is the Prototype pattern and how does it work?**  
The Prototype Pattern creates new objects by cloning an existing object (prototype) instead of using constructors. This is useful when object creation is expensive.

**Q2. What's the difference between shallow and deep cloning?**  
Shallow copy duplicates only primitive fields and object references. Deep copy duplicates the entire object graph, making the clone completely independent.

**Q3. How is the Prototype pattern implemented in Java?**  
By implementing the `Cloneable` interface and overriding the `clone()` method in the object’s class.

**Q4. When would you use the Prototype pattern over a constructor?**  
When object construction is expensive, repeated often, or you want to preserve the state of an object before duplication.

**Q5. What are common pitfalls?**  
Improper deep cloning, shared mutable references in shallow copies, and clone logic complexity as object models evolve.