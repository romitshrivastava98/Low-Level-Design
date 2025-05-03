package com.romitshrivastava.Design_Patterns.Behavioral_Pattern.Observer_Design_Pattern;

import java.util.ArrayList;
import java.util.List;


// Observer interface that all observers must implement
interface Observer {
    void update(float temperature, float humidity, float pressure);
}


// Subject interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject (Weather Station)
class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    // When the weather station gets new data
    public void setWeatherData(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers(); // Notify observers when data updates
    }
}


// Concrete Observer 1: Mobile App Display
class MobileDisplay implements Observer {
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("📱 Mobile Display: Temperature: " + temperature +
                "°C, Humidity: " + humidity + "%, Pressure: " + pressure + " hPa");
    }
}

// Concrete Observer 2: TV Display
class TVDisplay implements Observer {
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("📺 TV Display: Temperature: " + temperature +
                "°C, Humidity: " + humidity + "%, Pressure: " + pressure + " hPa");
    }
}

// Concrete Observer 3: Web Dashboard Display
class WebDashboard implements Observer {
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("💻 Web Dashboard: Temperature: " + temperature +
                "°C, Humidity: " + humidity + "%, Pressure: " + pressure + " hPa");
    }
}


public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation(); // Subject

        Observer mobileDisplay = new MobileDisplay();
        Observer tvDisplay = new TVDisplay();
        Observer webDashboard = new WebDashboard();

        // Register observers
        weatherStation.addObserver(mobileDisplay);
        weatherStation.addObserver(tvDisplay);
        weatherStation.addObserver(webDashboard);

        System.out.println("🌤️ Weather Update 1:");
        weatherStation.setWeatherData(28.5f, 65f, 1013f);

        System.out.println("\n⛈️ Weather Update 2:");
        weatherStation.setWeatherData(24.2f, 70f, 1009f);

        // Remove one observer and update again
        weatherStation.removeObserver(tvDisplay);

        System.out.println("\n🌞 Weather Update 3 (TV Display Removed):");
        weatherStation.setWeatherData(30.0f, 60f, 1015f);
    }
}
