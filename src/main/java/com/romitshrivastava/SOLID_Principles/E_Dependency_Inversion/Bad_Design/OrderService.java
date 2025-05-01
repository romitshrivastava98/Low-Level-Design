package com.romitshrivastava.SOLID_Principles.E_Dependency_Inversion.Bad_Design;

// High-level class directly depends on the concrete class
class OrderService {
    private EmailSender emailSender;

    public OrderService() {
        this.emailSender = new EmailSender(); // tightly coupled
    }

    public void placeOrder() {
        // business logic
        emailSender.send("Order placed successfully!");
    }
}