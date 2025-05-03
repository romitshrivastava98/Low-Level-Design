### Are Flyweight and Singleton the same?

**No, they are not the same**, though they share a few similar characteristics related to object reuse. Let’s compare them clearly:

---

### Similarities:

- Both avoid creating multiple objects unnecessarily.
- Both can involve shared instances to save memory or improve performance.

---

### Differences:

| Aspect | Singleton Pattern | Flyweight Pattern |
| --- | --- | --- |
| Purpose | Ensures only one instance of a class exists across the system | Reuses many similar objects by sharing them when possible |
| Number of Instances | Always a single, global instance | Multiple shared instances depending on their internal state |
| Access | Clients always get the exact same instance | Clients may get shared instances based on intrinsic properties |
| State | Usually holds internal state | Separates internal (intrinsic) state from external (extrinsic) data |
| Example Use | Logger, config manager, database connection pool | Characters in a text editor, icons in a map, particles in a game |

---

### Summary:

- **Singleton** is about *one* instance per class.
- **Flyweight** is about *many shared* instances to reduce memory usage.
- Flyweight may use a **cache or factory** to manage shared instances, but it's not a Singleton.