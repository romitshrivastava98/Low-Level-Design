package com.romitshrivastava.SOLID_Principles.C_Liskov_Substitution.Bad_Design;

// Subclass Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
