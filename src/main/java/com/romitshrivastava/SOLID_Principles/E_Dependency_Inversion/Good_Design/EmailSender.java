package com.romitshrivastava.SOLID_Principles.E_Dependency_Inversion.Good_Design;

// Low-level implementations
class EmailSender implements Notifier {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}