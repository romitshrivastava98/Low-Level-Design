### Strategy Pattern — Master Notes

### Purpose

The **Strategy Pattern** is a behavioral design pattern that defines a family of algorithms, encapsulates each one, and makes them interchangeable. This allows the algorithm to vary independently from the client using it, promoting flexibility, testability, and clean code.

### When to Use

Use the Strategy pattern when:

- You have multiple ways to perform the same task.
- You want to avoid if-else or switch statements for algorithm selection.
- You want to dynamically change behavior at runtime.
- You want to follow the Open/Closed Principle: new behavior without modifying existing code.

### Common Use Cases

- Payment processing (Credit Card, UPI, PayPal, etc.)
- Sorting algorithms (QuickSort, MergeSort, BubbleSort)
- Compression strategies (ZIP, RAR, 7z)
- Validation rules (e.g., input validation strategies for different formats)
- Navigation routes (Driving, Walking, Cycling)

### Real-Life Analogy

A **Navigation App** (like Google Maps):

- You select how you want to reach your destination: Driving, Walking, or Cycling.
- Each route is a different strategy that gets you from Point A to Point B using its own algorithm.
- You can switch the strategy at runtime without changing the app itself.

### Java Implementation (Code Example)

```java
java
CopyEdit
// Strategy Interface
public interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategies
public class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

public class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using PayPal.");
    }
}

public class GooglePayPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Google Pay.");
    }
}

// Context Class
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(2000); // Output: Paid ₹2000 using PayPal.
    }
}

```

### Comparison: Strategy Pattern vs Template Method

| Feature | Strategy Pattern | Template Method Pattern |
| --- | --- | --- |
| Behavior Control | Composition-based (uses objects) | Inheritance-based (uses abstract classes) |
| Algorithm Flexibility | High — change at runtime | Low — fixed algorithm structure |
| Client Role | Chooses which strategy to use | Cannot modify steps; relies on base class |
| Usage Example | Payment types, sorting algorithms | Data processing pipelines, UI component rendering |

### Interview-Friendly Q&A Highlights

- **What is the Strategy Pattern and when would you use it?**

  A pattern that allows you to define a family of algorithms and switch between them dynamically. Use it when multiple algorithms are needed for a task, and you want to keep the client clean and extensible.

- **Difference from Template Method?**

  Strategy uses composition and is flexible at runtime; Template Method uses inheritance and is fixed at compile time.

- **Java Implementation Steps?**
    - Create a Strategy interface.
    - Implement concrete strategies.
    - Use a context class to hold a reference to the strategy.
    - Allow dynamic strategy injection via setters or constructors.
- **Benefits of Strategy Pattern?**
    - Promotes OCP (Open/Closed Principle).
    - Eliminates complex conditional logic.
    - Improves testability (each strategy can be unit tested).
    - Makes the system more modular and easier to extend.
- **Real Example?**

  In an e-commerce app, payment methods like Credit Card, UPI, and Net Banking can be modeled as strategies. The user selects one at checkout, and the system processes the payment without any if-else logic.