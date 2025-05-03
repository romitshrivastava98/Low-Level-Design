**Decorator Design Pattern - Final Notes**

**Purpose**

The Decorator Pattern allows behavior to be added to individual objects dynamically, without affecting the behavior of other objects from the same class. It is a flexible alternative to subclassing for extending functionality.

**Common Use Cases**

- Extending functionalities in a flexible and reusable manner
- Adding responsibilities to an object without altering its structure
- Java I/O classes (e.g., wrapping `FileInputStream` with `BufferedInputStream`)
- GUI toolkits for adding visual features like borders or scrollbars

**Example Scenario**

Dynamically adding features like compression or encryption to a file stream without modifying the original class.

**Real-Life Analogy**

Think of a coffee shop:

- You start with a base coffee
- You can decorate it with milk, sugar, whipped cream, etc.
- Each topping adds behavior
- You can stack them in any order

**When to Use Decorator Pattern**

Use when:

- You want to add behavior at runtime without altering the original class
- You want to follow the Open/Closed Principle (open for extension, closed for modification)
- You want flexible combinations of behavior instead of rigid subclassing

**Definition**

The Decorator Pattern is a structural pattern that allows dynamic addition of responsibilities to objects by wrapping them in decorator classes that implement the same interface.

---

**Implementation in Java**

1. **Component (Interface or Abstract Class)**

```java
java
CopyEdit
interface Coffee {
    String getDescription();
    double getCost();
}

```

1. **ConcreteComponent**

```java
java
CopyEdit
class BasicCoffee implements Coffee {
    public String getDescription() {
        return "Basic Coffee";
    }

    public double getCost() {
        return 5.0;
    }
}

```

1. **Abstract Decorator**

```java
java
CopyEdit
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }

    public double getCost() {
        return coffee.getCost();
    }
}

```

1. **Concrete Decorators**

```java
java
CopyEdit
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    public double getCost() {
        return super.getCost() + 1.5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    public double getCost() {
        return super.getCost() + 0.5;
    }
}

```

1. **Client Code**

```java
java
CopyEdit
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription()); // Basic Coffee, Milk, Sugar
        System.out.println(coffee.getCost());        // 7.0
    }
}

```

---

**Advantages**

- Allows dynamic and flexible behavior extension
- Promotes the Open/Closed Principle
- Avoids subclass explosion
- Enables combining features in various ways
- Behavior can be added per object

**Drawbacks**

- Can result in many small classes
- Complexity increases with too many layers
- Debugging may become harder due to recursive wrapping

---

**Interview Questions**

1. **What is the Decorator Pattern and how does it differ from inheritance?**

   The Decorator pattern adds functionality to objects dynamically by wrapping them with new features. It differs from inheritance because it works at runtime and affects only the specific instance, avoiding rigid and deep inheritance trees.

2. **How would you implement the Decorator Pattern in Java?**

   Define a common interface, create concrete components that implement it, and then create decorators that also implement the interface and wrap the component. Each decorator enhances or extends behavior before/after delegating to the wrapped object.

3. **What are the advantages of using the Decorator Pattern for extending behavior?**
- Allows runtime behavior changes
- Encourages reusable, modular code
- Avoids code duplication
- Enables composition over inheritance
- Promotes clean separation of concerns
1. **Can you provide a real-world example of the Decorator Pattern?**

   A coffee ordering system: Start with basic coffee, then apply decorators like milk or sugar. Each decorator adds cost and description, modifying the behavior of the coffee object dynamically without altering its structure.

2. **How does the Decorator Pattern promote flexibility in extending object behavior?**

   It allows behaviors to be layered on individual objects dynamically. You can create any combination of decorators, enabling high flexibility and control over object behavior without modifying existing code.