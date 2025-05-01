# Open/Closed Principle (OCP)

> **Definition:**
> "Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification." — Bertrand Meyer

This principle encourages you to design modules that can be extended, without changing their source code.

---

## What Does OCP Mean?

- **Open for extension**: Class behavior can be extended.
- **Closed for modification**: Existing source code should not be changed.

---

## Why OCP Is Important

- Maintains existing functionality, reducing bugs.
- Easy to extend with new features.
- Improves system flexibility.
- Stabilizes core logic during changes.

---

## Bad Design – Violates OCP

```java
public class Shape {
    public int type;  // 1 for rectangle, 2 for circle

    public int calculateArea() {
        if (type == 1) {
            return 10 * 5;
        } else if (type == 2) {
            return (int)(Math.PI * Math.pow(5, 2));
        }
        return 0;
    }
}
```

### Problems
- Adding a new shape means modifying `calculateArea()`.
- Every change risks breaking existing logic.
- Violates OCP due to frequent modifications.

---

## Good Design – Follows OCP

### Step 1: Define an Interface
```java
public interface Shape {
    double calculateArea();
}
```

### Step 2: Implement Specific Shapes
```java
public class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }
}
```

```java
public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
```

### Benefits
- Add new shapes without touching existing classes.
- Leverages polymorphism to keep code clean.

---

## Benefits of OCP

- **Scalability**: Easy to add new features.
- **Maintainability**: Stable and clean structure.
- **Reduced Bugs**: Less risk when extending functionality.

---

## Common Mistakes

- Modifying instead of extending classes.
- Ignoring polymorphism — cramming logic into one class.
- Large classes with mixed responsibilities.

---

## Best Practices

- Use **interfaces** and **abstractions**.
- Apply **polymorphism** to delegate behavior.
- Keep classes **small** and **focused**.
- Favor **composition** over inheritance.

---

## Summary

- OCP encourages extending behavior without modifying code.
- Leads to flexible, modular, and safer systems.
- Use patterns like Strategy, Decorator, and Factory to support OCP.

---

> **Quote to Remember:**
> "Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification." – Bertrand Meyer

