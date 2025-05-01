package com.romitshrivastava.SOLID_Principles.C_Liskov_Substitution.Good_Design;

public class Main {
    public static void main(String[] args) {
        // You can now substitute subclasses of Shape without issues
        Shape circle = new Circle(5);
        System.out.println("Area of Circle: " + circle.calculateArea()); // Will print valid area.

        Shape square = new Square(4);
        System.out.println("Area of Square: " + square.calculateArea()); // Will print valid area.
    }
}
