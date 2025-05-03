package com.romitshrivastava.Design_Patterns.Creational_Pattern.Builder_Design_Pattern;

 class Car {
    // Required parameters
    private final String engine;
    private final int wheels;

    // Optional parameters
    private final boolean sunroof;
    private final boolean GPS;
    private final String color;

    // Private constructor: only accessible through builder
    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.sunroof = builder.sunroof;
        this.GPS = builder.GPS;
        this.color = builder.color;
    }

    // Static inner Builder class
    public static class CarBuilder {
        // Required parameters
        private final String engine;
        private final int wheels;

        // Optional parameters - initialized to default values
        private boolean sunroof = false;
        private boolean GPS = false;
        private String color = "Black";

        // Constructor with required parameters
        public CarBuilder(String engine, int wheels) {
            this.engine = engine;
            this.wheels = wheels;
        }

        // Setter-like methods for optional parameters
        public CarBuilder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public CarBuilder setGPS(boolean GPS) {
            this.GPS = GPS;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        // Final build method
        public Car build() {
            return new Car(this);
        }
    }

    // Getters for demonstration (optional)
    public String getEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public boolean hasSunroof() {
        return sunroof;
    }

    public boolean hasGPS() {
        return GPS;
    }

    public String getColor() {
        return color;
    }

    // toString() for easy display
    @Override
    public String toString() {
        return "Car [engine=" + engine + ", wheels=" + wheels + ", sunroof=" + sunroof +
                ", GPS=" + GPS + ", color=" + color + "]";
    }
}



public class Main {
    public static void main(String[] args) {
        Car sportsCar = new Car.CarBuilder("V8", 4)
                .setColor("Red")
                .setGPS(true)
                //.setSunroof(true)
                .build();

        System.out.println(sportsCar);

        Car economyCar = new Car.CarBuilder("I4", 4)
                .setColor("White")
                .build();

        System.out.println(economyCar);
    }
}



