package com.romitshrivastava.SOLID_Principles.C_Liskov_Substitution.Bad_Design;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println("Area of Shape: " + shape.calculateArea()); // Will print 0, which is incorrect.

        Circle circle = new Circle(5);
        System.out.println("Area of Circle: " + circle.calculateArea()); // Will print valid area.

        Square square = new Square(4);
        System.out.println("Area of Square: " + square.calculateArea()); // Will print valid area.
    }
}
