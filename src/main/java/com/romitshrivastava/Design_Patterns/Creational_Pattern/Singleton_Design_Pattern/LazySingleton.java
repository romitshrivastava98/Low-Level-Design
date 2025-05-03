package com.romitshrivastava.Design_Patterns.Creational_Pattern.Singleton_Design_Pattern;

// LazySingleton.java
public class LazySingleton {

    // Step 1: Private static instance of the class
    private static LazySingleton instance;

    // Step 2: Private constructor to prevent instantiation from outside
    private LazySingleton() {}

    // Step 3: Public method to provide access to the instance
    public static LazySingleton getInstance() {
        // Lazy initialization, instance is created only when needed
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    // Example method to show the functionality of the singleton
    public void showMessage() {
        System.out.println("Hello from LazySingleton!");
    }

    public static void main(String[] args) {
        // Accessing the Singleton instance and calling a method
        LazySingleton singleton = LazySingleton.getInstance();
        singleton.showMessage();
    }
}
