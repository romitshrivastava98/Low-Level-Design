### State Design Pattern — Master Notes

### Purpose:

The **State Pattern** is a behavioral design pattern that allows an object to change its behavior when its internal state changes. The object will appear to change its class. It is particularly useful when an object’s behavior is dependent on its state and it must be able to change its behavior at runtime.

### Common Use Cases:

- **State-dependent behavior**: When an object's behavior changes based on its state.
- **Finite State Machines (FSM)**: Managing states in systems like vending machines, elevators, and workflow systems.
- **Workflow management**: Where different actions are required in different states of a process.

### Example Scenario:

Imagine a **vending machine**. It has different states like "Has Money", "Sold Out", and "Ready to Dispense." The actions (like accepting money or dispensing the item) vary depending on the state of the vending machine.

### Real-Life Analogy:

Think of a **music player**:

- **Play State**: The player is playing music.
- **Pause State**: The player is paused.
- **Stop State**: The player has stopped playing.

When the music player is in different states, the actions that are valid will change:

- **Play** action when in "Stop" or "Pause" state.
- **Pause** action when in "Play" state.
- **Stop** action when in "Play" state.

### Key Concept:

The idea is that an object has different states and each state has a set of behaviors associated with it. When the state changes, the behaviors associated with that state also change. The state transitions are managed by the **Context class** and the behavior is encapsulated within **State classes**.

---

### Structure:

1. **State Interface**: Defines a common interface for all concrete states.
2. **Concrete State Classes**: Each state implements the State interface and defines the behavior corresponding to that state.
3. **Context**: Maintains an instance of the current state and delegates the behavior to the current state object.

---

### Java Code Example:

### 1. Define the State interface:

```java
java
CopyEdit
// State Interface
public interface State {
    void handleRequest();
}

```

### 2. Concrete States:

```java
java
CopyEdit
// Concrete State A - Playing state
public class PlayingState implements State {
    private MusicPlayer player;

    public PlayingState(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void handleRequest() {
        System.out.println("Music is now playing.");
        player.setState(player.getPausedState());  // Transition to PausedState
    }
}

// Concrete State B - Paused state
public class PausedState implements State {
    private MusicPlayer player;

    public PausedState(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void handleRequest() {
        System.out.println("Music is paused.");
        player.setState(player.getStoppedState());  // Transition to StoppedState
    }
}

// Concrete State C - Stopped state
public class StoppedState implements State {
    private MusicPlayer player;

    public StoppedState(MusicPlayer player) {
        this.player = player;
    }

    @Override
    public void handleRequest() {
        System.out.println("Music is stopped.");
        player.setState(player.getPlayingState());  // Transition to PlayingState
    }
}

```

### 3. The Context (MusicPlayer) class:

```java
java
CopyEdit
// Context Class - MusicPlayer
public class MusicPlayer {
    private State playingState;
    private State pausedState;
    private State stoppedState;
    private State currentState;

    public MusicPlayer() {
        playingState = new PlayingState(this);
        pausedState = new PausedState(this);
        stoppedState = new StoppedState(this);

        currentState = stoppedState;  // Initial state
    }

    public void setState(State state) {
        currentState = state;
    }

    public void request() {
        currentState.handleRequest();
    }

    public State getPlayingState() {
        return playingState;
    }

    public State getPausedState() {
        return pausedState;
    }

    public State getStoppedState() {
        return stoppedState;
    }
}

```

### 4. Client Code:

```java
java
CopyEdit
// Client Code - Main
public class Main {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        // Change states
        player.request();  // Output: Music is stopped. Transitioning to Playing state.
        player.request();  // Output: Music is now playing. Transitioning to Paused state.
        player.request();  // Output: Music is paused. Transitioning to Stopped state.
    }
}

```

---

### Explanation:

1. **State Interface**: This defines the contract that all states (Playing, Paused, Stopped) must follow. They all implement the `handleRequest()` method.
2. **Concrete States**: `PlayingState`, `PausedState`, and `StoppedState` each implement the `handleRequest()` method and manage their respective state behaviors. They also manage the state transitions.
3. **Context Class (MusicPlayer)**: The `MusicPlayer` is the context that maintains the current state and delegates the state transitions to the respective state class. It also provides methods to get different states and switch between them.

---

### Benefits of the State Pattern:

- **Encapsulation**: Each state is encapsulated in its own class, which makes it easier to modify individual states without affecting others.
- **State transitions**: Managing state transitions is clean and structured, avoiding if-else or switch-case logic scattered throughout the code.
- **Extensibility**: Adding new states is easier and doesn't require modifying the context class.

---

### Interview-Friendly Q&A Highlights:

**What is the State Pattern and when would you use it?**

The State Pattern allows an object to alter its behavior when its internal state changes. It's used when an object's behavior is dependent on its state, and you want to avoid using complex conditionals like if-else or switch statements. It is useful in scenarios where the behavior of an object needs to change dynamically based on its state.

**How does the State Pattern work?**

The State Pattern divides the behavior of an object into states, each represented by a class. The context class delegates the current state’s behavior and manages state transitions.

**What are the advantages of the State Pattern?**

1. Reduces the need for complex conditional logic.
2. Makes the code cleaner and more modular by dividing behavior into separate classes.
3. Simplifies the addition of new states without modifying existing code.

**What is the difference between the State Pattern and the Strategy Pattern?**

Both the State and Strategy Patterns deal with changing behavior, but the difference is in their purpose:

- **State Pattern**: An object’s behavior depends on its state, and the state can change over time.
- **Strategy Pattern**: It provides a way to change the algorithm or strategy used by an object, and the strategy can be changed at runtime.

---

### Conclusion:

The **State Design Pattern** is a powerful tool to manage an object's behavior based on its state without resorting to complex conditional logic. By encapsulating each state in its own class, it makes the system extensible, modular, and easier to maintain. It is most useful in applications like workflow management, game development, or anywhere where objects have distinct states that affect their behavior.