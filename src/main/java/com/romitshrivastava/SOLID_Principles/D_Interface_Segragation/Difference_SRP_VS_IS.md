## Difference Between Single Responsibility Principle and Interface Segregation Principle

The **Single Responsibility Principle (SRP)** and the **Interface Segregation Principle (ISP)** are both foundational concepts within the SOLID principles of object-oriented design. While they are related in promoting maintainable and scalable systems, they address different concerns in software architecture.

---

### Single Responsibility Principle (SRP)

**Definition:**  
A class should have only one reason to change, meaning it should encapsulate only one responsibility or functionality.

**Purpose:**  
To ensure that a class is focused and cohesive. Each class should do one thing well and should not be burdened with multiple, unrelated concerns.

**Key Characteristics:**
- Promotes separation of concerns.
- Makes classes easier to understand, maintain, and test.
- Reduces the impact of changes; changes in one responsibility won’t affect unrelated behaviors.

**Common Symptoms of SRP Violation:**
- A class has methods that deal with unrelated concerns (e.g., database logic, logging, and UI formatting).
- Making a change for one behavior causes regression in another, unrelated part.

**Example:**  
A `Report` class that is responsible for:
- Storing report data
- Formatting the report as PDF
- Emailing the report to stakeholders

This violates SRP. These should be separated into:
- `ReportData`
- `ReportFormatter`
- `ReportEmailer`

---

### Interface Segregation Principle (ISP)

**Definition:**  
Clients should not be forced to depend on interfaces they do not use.

**Purpose:**  
To prevent the design of large, monolithic interfaces that require implementing classes to define methods that may not be relevant to them.

**Key Characteristics:**
- Encourages the design of role-specific, fine-grained interfaces.
- Reduces implementation burden on classes.
- Improves flexibility and extensibility of codebases.

**Common Symptoms of ISP Violation:**
- Classes implement methods that throw `UnsupportedOperationException`.
- Interface changes require unnecessary changes in unrelated classes.
- “Fat” interfaces that serve multiple, unrelated consumers.

**Example:**  
A `Vehicle` interface that declares:
- `startEngine()`
- `fly()`
- `drive()`

A `Car` class implementing this interface would be forced to define a `fly()` method, even though it cannot fly. This violates ISP. A better design would be to split interfaces:
- `Drivable`
- `Flyable`
- `Sailable`

Classes implement only the interfaces relevant to them.

---

### Summary Comparison

| Aspect                      | Single Responsibility Principle (SRP)                     | Interface Segregation Principle (ISP)                      |
|----------------------------|-----------------------------------------------------------|------------------------------------------------------------|
| Concern                    | Separation of responsibilities within a class             | Design of interfaces to avoid irrelevant dependencies       |
| Target                     | Class design                                              | Interface design                                            |
| Key Objective              | One class = One reason to change                          | One client = One fit-for-purpose interface                 |
| Violation Consequence      | Difficult to modify or extend a class safely              | Classes forced to implement unnecessary behavior           |
| Solution                   | Split responsibilities into separate classes              | Split interfaces into role-specific abstractions           |
| Example Problem            | A service class also handles logging and email            | A `Bird` interface requires all birds to `fly()`           |
| Solution Strategy          | Apply composition and cohesion                            | Apply role-based interfaces and delegation                 |

---

### Conclusion

- **SRP** is about ensuring each **class** has a well-defined, focused responsibility.
- **ISP** is about ensuring each **interface** is tailored to the specific needs of its clients.

While SRP deals with *what* a class is responsible for, ISP deals with *how* interfaces are designed for consumption. Together, they contribute to clean, modular, and scalable systems.

