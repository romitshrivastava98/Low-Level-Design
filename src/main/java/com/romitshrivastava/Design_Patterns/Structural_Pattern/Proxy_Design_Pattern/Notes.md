## Proxy Design Pattern

**Purpose**

The **Proxy Pattern** provides a **surrogate or placeholder** for another object to control access to it. It is often used to:

- **Lazy initialization**: Delay the creation of an object until it’s actually needed.
- **Access control**: Restrict access to sensitive objects.
- **Logging**: Add functionality like logging, caching, or authentication without modifying the real object.

---

### Common Use Cases:

- **Lazy loading**: Delaying the creation of expensive objects until they are needed.
- **Access control**: Restricting access to an object based on certain conditions (e.g., authentication).
- **Virtual proxy**: Delaying object initialization to save resources.
- **Remote proxy**: Representing an object located in a different address space (e.g., a distributed object).
- **Protection proxy**: Enforcing security checks and access control.

---

### Example Scenario

In an **image viewer application**, a proxy could represent a large image file. The proxy would load the actual image from disk only when it needs to be displayed on the screen, saving memory and processing power.

---

### Real-Life Analogy

Imagine you're trying to access a building:

- You don't interact directly with the building; instead, you interact with a **security guard** at the entrance.
- The security guard checks your credentials (ID) before letting you in.
- The security guard acts as a **proxy**, controlling access to the building.

---

### When to Use the Proxy Pattern?

✅ **Use the Proxy Pattern when:**

- You want to **control access** to an object.
- You need to **add functionalities** like logging, authentication, or caching without modifying the real object.
- You want to **defer** the creation of expensive objects or delay expensive operations until needed (lazy loading).

---

### Proxy Pattern Types:

1. **Virtual Proxy**
    - **Purpose**: Delays the creation of an expensive object until it’s actually needed (e.g., large images, database objects).
2. **Remote Proxy**
    - **Purpose**: Represents an object in a different address space (e.g., objects in a distributed system or network services).
3. **Protection Proxy**
    - **Purpose**: Controls access to an object, enforcing security or permissions (e.g., allowing access only for authorized users).

---

### Java Implementation Example

### Real Subject:

```java
java
CopyEdit
class RealSubject {
    public void request() {
        System.out.println("RealSubject: Handling the request.");
    }
}

```

### Proxy:

```java
java
CopyEdit
class ProxySubject extends RealSubject {
    private RealSubject realSubject;

    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject(); // Lazy initialization
        }
        System.out.println("Proxy: Delegating the request to the RealSubject.");
        realSubject.request();
    }
}

```

### Client:

```java
java
CopyEdit
public class Client {
    public static void main(String[] args) {
        ProxySubject proxy = new ProxySubject();
        proxy.request();  // Lazy initialization, request made when needed
    }
}

```

---

### Advantages of the Proxy Pattern:

- **Control**: Provides controlled access to objects, allowing additional functionality like lazy loading, caching, and access control.
- **Separation of concerns**: Adds responsibilities such as security or logging without modifying the real object.
- **Performance improvement**: Through lazy initialization, the system can improve resource management, especially when handling resource-heavy objects.

---

### Potential Downsides:

- **Complexity**: Adding a proxy introduces an extra layer of abstraction, which can complicate the system, making it harder to debug or maintain.
- **Performance Overhead**: The proxy introduces a level of indirection that may result in slight performance overhead, especially when dealing with large numbers of requests.
- **Overuse**: If proxies are overused, they might lead to unnecessary complexity, especially in cases where simpler solutions might suffice.

---

### Key Questions to Prepare:

**1) What is the Proxy pattern and how does it control access to objects?**

The Proxy pattern provides a surrogate for an object, controlling access through additional logic. It’s useful for implementing lazy loading, access control, and other additional features.

**2) How does a Virtual Proxy differ from a Remote Proxy and Protection Proxy?**

- **Virtual Proxy**: Delays object creation until needed, improving resource efficiency.
- **Remote Proxy**: Represents an object located in a different address space (e.g., networked systems).
- **Protection Proxy**: Adds access control, ensuring only authorized clients can interact with the object.

**3) Can you provide an example of implementing the Proxy pattern in Java?**

In Java, you can implement the Proxy pattern by creating a proxy class that delegates method calls to a real object, optionally adding extra logic such as lazy initialization or security checks.

**4) When would you use the Proxy pattern in real-world applications?**

The Proxy pattern is beneficial when you need to delay initialization of expensive objects (virtual proxy), manage remote communication (remote proxy), or enforce security and access control (protection proxy).

**5) What are the potential downsides of using the Proxy pattern?**

The Proxy pattern introduces additional complexity and potential performance overhead due to the extra layer of indirection, which might complicate debugging and maintenance.