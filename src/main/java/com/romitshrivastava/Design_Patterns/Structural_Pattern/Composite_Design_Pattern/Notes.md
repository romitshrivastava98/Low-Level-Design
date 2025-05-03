# **Composite Design Pattern**

## **Purpose**

The Composite Design Pattern allows you to compose objects into tree structures and treat individual objects and compositions of objects uniformly. It is used to represent part-whole hierarchies.

### **Common Use Cases**

- Representing hierarchical structures like files and folders
- Building user interfaces where both individual elements and containers are handled uniformly
- Organization hierarchies
- Product bundling in e-commerce

### **Definition**

The Composite Design Pattern is a structural design pattern that treats individual objects and compositions of objects in a uniform way using a common interface. It supports recursive composition.

### **Real-World Analogy**

In a file system, a file is an individual object while a folder can contain files and other folders. Both files and folders support the same set of operations like open, delete, or rename. This uniform treatment is an example of the composite pattern.

**Intent**

- Compose objects into tree structures
- Treat individual and composite objects uniformly

### **Components**

1. **Component**

   An interface or abstract class that defines the common operations for both leaves and composites.

   Example:

    ```java
    java
    CopyEdit
    interface FileSystemComponent {
        void showDetails();
    }
    
    ```

2. **Leaf**

   Represents an individual object in the composition. It implements the component interface.

   Example:

    ```java
    java
    CopyEdit
    class File implements FileSystemComponent {
        private String name;
        public File(String name) {
            this.name = name;
        }
        public void showDetails() {
            System.out.println("File: " + name);
        }
    }
    
    ```

3. **Composite**

   Represents a group of components. It maintains child components and implements the component interface.

   Example:

    ```java
    java
    CopyEdit
    class Folder implements FileSystemComponent {
        private String name;
        private List<FileSystemComponent> children = new ArrayList<>();
    
        public Folder(String name) {
            this.name = name;
        }
    
        public void add(FileSystemComponent component) {
            children.add(component);
        }
    
        public void remove(FileSystemComponent component) {
            children.remove(component);
        }
    
        public void showDetails() {
            System.out.println("Folder: " + name);
            for (FileSystemComponent c : children) {
                c.showDetails();
            }
        }
    }
    
    ```


### **Benefits**

- Simplifies client code by allowing uniform treatment of individual and composite objects
- Facilitates recursive processing of tree structures
- Promotes flexibility and reusability

### **Limitations**

- May lead to a generalization that makes it harder to restrict operations to specific object types
- Can introduce complexity in debugging and managing deep hierarchies
- May increase the number of classes if not managed carefully

### **Interview Questions**

1. **What is the Composite pattern and when is it most useful?**

   It is a structural pattern that allows you to compose objects into tree structures and treat them uniformly. It is useful when modeling recursive or hierarchical structures like file systems or GUIs.

2. **Can you provide an example of how the Composite pattern can be used to model tree structures?**

   In a file system, a file is a leaf and a folder is a composite that can contain files and other folders. Both share a common interface and support uniform operations like delete or display.

3. **How does the Composite pattern simplify working with hierarchical data?**

   By allowing all components to share the same interface, the pattern enables the same operations to be applied to both individual and composite objects, simplifying code and reducing conditionals.

4. **What are the benefits and limitations of using the Composite pattern?**

   Benefits include uniformity, recursive handling, and flexibility. Limitations include complexity in large hierarchies and difficulty restricting operations to specific types.

5. **How would you implement the Composite pattern in Java?**

   Define a common interface. Create Leaf classes implementing the interface. Create Composite classes that also implement the interface and manage child components. Use the same interface in client code for all operations.