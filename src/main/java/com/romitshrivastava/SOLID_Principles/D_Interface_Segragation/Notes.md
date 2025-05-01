# Interface Segregation Principle (ISP)

## 🔑 Definition
**"Clients should not be forced to depend upon interfaces that they do not use."**  
— *Robert C. Martin (Uncle Bob)*

The Interface Segregation Principle is the fourth principle in SOLID. It suggests that interfaces should be client-specific rather than general-purpose. In other words, break large interfaces into smaller ones so that implementing classes only need to be concerned with the methods that are relevant to them.

---

## 🚫 Problem with Violating ISP

### Example of a Bad Interface
```java
interface Vehicle {
    void drive();
    void sail();
    void fly();
}

class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving a car");
    }

    public void sail() {
        throw new UnsupportedOperationException();
    }

    public void fly() {
        throw new UnsupportedOperationException();
    }
}
```

### ❌ Problems:
- The `Car` class is forced to implement methods it doesn’t use.
- Violates **ISP** — unnecessary method implementations.
- Can lead to **runtime errors** (e.g., unsupported operations).
- Breaks the **Single Responsibility Principle** by doing too much.

---

## ✅ Applying ISP — Good Design

### Step 1: Split Fat Interface into Role-Specific Interfaces
```java
interface Drivable {
    void drive();
}

interface Sailable {
    void sail();
}

interface Flyable {
    void fly();
}
```

### Step 2: Implement Only What You Need
```java
class Car implements Drivable {
    public void drive() {
        System.out.println("Driving a car");
    }
}

class Boat implements Sailable {
    public void sail() {
        System.out.println("Sailing a boat");
    }
}

class Plane implements Flyable {
    public void fly() {
        System.out.println("Flying a plane");
    }
}
```

### ✅ Benefits
- No unnecessary method implementations
- Cleaner, modular, and extendable code
- Safer: No more `UnsupportedOperationException`
- Easier to test and maintain

---

## 🛠 Real-World Scenarios

| Use Case            | Bad Design                             | Good Design                                |
|---------------------|-----------------------------------------|---------------------------------------------|
| **Vehicle**         | One interface with `drive()`, `fly()`   | `Drivable`, `Flyable`, `Sailable`           |
| **Printer**         | Interface with `print()`, `scan()`      | `Printable`, `Scannable`, `Faxable`         |
| **Media Player**    | Interface with `playAudio()`, `playVideo()` | `AudioPlayer`, `VideoPlayer`          |
| **Payment Gateway** | Interface with all payment types        | Split by `CreditCardPayment`, `UPIPayment`  |
| **Repository**      | `save()`, `delete()`, `read()` all in one | `ReadableRepo`, `WritableRepo`             |

---

## 📦 Benefits of ISP

- ✅ **High Cohesion**: Interfaces do one job well
- ✅ **Low Coupling**: Clients know only what they need
- ✅ **More Reusable Code**: Components are plug-and-play
- ✅ **Unit Testing Friendly**: Easier to mock and test
- ✅ **Extensible and Scalable**: Easy to add new interfaces

---

## ⚠️ Common Mistakes

- Using **large interfaces** that try to be everything to everyone
- Throwing **UnsupportedOperationException**
- Implementing **empty methods** just to satisfy contracts
- Not applying **composition** over inheritance

---

## 💡 Best Practices

- Design **focused interfaces** around a single role or responsibility
- Use **composition** to bring together capabilities
- Pair with **Dependency Inversion** to further decouple
- Leverage **design patterns**: Strategy, Bridge, Adapter

---

## 🧠 Summary

| ✅ Principle | ✅ Practice |
|-------------|------------|
| "Interfaces should be client-specific" | Split fat interfaces into smaller, role-specific ones |

- Break interfaces down into **manageable units**
- Let classes only implement **what they use**
- Avoid code that exists **only to fulfill contracts**

---

## 🧠 Quote to Remember
> "Fat interfaces are a sign of trouble. The more methods a class has to implement unnecessarily, the more fragile the code becomes."  
> — Robert C. Martin

