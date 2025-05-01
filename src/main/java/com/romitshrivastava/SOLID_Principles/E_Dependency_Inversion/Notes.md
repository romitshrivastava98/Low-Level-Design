## Dependency Inversion Principle (DIP)

### Definition
The **Dependency Inversion Principle** states:

> High-level modules should not depend on low-level modules. Both should depend on abstractions.  
> Abstractions should not depend on details. Details should depend on abstractions.

This principle decouples high-level policy from low-level implementation by introducing interfaces or abstract classes.

---

### Real-World Analogy

- **Bad Analogy**: A manager (high-level) directly instructs a specific worker (low-level) like a carpenter.
- **Good Analogy**: A manager gives tasks to an interface (e.g., "construction worker"), and any suitable worker (carpenter, electrician) can fulfill the role.

---

### Motivation

Without DIP:
- High-level modules are tightly coupled to low-level modules.
- Changing implementations (e.g., switching email to SMS) requires modifying the high-level logic.
- Testing becomes harder due to hardcoded dependencies.

With DIP:
- High-level modules depend on interfaces/abstractions.
- Low-level modules implement those interfaces.
- Code becomes flexible, testable, and maintainable.

---

### Example: Notification System

#### Problematic Design (Violates DIP)

```java
class EmailSender {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

class OrderService {
    private EmailSender emailSender = new EmailSender(); // Tightly coupled

    public void placeOrder() {
        emailSender.send("Order placed!");
    }
}
```

**Issues**:
- High-level `OrderService` directly depends on low-level `EmailSender`.
- Hard to replace `EmailSender` with `SMSSender`, `PushNotifier`, etc.
- Difficult to test `OrderService` in isolation.

---

#### DIP-Compliant Design

```java
interface Notifier {
    void send(String message);
}

class EmailSender implements Notifier {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SMSSender implements Notifier {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class OrderService {
    private Notifier notifier;

    public OrderService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void placeOrder() {
        notifier.send("Order placed!");
    }
}
```

**Usage**:

```java
Notifier email = new EmailSender();
OrderService service = new OrderService(email);
service.placeOrder();
```

---

### Best Practices

- Always depend on abstractions (interfaces or abstract classes), not concrete implementations.
- Inject dependencies using **constructor injection**, **setter injection**, or **dependency injection frameworks** (like Spring).
- Keep high-level modules independent of specific low-level behaviors.
- In test code, use mocks/stubs for abstractions.

---

### Common Mistakes

- Injecting concrete classes instead of interfaces.
- Creating instances of dependencies directly in the high-level class.
- Overusing static methods which cannot be replaced with abstractions.

---

### Benefits of DIP

| Benefit       | Description                                           |
|---------------|-------------------------------------------------------|
| Loose Coupling | High-level and low-level modules evolve independently |
| Testability   | Interfaces make mocking easier in unit testing       |
| Flexibility   | Easily switch or extend behavior without code change |
| Reusability   | Abstract modules can be reused in different contexts |
| Maintainability | Clear separation of concerns makes refactoring easier |

---

### Summary

- DIP decouples modules through abstraction.
- High-level classes should not instantiate low-level ones.
- Use interfaces and dependency injection to achieve flexibility.

---

### Quote to Remember

> "Depend upon abstractions. Do not depend upon concretions."  
> — Robert C. Martin (Uncle Bob)

