package com.romitshrivastava.SOLID_Principles.E_Dependency_Inversion.Bad_Design;

// Low-level class
class EmailSender {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}