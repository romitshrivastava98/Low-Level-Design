# Command Design Pattern

## Purpose

The Command Pattern is a behavioral design pattern that encapsulates a request as an object. This allows:

- Parameterizing clients with different requests
- Queuing or logging operations
- Supporting undo/redo functionality
- Decoupling the sender from the receiver of the request

## Common Use Cases

- Implementing undo/redo in text editors
- Queuing and scheduling tasks
- Logging executed operations
- Creating macro commands
- Handling GUI actions in decoupled event-driven systems

## Real-Life Analogy

A TV remote is a real-life example of the command pattern:

- Each button on the remote acts as a Command object (e.g., TurnOnCommand, VolumeUpCommand)
- The TV is the Receiver that performs the actual operation
- The remote control acts as the Invoker that triggers commands without knowing how they are implemented

## Core Components

| Component | Description |
| --- | --- |
| Command Interface | Declares an `execute()` method |
| Concrete Command | Implements the command and invokes actions on the receiver |
| Receiver | Knows how to perform the actual operation |
| Invoker | Stores and triggers commands |
| Client | Configures commands and connects them with the receiver and invoker |

---

## Frequently Asked Questions

### 1. What is the Command Pattern and how does it encapsulate requests?

The Command Pattern encapsulates a request as an object, which allows requests to be queued, logged, or undone. It achieves this by defining a common interface (usually with an `execute()` method) and implementing concrete classes for each operation. The actual object performing the operation is decoupled from the object initiating the request. This improves flexibility, testability, and maintainability of code.

### 2. How would you implement the Command Pattern in Java?

```java
java
CopyEdit
// Command interface
interface Command {
    void execute();
}

// Receiver
class Light {
    void turnOn() {
        System.out.println("Light is ON");
    }
    void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Concrete Command classes
class TurnOnCommand implements Command {
    private final Light light;
    TurnOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOn();
    }
}

class TurnOffCommand implements Command {
    private final Light light;
    TurnOffCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOff();
    }
}

// Invoker
class RemoteControl {
    private Command command;
    void setCommand(Command command) {
        this.command = command;
    }
    void pressButton() {
        command.execute();
    }
}

// Client
public class CommandPatternDemo {
    public static void main(String[] args) {
        Light light = new Light();
        Command onCommand = new TurnOnCommand(light);
        Command offCommand = new TurnOffCommand(light);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(onCommand);
        remote.pressButton();

        remote.setCommand(offCommand);
        remote.pressButton();
    }
}

```

### 3. In what situations would you use the Command Pattern, such as in undo/redo operations?

The Command Pattern is ideal for scenarios where actions need to be reversible, delayed, or tracked. For example:

- In a text editor, each user action (typing, deleting, formatting) can be a command that can be undone or redone.
- In task scheduling systems, commands can be queued for later execution.
- In transaction logging systems, each command can be logged and replayed if needed.

This separation of command execution from invocation makes it highly flexible for real-world use cases.

### 4. What are the advantages of using the Command Pattern in event-driven systems?

- Decouples event dispatch from handling logic
- Allows storing commands for logging, queuing, or retrying
- Makes it easy to implement undo and redo functionality
- Facilitates macro commands (group of commands executed together)
- Enables dynamic command assignment and reconfiguration at runtime

This results in a modular and extendable architecture that is easy to maintain and extend.

### 5. How does the Command Pattern decouple the sender and receiver of a request?

In the Command Pattern, the sender (Invoker) only knows the command interface and does not need to know about the concrete action or the receiver. The receiver is encapsulated inside the command object. This level of indirection allows the sender to trigger requests without being tightly coupled to the implementation details, promoting cleaner separation of concerns and more flexible design.