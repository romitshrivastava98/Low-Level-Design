# Adapter Pattern

### **Purpose:**

The **Adapter Pattern** allows objects with incompatible interfaces to collaborate by creating an adapter that bridges the gap between them. It enables interaction between two systems without modifying their existing interfaces or code.

### **Common Use Cases:**

- Integrating third-party libraries into an existing application.
- Connecting legacy or outdated systems with new interfaces.
- Allowing classes with different interfaces to communicate.
- Reusing existing code while adapting it to new systems or requirements.

### **Example Scenario:**

Imagine you're working with a payment gateway that doesn’t match the expected interface in your application. By using the Adapter pattern, you can integrate the third-party payment gateway without modifying its code.

---

### **Intent (Purpose):**

To enable two incompatible systems to work together by converting one interface to another, allowing for **communication between systems that wouldn't normally be able to interact**.

> Analogy: Just like a mobile charger adapter, which allows your phone’s USB-C charger to fit into a socket that provides AC power, the Adapter pattern converts the interfaces between systems so they can interact.
>

---

### **When to Use Adapter Pattern:**

- **When you need to integrate new or third-party code** that doesn’t match the interface your code expects.
- **When dealing with legacy systems** that need to work with new interfaces or systems.
- **To promote code reusability** without altering existing code.
- **When you need to allow communication** between two systems that would otherwise be incompatible.

---

### **Advantages:**

- **Reusability**: Reuse existing code without modifying it.
- **Open/Closed Principle**: Keeps existing systems open for extension, but closed for modification.
- **Flexibility**: Enables integration of legacy and modern systems together without modification.

### **Disadvantages:**

- **Complexity**: Too many adapters can make the system harder to maintain and manage.
- **Maintenance**: Over time, the adapter logic may become complex and harder to manage for large systems.

---

### **Comparison with Other Patterns:**

### **Adapter vs. Decorator:**

- **Adapter Pattern**: Used to make one interface compatible with another by converting interfaces and facilitating communication between incompatible systems.
- **Decorator Pattern**: Adds new functionality to an object dynamically, without altering its structure. While the Adapter focuses on compatibility, the Decorator focuses on enhancing functionality.

---

### **Types of Adapter Patterns:**

1. **Class Adapter**: Uses **inheritance** to adapt interfaces by extending both the target and adaptee classes. It directly integrates the functionalities of both classes.
    - **Pros**: It is faster to implement since it uses inheritance.
    - **Cons**: It limits flexibility, as it can only be used with the specific classes that it is designed to extend.
2. **Object Adapter**: Uses **composition** to adapt interfaces. It holds a reference to an instance of the adaptee class and implements the target interface, delegating calls to the adaptee.
    - **Pros**: It is more flexible, as it can work with any subclass of the adaptee.
    - **Cons**: It requires more setup compared to class adapters.

---

### **Example of Adapter Pattern in Java:**

Suppose you have a Java application that uses a modern logging framework, but you're integrating an outdated logging module that doesn't match the modern framework's interface. Here's how you can use the Adapter pattern:

### 1. **Target Interface (Modern Logging Framework):**

```java
java
CopyEdit
public interface ModernLogger {
    void log(String message);
}

```

### 2. **Adaptee (Old Logging System):**

```java
java
CopyEdit
public class OldLogger {
    public void writeLog(String message) {
        System.out.println("Logging message: " + message);
    }
}

```

### 3. **Adapter Class (Bridges Old and Modern Systems):**

```java
java
CopyEdit
public class LoggerAdapter implements ModernLogger {
    private OldLogger oldLogger;

    public LoggerAdapter(OldLogger oldLogger) {
        this.oldLogger = oldLogger;
    }

    @Override
    public void log(String message) {
        oldLogger.writeLog(message);  // Adapting the old logger to the modern interface
    }
}

```

### 4. **Client Code (Using the Adapter to Log Messages):**

```java
java
CopyEdit
public class LoggerTest {
    public static void main(String[] args) {
        OldLogger oldLogger = new OldLogger();
        ModernLogger modernLogger = new LoggerAdapter(oldLogger);  // Using the adapter
        modernLogger.log("This is an adapted log message.");
    }
}

```

---

### **Key Takeaways:**

- **Adapter Pattern** makes incompatible systems work together by converting one interface to another.
- It’s useful for integrating **third-party libraries** or **legacy code** with modern systems without modifying the existing codebase.
- **Class and Object Adapters** provide different ways of achieving this goal—class adapters use inheritance, while object adapters use composition.
- The Adapter pattern helps with **code reusability** and **flexibility**, but too many adapters can increase system complexity.



### **Frequently Asked Questions on Adapter Pattern:**

### **1) What is the Adapter Pattern and when would you use it?**

**Answer:**

The Adapter pattern is a design pattern that allows objects with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces by converting one class's interface into another that the client expects. You would use the Adapter pattern when you need to integrate new or third-party code that has a different interface than the one your system expects, enabling them to work together without modifying either the external code or your existing system.

### **2) How does the Adapter Pattern differ from the Decorator Pattern?**

**Answer:**

- **Adapter Pattern**: Its main purpose is to make an incompatible interface compatible. The adapter converts one interface into another, allowing systems that normally cannot interact to work together.
- **Decorator Pattern**: It is used to dynamically add new functionality to an object without altering its structure. The Decorator pattern wraps an object to add additional behavior while maintaining its original interface.

**Difference**: The Adapter pattern focuses on interface compatibility, while the Decorator pattern focuses on enhancing the behavior of an object.

### **3) Can you provide an example of using the Adapter Pattern in Java?**

**Answer:**

Suppose you are integrating an old logging system (Adaptee) into your modern logging framework (Target Interface). The Adapter pattern allows you to use the old system with the new interface. The adapter will convert the old system's method calls into the new system's format without modifying either system.

For instance:

```java
java
CopyEdit
public interface ModernLogger {
    void log(String message);
}

public class OldLogger {
    public void writeLog(String message) {
        System.out.println("Logging message: " + message);
    }
}

public class LoggerAdapter implements ModernLogger {
    private OldLogger oldLogger;

    public LoggerAdapter(OldLogger oldLogger) {
        this.oldLogger = oldLogger;
    }

    @Override
    public void log(String message) {
        oldLogger.writeLog(message);  // Adapting the old logger to the modern interface
    }
}

```

### **4) What are the two types of adapters (class and object adapters), and how do they differ?**

**Answer:**

- **Class Adapter**: Uses **inheritance** to adapt interfaces. It extends both the target and adaptee classes, directly integrating their functionalities. However, it has limitations as it only works for specific classes.
- **Object Adapter**: Uses **composition** to adapt interfaces. It holds a reference to an instance of the adaptee class and implements the target interface, delegating calls to the adaptee. This type is more flexible as it can work with any subclass of the adaptee.

### **5) Why is the Adapter Pattern useful when integrating third-party libraries?**

**Answer:**

The Adapter pattern is particularly useful when integrating third-party libraries because it allows you to connect the library’s interface with your application's interface without modifying either the third-party code or your existing system. The adapter acts as a middleman, translating requests from your system into a format the library understands, ensuring smooth integration while maintaining consistency in your codebase.