package com.romitshrivastava.Design_Patterns.Creational_Pattern.Singleton_Design_Pattern;

// DatabaseConnectionSingleton.java
public class DatabaseConnectionSingleton {

    private static DatabaseConnectionSingleton instance;

    // Private constructor to initialize the database connection
    private DatabaseConnectionSingleton() {
        // Simulate connection to the database
        System.out.println("Database connection established.");
    }

    // Public method to provide access to the instance
    public static DatabaseConnectionSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionSingleton();
        }
        return instance;
    }

    // Method to simulate database operations
    public void connect() {
        System.out.println("Connected to the database.");
    }

    public static void main(String[] args) {
        // Accessing the DatabaseConnection Singleton and performing actions
        DatabaseConnectionSingleton dbConnection = DatabaseConnectionSingleton.getInstance();
        dbConnection.connect();
    }
}
