package com.romitshrivastava.Design_Patterns.Creational_Pattern.Singleton_Design_Pattern;

// DoubleCheckedLockingSingleton.java
public class DoubleCheckedLockingSingleton {

    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {}

    // Double-checked locking to ensure thread safety
    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    // Example method to show the functionality of the singleton
    public void showMessage() {
        System.out.println("Hello from DoubleCheckedLockingSingleton!");
    }

    public static void main(String[] args) {
        // Accessing the Singleton instance and calling a method
        DoubleCheckedLockingSingleton singleton = DoubleCheckedLockingSingleton.getInstance();
        singleton.showMessage();
    }
}
