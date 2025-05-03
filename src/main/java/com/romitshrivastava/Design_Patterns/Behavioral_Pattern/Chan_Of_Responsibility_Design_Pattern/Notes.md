## Chain of Responsibility Design Pattern

### Purpose:

The Chain of Responsibility (CoR) pattern allows a request to be passed along a chain of handlers. Each handler decides whether to process the request or pass it to the next handler in the chain. This enables flexible assignment of responsibilities and decouples the sender of the request from its receiver.

---

### Common Use Cases:

- Event propagation (e.g., GUI event handling)
- Logging frameworks
- Request filtering in web applications (e.g., Servlet filters)
- Authorization and authentication chains
- Customer service escalation workflows

---

### Real-Life Analogy:

Consider a leave approval process in a company:

- A team lead can approve leaves up to 2 days.
- If more days are requested, it’s passed to the manager.
- For longer leaves, it may go to the HR department.

Each authority acts as a handler. If they can't handle the request, they forward it to the next level.

---

### When to Use:

- You want to decouple the sender and receiver of a request.
- You want multiple objects to have a chance to handle a request.
- You want to avoid hardcoding the logic using multiple `if-else` or `switch` statements.
- You want to process a request dynamically and transparently by passing it through a sequence of handlers.

---

### Key Components:

1. **Handler Interface**: Declares a method to handle requests and a reference to the next handler.
2. **Concrete Handlers**: Implement the handler interface and decide whether to handle or pass the request.
3. **Client**: Creates and configures the chain, then sends the request to the first handler.

---

### Java Implementation Example:

```java
java
CopyEdit
// Handler interface
interface Handler {
    void setNext(Handler next);
    void handleRequest(String request);
}

// Concrete Handler 1
class TeamLead implements Handler {
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public void handleRequest(String request) {
        if (request.equals("leave <= 2 days")) {
            System.out.println("Team Lead approved the leave.");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}

// Concrete Handler 2
class Manager implements Handler {
    private Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    public void handleRequest(String request) {
        if (request.equals("leave <= 5 days")) {
            System.out.println("Manager approved the leave.");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}

// Concrete Handler 3
class HR implements Handler {
    public void setNext(Handler next) {
        // End of chain
    }

    public void handleRequest(String request) {
        System.out.println("HR approved the leave.");
    }
}

// Client
public class Main {
    public static void main(String[] args) {
        Handler teamLead = new TeamLead();
        Handler manager = new Manager();
        Handler hr = new HR();

        teamLead.setNext(manager);
        manager.setNext(hr);

        teamLead.handleRequest("leave <= 5 days");
    }
}

```

---

### Advantages:

- Reduces coupling between sender and receiver.
- Provides flexibility in adding or removing handlers dynamically.
- Promotes single responsibility by separating request processing logic.

---

### Drawbacks:

- Request may go unhandled if no suitable handler is present.
- Debugging can be difficult due to dynamic flow.
- Long chains may introduce performance overhead.