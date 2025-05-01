# 📘 Open/Closed Principle (OCP)

## 🧠 Definition

> **"Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification."**  
> — Bertrand Meyer

This means you should be able to **extend** the behavior of a system **without modifying** existing source code.

---

## ❌ Problems When OCP Is Ignored

- Every new feature (e.g., new country) requires changing existing code.
- Increases the risk of breaking existing features.
- Violates **separation of concerns**.
- Hinders scalability and maintainability.

---

## 🔧 Real-World Scenario: Tax Calculation

### ❌ Bad Design – Violates OCP

```java
class TaxCalculatorBad {
    public double calculateTax(String country, double income) {
        if (country.equalsIgnoreCase("India")) {
            return income * 0.10;
        } else if (country.equalsIgnoreCase("USA")) {
            return income * 0.15;
        } else if (country.equalsIgnoreCase("Germany")) {
            return income * 0.20;
        }
        return 0;
    }
}
```

## 🚨 Issues in Bad Design

- Adding a new country (e.g., Japan) means editing `calculateTax()` again.
- Method becomes bloated and error-prone.
- Breaks **Open/Closed Principle**.

---

## ✅ Good Design – Follows OCP

```java
// Interface
interface TaxPolicy {
    double calculateTax(double income);
}

// Implementations
class IndiaTaxPolicy implements TaxPolicy {
    public double calculateTax(double income) {
        return income * 0.10;
    }
}

class USATaxPolicy implements TaxPolicy {
    public double calculateTax(double income) {
        return income * 0.15;
    }
}

class GermanyTaxPolicy implements TaxPolicy {
    public double calculateTax(double income) {
        return income * 0.20;
    }
}

class JapanTaxPolicy implements TaxPolicy {
    public double calculateTax(double income) {
        return income * 0.18;
    }
}

// Tax Calculator using abstraction
class TaxCalculator {
    private TaxPolicy taxPolicy;

    public TaxCalculator(TaxPolicy taxPolicy) {
        this.taxPolicy = taxPolicy;
    }

    public double calculate(double income) {
        return taxPolicy.calculateTax(income);
    }
}
```

### ✅ Usage

```java
public class OCPTaxApp {
    public static void main(String[] args) {
        double income = 100000;

        TaxCalculator indiaTax = new TaxCalculator(new IndiaTaxPolicy());
        TaxCalculator usaTax = new TaxCalculator(new USATaxPolicy());
        TaxCalculator germanyTax = new TaxCalculator(new GermanyTaxPolicy());
        TaxCalculator japanTax = new TaxCalculator(new JapanTaxPolicy());

        System.out.println("India Tax: ₹" + indiaTax.calculate(income));
        System.out.println("USA Tax: $" + usaTax.calculate(income));
        System.out.println("Germany Tax: €" + germanyTax.calculate(income));
        System.out.println("Japan Tax: ¥" + japanTax.calculate(income));
    }
}
```

---

## 🔍 More Real-World Scenarios for OCP

| Feature              | Bad Design Responsibility         | Good Design Classes                            |
|----------------------|-----------------------------------|--------------------------------------------------|
| Payment Gateway       | Switch/case for each provider     | `PaymentGateway`, `PayPal`, `Stripe`, `RazorPay` |
| Notification Service  | One class sends all notifications | `Notification`, `EmailSender`, `SMSSender`       |
| Sorting Algorithms    | One method with many if-else      | `Sorter`, `BubbleSort`, `QuickSort`, etc.        |
| Shipping Calculator   | Logic inside `OrderService`       | `ShippingService`, `FedExCalculator`, etc.       |

---

## ✅ Benefits of OCP

- 🔄 Avoids modifying existing tested code
- 📦 Promotes modular and pluggable design
- 🚀 Scalable: easy to add new features
- 🔒 Minimizes risk of regression
- 🧪 Easier unit testing with interface-driven development

---

## ⚠️ Common Mistakes

- Using `if-else` or `switch` for extensible behavior
- Not using interfaces or abstraction
- Extending via inheritance without using composition or delegation

---

## 📚 Best Practices

- Use **interfaces** and **polymorphism**
- Apply **strategy pattern**, **factory pattern**, or **template pattern**
- Encapsulate varying behavior in new classes
- Make core components **immutable** and only extend via composition

---

## 🔚 Summary

- ✅ "Open for extension, closed for modification"
- ✅ Use interfaces and polymorphism to extend behavior
- ✅ Avoid large methods with many conditionals
- ✅ Helps in building clean, modular systems

---

## 🧠 Quote to Remember

> "Good software design minimizes the amount of code you need to change when requirements change."  
> — Robert C. Martin (Uncle Bob)
