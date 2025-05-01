package com.romitshrivastava.SOLID_Principles.C_Liskov_Substitution.Bad_Design;

class Shape {
    public double calculateArea() {
        return 0; // Default implementation, but this is incorrect for all shapes
    }
}