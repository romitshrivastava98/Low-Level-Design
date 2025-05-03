package com.romitshrivastava.Design_Patterns.Creational_Pattern.Singleton_Design_Pattern;

// SyncMethodSingleton.java
public class SyncMethodSingleton {

    private static SyncMethodSingleton instance;

    private SyncMethodSingleton() {}

    // Synchronized method to ensure thread safety
    public static synchronized SyncMethodSingleton getInstance() {
        if (instance == null) {
            instance = new SyncMethodSingleton();
        }
        return instance;
    }

    // Example method to show the functionality of the singleton
    public void showMessage() {
        System.out.println("Hello from SyncMethodSingleton!");
    }

    public static void main(String[] args) {
        // Accessing the Singleton instance and calling a method
        SyncMethodSingleton singleton = SyncMethodSingleton.getInstance();
        singleton.showMessage();
    }
}
