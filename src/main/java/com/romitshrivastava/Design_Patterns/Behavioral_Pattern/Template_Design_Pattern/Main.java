package com.romitshrivastava.Design_Patterns.Behavioral_Pattern.Template_Design_Pattern;

abstract class BeverageTemplate {

    // Template Method
    public final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Abstract steps to be implemented by subclasses
    protected abstract void brew();
    protected abstract void addCondiments();

    // Hook method (can be overridden)
    protected boolean customerWantsCondiments() {
        return true;
    }
}



class Tea extends BeverageTemplate {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}



class Coffee extends BeverageTemplate {
    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }

    @Override
    protected boolean customerWantsCondiments() {
        // You could ask user input here; using static decision for simplicity
        return false;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Making Tea...");
        BeverageTemplate tea = new Tea();
        tea.prepareBeverage();

        System.out.println("\nMaking Coffee...");
        BeverageTemplate coffee = new Coffee();
        coffee.prepareBeverage();
    }
}
