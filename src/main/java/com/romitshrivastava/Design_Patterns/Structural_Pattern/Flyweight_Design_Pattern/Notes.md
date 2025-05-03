## Flyweight Design Pattern (Structural)

### Purpose

The Flyweight pattern is used to minimize memory usage by sharing as much data as possible with similar objects. It is especially useful when working with a large number of objects that share common properties. The key idea is to avoid redundant object creation by reusing existing objects.

---

### When to Use

- When the application needs to create a large number of similar objects.
- When object creation is expensive in terms of memory or performance.
- When most of the object state can be shared and does not change frequently (intrinsic state).
- When remaining state can be externalized and managed by the client (extrinsic state).

---

### Key Concepts

- **Intrinsic State**: The part of the object’s state that is shared and stored inside the flyweight object. This state is independent of the context.
- **Extrinsic State**: The part of the object’s state that is passed in from the outside and varies with context.
- **Flyweight Object**: The shared object that contains intrinsic state.
- **Flyweight Factory**: Manages and provides access to the shared flyweight objects.

---

### Real-Life Analogy

In a word processor, each character you type is displayed on the screen. Instead of creating a new object for every character, the system can share a single object for each character type (A, B, C, etc.) and reuse it. The character position, font color, and size can be passed as extrinsic data during rendering.

---

### Java Example

```java
java
CopyEdit
// Flyweight Interface
interface Shape {
    void draw(String color); // color is extrinsic
}

// Concrete Flyweight
class Circle implements Shape {
    private final String shapeType = "Circle"; // intrinsic
    private final int radius = 5; // intrinsic

    @Override
    public void draw(String color) {
        System.out.println("Drawing " + shapeType + " with color: " + color + " and radius: " + radius);
    }
}

// Flyweight Factory
class ShapeFactory {
    private static final Map<String, Shape> shapeMap = new HashMap<>();

    public static Shape getCircle() {
        Shape circle = shapeMap.get("circle");
        if (circle == null) {
            circle = new Circle();
            shapeMap.put("circle", circle);
            System.out.println("Created new Circle object");
        }
        return circle;
    }
}

// Client Code
public class FlyweightDemo {
    public static void main(String[] args) {
        Shape redCircle = ShapeFactory.getCircle();
        redCircle.draw("Red");

        Shape blueCircle = ShapeFactory.getCircle();
        blueCircle.draw("Blue");

        Shape greenCircle = ShapeFactory.getCircle();
        greenCircle.draw("Green");
    }
}

```

**Output:**

```
pgsql
CopyEdit
Created new Circle object
Drawing Circle with color: Red and radius: 5
Drawing Circle with color: Blue and radius: 5
Drawing Circle with color: Green and radius: 5

```

Only one `Circle` object is created and reused with different colors passed as extrinsic data.

---

### Advantages

- Reduces memory consumption by sharing objects.
- Improves performance when dealing with many similar objects.
- Separates shared state (intrinsic) from context-specific state (extrinsic).

---

### Disadvantages

- Adds complexity to the design.
- Requires careful management of extrinsic state.
- Not suitable if most object states are unique or change frequently.

---

### Common Use Cases

- Text editors (characters with shared font/typeface objects).
- Game development (reusing visual elements like trees, tiles, bullets).
- Caching or pooling systems (e.g., database connections, thread pools).
- GUI components (icons, shapes, buttons with common styles).