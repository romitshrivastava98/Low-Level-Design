# 📘 Single Responsibility Principle (SRP) in Java

## 🔹 Definition

**SRP (Single Responsibility Principle)** is the **first** of the SOLID principles of object-oriented design.
> A class should have only **one reason to change**, meaning it should have **only one job or responsibility**.

---

## 🧠 Why SRP is Important?

- Promotes **clean code**
- Improves **maintainability**
- Enables **unit testing** of smaller pieces
- Reduces **code coupling**
- Enhances **modularity** and **readability**

---

## 🚫 Violation Example (Bad Design)

Consider an `Invoice` class that:
- Holds invoice data
- Calculates total
- Prints invoice
- Saves to database

```java
class Invoice {
    String item;
    int quantity;
    double pricePerItem;

    public double calculateTotal() {
        return quantity * pricePerItem;
    }

    public void printInvoice() {
        System.out.println("Invoice: " + item);
    }

    public void saveToFile() {
        System.out.println("Saving to DB...");
    }
}
```

---

## ❌ Problems

- Class has multiple responsibilities: logic, printing, and saving.
- A change in printing logic affects unrelated logic.
- Breaks SRP → difficult to maintain.

---

## ✅ SRP Applied (Good Design)

Break the logic into separate classes, each with a single reason to change:

1. `Invoice` – Handles business logic
2. `InvoicePrinter` – Handles printing
3. `InvoiceRepository` – Handles persistence

### Java Code Example

```java
// 1. Invoice Class
class Invoice {
    private String item;
    private int quantity;
    private double pricePerItem;

    public Invoice(String item, int quantity, double pricePerItem) {
        this.item = item;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public double calculateTotal() {
        return quantity * pricePerItem;
    }

    public String getItem() { return item; }
    public int getQuantity() { return quantity; }
    public double getPricePerItem() { return pricePerItem; }
}

// 2. Printer Class
class InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("------ Invoice ------");
        System.out.println("Item: " + invoice.getItem());
        System.out.println("Quantity: " + invoice.getQuantity());
        System.out.println("Price per Item: " + invoice.getPricePerItem());
        System.out.println("Total: " + invoice.calculateTotal());
        System.out.println("---------------------");
    }
}

// 3. Repository Class
class InvoiceRepository {
    public void save(Invoice invoice) {
        System.out.println("Saving invoice to DB:");
        System.out.println("Item: " + invoice.getItem());
        System.out.println("Total: " + invoice.calculateTotal());
    }
}

// Main Class
public class SRPInvoiceExample {
    public static void main(String[] args) {
        Invoice invoice = new Invoice("Keyboard", 2, 750.0);

        InvoicePrinter printer = new InvoicePrinter();
        printer.print(invoice);

        InvoiceRepository repo = new InvoiceRepository();
        repo.save(invoice);
    }
}
```
## ✅ Benefits of SRP

- Each class is simple and focused
- Easy to test and debug
- Reduced merge conflicts in teams
- Makes code reuse easier
- Helps in scaling code independently

---

## ⚠️ Common Mistakes

- Putting related but distinct logic into a single class
- Thinking that fewer classes = better design
- Believing small apps don't need SRP (always apply SRP from the start)

---

## 📚 Best Practices

- Use **"reason to change"** as a test:  
  _Will printing logic ever change for a different reason than saving logic? If yes, split them._

- Organize classes into layers (e.g., domain, persistence, presentation)
- Start with cohesive, SRP-compliant classes even in prototypes

---

## 🔚 Summary

SRP is not about making every class tiny — it's about making every class focused.

- ✅ One class → One reason to change
- ✅ Split responsibilities cleanly
- ✅ Easier testing, debugging, and scaling

---

## 🧠 Quote to Remember

> "A class should do one thing, and do it well."  
> – Robert C. Martin (Uncle Bob)
