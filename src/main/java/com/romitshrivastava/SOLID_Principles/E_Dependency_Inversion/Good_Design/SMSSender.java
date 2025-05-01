package com.romitshrivastava.SOLID_Principles.E_Dependency_Inversion.Good_Design;

class SMSSender implements Notifier {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
