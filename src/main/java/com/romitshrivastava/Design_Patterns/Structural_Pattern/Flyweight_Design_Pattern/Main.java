package com.romitshrivastava.Design_Patterns.Structural_Pattern.Flyweight_Design_Pattern;


import java.util.HashMap;
import java.util.Map;

interface Shape {
    void draw(String color); // color is extrinsic
}

// Concrete Flyweight
class Circle implements Shape {
    private final String shapeType = "Circle"; // intrinsic
    private final int radius = 5; // intrinsic

    @Override
    public void draw(String color) {
        System.out.println("Drawing " + shapeType + " with color: " + color + " and radius: " + radius);
    }
}

// Flyweight Factory
class ShapeFactory {
    private static final Map<String, Shape> shapeMap = new HashMap<>();

    public static Shape getCircle() {
        Shape circle = shapeMap.get("circle");
        if (circle == null) {
            circle = new Circle();
            shapeMap.put("circle", circle);
            System.out.println("Created new Circle object");
        }
        return circle;
    }
}

// Client Code
 class Main {
    public static void main(String[] args) {
        Shape redCircle = ShapeFactory.getCircle();
        redCircle.draw("Red");

        Shape blueCircle = ShapeFactory.getCircle();
        blueCircle.draw("Blue");

        Shape greenCircle = ShapeFactory.getCircle();
        greenCircle.draw("Green");

        System.out.println(redCircle == blueCircle);
    }
}

