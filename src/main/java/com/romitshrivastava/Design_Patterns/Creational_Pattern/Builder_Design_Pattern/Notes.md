
# Builder Design Pattern (Creational)

## Purpose / Intent

The **Builder Pattern** is a **creational design pattern** that **separates the construction of a complex object from its representation**, allowing the same construction process to create different representations.

### When to Use

- When an object requires **many parameters** for instantiation.
- When some parameters are **optional** or combinations may vary.
- When object creation is **complex** and needs to be handled step-by-step.
- To avoid the **telescoping constructor anti-pattern** (multiple constructors with increasing parameters).
- When construction logic involves **validation or transformation**.

---

## Key Idea

Rather than passing everything via constructor (which can get confusing), use a builder class to set desired fields and then call `.build()` to get the final object.

---

## Common Use Cases

- Creating objects that require multiple steps or configurations.
- Simplifying object creation where constructors have many parameters.
- Providing a clean, readable API for object construction.
- Handling objects where different combinations of parameters lead to different representations.

---

## Example Scenario

Imagine creating a `Car` object with many optional features like:
- Sunroof
- GPS
- Engine type

Using the Builder pattern lets you configure each aspect step-by-step.

---

## Java Implementation Example

```java
public class User {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phone;
    private final String address;

    private User(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public static class Builder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        public Builder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Age: " + age +
               ", Phone: " + phone + ", Address: " + address;
    }
}
```

### Client Code

```java
public class Main {
    public static void main(String[] args) {
        User user = new User.Builder("John", "Doe")
                        .age(30)
                        .phone("123456789")
                        .address("New York")
                        .build();

        System.out.println(user);
    }
}
```

---

## Advantages

- Helps in **constructing immutable objects**.
- Makes object creation **more readable** and **maintainable**.
- Avoids constructor overloading and long parameter lists.
- Can enforce **validation rules** at build time.
- Builder can be reused for **different object representations**.

## Disadvantages

- Introduces **extra classes or code**, especially for simple objects.
- Slightly more complex design and setup.

---

## Comparison: Builder vs Factory vs Prototype

| Pattern     | Purpose                                | Flexibility         | Use Case Example                        |
|-------------|----------------------------------------|----------------------|------------------------------------------|
| Factory     | Creates object by choosing subclass     | Medium               | ShapeFactory for Circle, Square, etc.   |
| Prototype   | Clones object                           | Medium-High          | Copying graphical object with state      |
| Builder     | Step-by-step construction of object     | Very High            | Creating complex User/Meal/Document etc. |

---

## Interview Q&A

### 1) What is the Builder pattern and when would you use it?

The Builder pattern is used to construct complex objects step by step, separating the construction from its representation. It's ideal when an object has many parameters, especially optional ones, or when the object needs to be created through a controlled sequence.

### 2) How does the Builder pattern differ from the Factory pattern?

While the Factory pattern is used to create objects based on conditions or input and focuses on subclasses and inheritance, the Builder pattern is used to construct **a single complex object** by specifying parts step-by-step. Factory is about **which object to make**, Builder is about **how to make it**.

### 3) What are the benefits of using the Builder pattern for constructing complex objects?

- Separation of concerns between construction and representation.
- Allows step-by-step customization.
- Enables creation of immutable objects.
- Cleaner code when many optional parameters are involved.

### 4) Can you explain how method chaining works in the Builder pattern?

Method chaining works by returning the current instance (`this`) from each setter method in the builder. This allows multiple method calls in one line:

```java
User user = new User.Builder("John", "Doe")
                .age(30)
                .phone("123456789")
                .build();
```

Each method sets a value and returns the same builder object, enabling a fluent interface.

### 5) Provide an example of when using a Builder pattern is preferable over multiple constructors.

When building a `Computer` object with optional components like SSD, HDD, RAM, GPU, etc., using constructors would lead to many overloads. A Builder allows specifying only the needed options, improving maintainability and reducing errors.

---

## Real-World Examples in Java

- `StringBuilder`
- `StringBuffer`
- `ProcessBuilder`
- `java.nio.ByteBuffer`

---
