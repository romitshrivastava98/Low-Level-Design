### Purpose:

The **Template Method Pattern** defines the skeleton of an algorithm in a method, allowing subclasses to redefine certain steps without changing the algorithm's structure. This pattern is designed to control the flow of the algorithm while allowing subclasses to fill in the details of specific steps.

### Common Use Cases:

- Implementing algorithms that have a fixed structure but allow variation in specific steps.
- Handling tasks like file parsing or report generation where the general process is the same, but details may vary.
- Frameworks where the overall process is known but certain steps need to be customized or extended by the user.

### Example Scenario:

Imagine a `DataParser` class that provides the structure for reading and processing data, allowing subclasses to implement specific file formats like CSV or XML. The general algorithm—open file, read data, process, save—remains unchanged, but how data is read and processed will vary based on the file format.

The **Template Method Pattern** defines the skeleton of an algorithm in a base class, allowing subclasses to redefine certain steps of the algorithm without changing its overall structure.

### Real-Life Analogy:

Making tea vs. coffee:

- **Boil water**
- **Brew drink (tea/coffee)** → varies
- **Pour in cup**
- **Add condiments** → varies

The skeleton of boiling water and pouring it into a cup is fixed, but **some steps differ** depending on the drink type.

---

### Interview-Friendly Q&A

1. **What is the Template Method pattern and when would you use it?**

   The Template Method pattern defines the skeleton of an algorithm in a method, with specific steps implemented by subclasses. This pattern allows the overall structure to remain the same while letting subclasses override or customize certain steps. You would use the Template Method pattern when you have a consistent process that requires specific variations in certain parts, such as in algorithms, workflows, or report generation, ensuring code reuse and flexibility while maintaining control over the process.

   **My Input**: One of the key strengths of this pattern is that it helps standardize and control workflows while still allowing for flexibility in implementation details. It's especially useful in frameworks or libraries where you want users to customize certain steps but follow the general flow defined by the base class. For example, in a GUI framework, a "paint" method might define the overall structure for drawing shapes, but each shape's drawing logic is handled by subclasses.

2. **How does the Template Method pattern differ from the Strategy pattern?**

   The Template Method pattern defines the structure of an algorithm in a superclass, allowing subclasses to override specific steps while keeping the overall process consistent. It's useful when multiple classes share the same process but need to customize certain parts. You would use it for tasks like report generation or data processing, where the general workflow remains the same, but specific steps need to be customized by subclasses.

   **My Input**: The main difference lies in the flexibility of the algorithm. In the **Template Method**, the structure is fixed and subclasses only override specific steps. In contrast, the **Strategy Pattern** is more flexible because it allows algorithms to be interchangeable and chosen dynamically at runtime, making it more suitable for situations where the behavior needs to change frequently or at runtime.

3. **How would you implement the Template Method pattern in Java?**

   To implement the Template Method pattern in Java, create an abstract class with a final method that defines the algorithm's structure. Inside this method, call other methods that represent individual steps of the algorithm. Some of these methods can be abstract, allowing subclasses to override and provide specific implementations. Subclasses inherit the template method and customize only the steps needed, ensuring the overall structure remains unchanged while allowing specific behavior.

   **My Input**: A final method in the template class ensures that the algorithm's structure cannot be overridden, which enforces a strict algorithmic flow while still allowing the subclass to handle certain aspects. It’s also good practice to use abstract methods for steps that will vary, which ensures that subclasses are forced to implement those steps.

4. **Can you provide an example where you would use the Template Method pattern?**

   An example of using the Template Method pattern is in a data processing application that reads data from different sources (like files, databases, or APIs). The general workflow—reading, parsing, and saving the data—remains the same, but the specific reading and parsing methods vary. By using the Template Method pattern, you define the overall process in a base class and allow subclasses to customize the data retrieval and parsing logic based on the source type.

   **My Input**: Another example could be a game engine where the basic flow for starting a game, processing game logic, and ending the game remains constant, but the specific rules and environment setup might differ based on the game type (e.g., chess vs. checkers).

5. **What are the advantages and limitations of using the Template Method pattern?**

   The Template Method pattern offers advantages like promoting code reuse by defining a consistent process structure and allowing subclasses to customize specific steps. It enforces a clear algorithmic flow and reduces code duplication. However, its limitations include reduced flexibility, as the overall structure is fixed. Overuse can also lead to a rigid hierarchy of classes, making the system harder to maintain and extend if many variations are needed in the process steps.

   **My Input**: One of the limitations is that the fixed algorithm structure can sometimes become too restrictive if the system needs to evolve in ways that break the general flow. While subclasses can override specific steps, it’s often difficult to add new variations without breaking the base structure or introducing a more complex hierarchy. To mitigate this, it's important to use the pattern selectively and consider whether more flexible alternatives, such as the Strategy or State pattern, may be more appropriate in some cases.