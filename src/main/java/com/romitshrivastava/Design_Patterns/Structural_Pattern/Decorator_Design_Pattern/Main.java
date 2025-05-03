package com.romitshrivastava.Design_Patterns.Structural_Pattern.Decorator_Design_Pattern;

// Step 1: Component Interface (Base Interface for Coffee)
interface Coffee {
    double getCost();
    String getDescription();
}

// Step 2: Concrete Component (Basic Coffee)
class BasicCoffee implements Coffee {
    @Override
    public double getCost() {
        return 5.0; // Base price of coffee
    }

    @Override
    public String getDescription() {
        return "Basic Coffee";
    }
}


// Step 3: Abstract Decorator (Base Decorator for Coffee Add-ons)
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee; // Composition (HAS-A relationship)

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double getCost() {
        return coffee.getCost(); // Default implementation
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }
}

// Step 4: Concrete Decorators (Add-ons)

// Milk Decorator
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0; // Adding milk cost
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}

// Sugar Decorator
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0; // Adding sugar cost
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }
}

// Caramel Decorator
class CaramelDecorator extends CoffeeDecorator {
    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 3.0; // Adding caramel cost
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Caramel";
    }
}


// Step 5: Client Code (Using Decorators)
public class Main {
    public static void main(String[] args) {
        // Basic Coffee
        Coffee basicCoffee = new BasicCoffee();
        System.out.println(basicCoffee.getDescription() + " | Cost: $" + basicCoffee.getCost());

        // Coffee with Milk
        Coffee milkCoffee = new MilkDecorator(new BasicCoffee());
        System.out.println(milkCoffee.getDescription() + " | Cost: $" + milkCoffee.getCost());

        // Coffee with Milk and Sugar
        Coffee milkSugarCoffee = new SugarDecorator(new MilkDecorator(new BasicCoffee()));
        System.out.println(milkSugarCoffee.getDescription() + " | Cost: $" + milkSugarCoffee.getCost());

        // Coffee with Milk, Sugar, and Caramel
        Coffee fancyCoffee = new CaramelDecorator(new SugarDecorator(new MilkDecorator(new BasicCoffee())));
        System.out.println(fancyCoffee.getDescription() + " | Cost: $" + fancyCoffee.getCost());


        System.out.println("\n\n\n");

        Coffee coffee = new BasicCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription() + " | Cost: $" + coffee.getCost());
    }
}