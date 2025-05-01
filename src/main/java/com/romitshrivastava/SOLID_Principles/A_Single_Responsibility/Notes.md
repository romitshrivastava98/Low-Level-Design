# Single Responsibility Principle (SRP)

> **Definition:**  
> "A class should have one, and only one, reason to change."

SRP is the 'S' in SOLID, and it promotes writing classes that serve one specific purpose or responsibility.

---

## What Does SRP Mean?

- **Single Responsibility**: Each class should do only one job.
- **One Reason to Change**: If a class has multiple responsibilities, a change in one can affect the others.

---

## Why SRP Is Important

- Reduces **code complexity**.
- Promotes **easier testing** and **debugging**.
- Makes the system **easier to maintain** and **understand**.
- Encourages **modular and decoupled** code.

---

## Bad Design – Violates SRP

```java
public class Invoice {
    public void calculateTotal() {
        // logic to calculate total
    }

    public void printInvoice() {
        // logic to print invoice
    }

    public void saveToDatabase() {
        // logic to save invoice to DB
    }
}
```

### Problems
- `Invoice` class is doing **calculation**, **printing**, and **persistence**.
- Each of these can change for different reasons:
  - Business logic may change for calculations.
  - Printing format may need updates.
  - Database schema or persistence strategy may evolve.
- All this violates SRP by having **multiple reasons to change**.

---

## Good Design – Follows SRP

### Step 1: Separate Responsibilities

```java
public class Invoice {
    public double calculateTotal() {
        // logic to calculate total
        return 100.0;
    }
}
```

```java
public class InvoicePrinter {
    public void print(Invoice invoice) {
        // logic to print invoice
    }
}
```

```java
public class InvoiceRepository {
    public void save(Invoice invoice) {
        // logic to save invoice to DB
    }
}
```

### Benefits
- Each class is focused on a **single responsibility**.
- Changes to one responsibility do **not affect others**.
- Code is easier to **maintain, test, and extend**.

---

## Benefits of SRP

- **Modularity**: Clear separation of concerns.
- **Maintainability**: Changes are localized.
- **Testability**: Small, focused classes are easier to test.
- **Reusability**: Components are decoupled.

---

## Common Mistakes

- Writing **God Classes** that handle many unrelated tasks.
- Mixing **business logic** and **UI logic** in the same class.
- Ignoring SRP in the name of **convenience or speed**.

---

## Best Practices

- Identify and separate **distinct responsibilities**.
- Use **services** and **helper classes** to delegate tasks.
- Ensure **one reason to change** for each class.
- Refactor regularly to maintain SRP.

---

## Summary

SRP states that a class should have only one reason to change, ensuring focus and simplicity in code. By separating concerns and encapsulating responsibilities, software becomes easier to maintain, extend, and scale.

---

> **Quote to Remember:**  
> "A class should have one, and only one, reason to change." – Robert C. Martin

