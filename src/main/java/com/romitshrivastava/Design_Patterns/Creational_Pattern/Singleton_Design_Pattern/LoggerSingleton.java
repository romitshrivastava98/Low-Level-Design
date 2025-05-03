package com.romitshrivastava.Design_Patterns.Creational_Pattern.Singleton_Design_Pattern;

// LoggerSingleton.java
public class LoggerSingleton {

    // Private static instance of the Logger class
    private static LoggerSingleton instance;

    // Private constructor to prevent instantiation
    private LoggerSingleton() {}

    // Public method to provide access to the instance
    public static LoggerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerSingleton();
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }

    public static void main(String[] args) {
        // Accessing the Logger Singleton and logging a message
        LoggerSingleton logger = LoggerSingleton.getInstance();
        logger.log("This is a singleton logger.");
    }
}
