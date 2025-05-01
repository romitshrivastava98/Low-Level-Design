package com.romitshrivastava.SOLID_Principles.E_Dependency_Inversion.Good_Design;

// High-level module depends on abstraction
class OrderService {
    private Notifier notifier;

    public OrderService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void placeOrder() {
        // business logic
        notifier.send("Order placed successfully!");
    }
}
