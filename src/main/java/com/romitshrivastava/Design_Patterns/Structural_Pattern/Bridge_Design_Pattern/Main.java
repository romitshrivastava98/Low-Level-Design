package com.romitshrivastava.Design_Patterns.Structural_Pattern.Bridge_Design_Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new Red());
        Shape blueSquare = new Square(new Blue());

        redCircle.applyColor();
        blueSquare.applyColor();
    }
}


// Step 1: Implementor (Color interface)
interface Color {
    void fillColor();
}

// Step 2: Concrete Implementations of Color
class Red implements Color {
    @Override
    public void fillColor() {
        System.out.println("Applying Red Color");
    }
}

class Blue implements Color {
    @Override
    public void fillColor() {
        System.out.println("Applying Blue Color");
    }
}

// Step 3: Abstraction (Shape class)
abstract class Shape {
    protected Color color;  // Bridge to Color

    public Shape(Color color) {
        this.color = color;
    }

    abstract void applyColor();  // Abstraction method
}

// Step 4: Concrete Implementations of Shape
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    void applyColor() {
        System.out.print("Drawing Circle with ");
        color.fillColor();
    }
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    void applyColor() {
        System.out.print("Drawing Square with ");
        color.fillColor();
    }
}