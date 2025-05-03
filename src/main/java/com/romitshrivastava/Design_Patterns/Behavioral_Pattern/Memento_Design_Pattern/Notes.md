# Memento Design Pattern

## Purpose:

The **Memento Pattern** is a behavioral design pattern that allows an object to save and restore its previous state without exposing its implementation details. It is useful for implementing undo/rollback functionality.

## When to Use:

- You need to implement undo or rollback features.
- You want to preserve encapsulation (i.e., internal details should not be exposed).
- You want to track the history of changes to an object.

## Common Use Cases:

- Text editors (Undo/Redo functionality)
- Game saves (restoring game state)
- Transaction management (rollbacks)
- UI configuration history

## Real-Life Analogy:

Think of a **word processor**. Every time you hit "Ctrl + Z", the app reverts to a previous version of the document. Behind the scenes, snapshots (mementos) of the document are saved, and you go back in time using them.


## Advantages:

- Preserves encapsulation: internal state is never exposed to the outside.
- Easy implementation of undo features.
- Clean separation between state storage and logic.

## Limitations:

- Can use a lot of memory if many mementos are stored.
- Not ideal for objects with very large state.
- Caretaker must manage mementos carefully (e.g., avoid memory leaks or holding too many).

---

## Interview Q&A:

1. **What is the Memento Pattern?**
    - It allows capturing and restoring an object's internal state without violating encapsulation.
2. **Where is the Memento pattern used?**
    - Undo operations in text editors, rollback in databases, version control systems, and games.
3. **Who are the key participants in the pattern?**
    - **Originator** (creates/uses mementos), **Memento** (stores state), and **Caretaker** (manages history of states).
4. **How does Memento maintain encapsulation?**
    - The memento stores internal state in a separate object, and no external class can directly manipulate the state.
5. **What are some challenges of using this pattern?**
    - Managing memory usage with many saved states and ensuring the correct lifecycle of mementos.