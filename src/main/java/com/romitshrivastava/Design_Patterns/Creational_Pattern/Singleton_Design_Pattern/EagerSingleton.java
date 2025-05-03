package com.romitshrivastava.Design_Patterns.Creational_Pattern.Singleton_Design_Pattern;

// EagerSingleton.java
public class EagerSingleton {

    // Instance is created as soon as the class is loaded
    private static final EagerSingleton instance = new EagerSingleton();

    // Private constructor to prevent instantiation
    private EagerSingleton() {}

    // Public method to provide access to the instance
    public static EagerSingleton getInstance() {
        return instance;
    }

    // Example method to show the functionality of the singleton
    public void showMessage() {
        System.out.println("Hello from EagerSingleton!");
    }

    public static void main(String[] args) {
        // Accessing the Singleton instance and calling a method
        EagerSingleton singleton = EagerSingleton.getInstance();
        singleton.showMessage();
    }
}
