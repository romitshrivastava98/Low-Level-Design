package com.romitshrivastava.SOLID_Principles.C_Liskov_Substitution.Good_Design;

// Base Class - Abstract class to define the common interface
abstract class Shape {
    public abstract double calculateArea(); // Abstract method that must be implemented by subclasses
}