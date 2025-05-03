# Bridge Design Pattern

---

## Purpose

The **Bridge Pattern** decouples an abstraction from its implementation so that both can vary independently. It is designed to promote flexibility, extensibility, and cleaner separation of concerns.

This pattern is particularly helpful in preventing the class explosion that results from having multiple combinations of abstractions and implementations.

---

## When to Use

- When you have multiple dimensions of variation (e.g., abstraction and implementation) that need to evolve independently.
- When you want to avoid a large inheritance hierarchy resulting from combinations of features.
- When you want to change either the abstraction or implementation independently at runtime.
- When designing layers of a complex system, such as separating UI logic from platform-specific code.

---

## Real-Life Analogy

Consider a **remote control** (abstraction) and a **television** (implementation).

- Different remotes: BasicRemote, AdvancedRemote
- Different TVs: SonyTV, SamsungTV

Instead of creating a separate remote class for each TV, a bridge is created between the remote and the TV interface, allowing any remote to operate any TV.

---

## Structure

```
lua
CopyEdit
            Abstraction
                |
     -------------------------
     |                       |
RefinedAbstraction      Implementor (interface)
                                |
                        ---------------------
                        |                   |
               ConcreteImplA         ConcreteImplB

```

**Components:**

- **Abstraction**: Defines the interface and holds a reference to the Implementor.
- **RefinedAbstraction**: Extends the Abstraction and may add additional behavior.
- **Implementor**: Interface for implementation classes.
- **ConcreteImplementor**: Provides platform-specific or low-level behavior.

---

## Example Scenario: Shapes and Colors

Problem: You want to allow shapes (Circle, Square) to support different colors (Red, Blue) without creating redundant classes like RedCircle, BlueSquare, etc.

### Color Interface and Implementations

```java
java
CopyEdit
interface Color {
    String fill();
}

class Red implements Color {
    public String fill() {
        return "Color is Red";
    }
}

class Blue implements Color {
    public String fill() {
        return "Color is Blue";
    }
}

```

### Shape Abstraction and Implementations

```java
java
CopyEdit
abstract class Shape {
    protected Color color;
    Shape(Color color) {
        this.color = color;
    }
    abstract void draw();
}

class Circle extends Shape {
    Circle(Color color) {
        super(color);
    }

    public void draw() {
        System.out.println("Drawing Circle. " + color.fill());
    }
}

class Square extends Shape {
    Square(Color color) {
        super(color);
    }

    public void draw() {
        System.out.println("Drawing Square. " + color.fill());
    }
}

```

### Client Code

```java
java
CopyEdit
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new Red());
        Shape blueSquare = new Square(new Blue());

        redCircle.draw();
        blueSquare.draw();
    }
}

```

---

## Key Benefits

- Allows abstraction and implementation to vary independently
- Reduces the number of subclasses required to support combinations
- Promotes loose coupling
- Improves maintainability and scalability
- Adheres to the Open/Closed Principle

---

## Potential Drawbacks

- Increases overall complexity due to more classes and interfaces
- May not be justified for simple systems with limited variation

---

## Key Interview Questions and Answers

**1. What is the Bridge pattern and how does it decouple abstraction from implementation?**

The Bridge pattern is a structural design pattern that separates the abstraction (high-level interface) from its implementation (low-level details). This is done by defining two separate hierarchies and connecting them through a bridge interface. This allows changes in either layer without affecting the other.

**2. What is the difference between the Bridge pattern and the Adapter pattern?**

| Aspect | Bridge Pattern | Adapter Pattern |
| --- | --- | --- |
| Purpose | Decouples abstraction from implementation | Converts one interface into another |
| Use Case | Planned flexibility in design architecture | Legacy or third-party integration |
| Timing | Applied at design time | Typically used at runtime |
| Structure | Two separate hierarchies connected by bridge | One class adapts another |

**3. How would you implement the Bridge pattern in Java?**

Create an interface for the implementation layer. Implement multiple concrete classes from that interface. Then, create an abstraction class that holds a reference to the interface. Subclasses of the abstraction can then delegate work to the implementation.

**4. When would you use the Bridge pattern in a real project?**

- Designing cross-platform libraries or frameworks
- GUI systems where the same abstraction must support different rendering engines
- Plug-in architectures where implementations vary per platform or version

**5. What are the key benefits of using the Bridge pattern in large systems?**

- Enables independent development of abstraction and implementation
- Reduces class explosion
- Simplifies code maintenance
- Supports runtime binding of implementation
- Makes systems easier to extend and adapt to new requirements