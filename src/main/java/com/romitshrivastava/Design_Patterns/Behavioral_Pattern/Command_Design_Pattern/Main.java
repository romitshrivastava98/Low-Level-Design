package com.romitshrivastava.Design_Patterns.Behavioral_Pattern.Command_Design_Pattern;

import java.util.Stack;

// Command interface
interface Command {
    void execute();
    void undo(); // For Undo functionality
}


// Receiver: Light
class Light {
    public void turnOn() {
        System.out.println("💡 Light is ON");
    }
    public void turnOff() {
        System.out.println("💡 Light is OFF");
    }
}

// Receiver: Fan
class Fan {
    public void start() {
        System.out.println("🌀 Fan is RUNNING");
    }
    public void stop() {
        System.out.println("🌀 Fan is STOPPED");
    }
}

// Receiver: Air Conditioner (AC)
class AC {
    public void turnOn() {
        System.out.println("❄️ AC is ON");
    }
    public void turnOff() {
        System.out.println("❄️ AC is OFF");
    }
}



// Concrete Command for Light
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

// Concrete Command for Fan
class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.start();
    }

    @Override
    public void undo() {
        fan.stop();
    }
}

class FanOffCommand implements Command {
    private Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.stop();
    }

    @Override
    public void undo() {
        fan.start();
    }
}

// Concrete Command for AC
class ACOnCommand implements Command {
    private AC ac;

    public ACOnCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOn();
    }

    @Override
    public void undo() {
        ac.turnOff();
    }
}

class ACOffCommand implements Command {
    private AC ac;

    public ACOffCommand(AC ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOff();
    }

    @Override
    public void undo() {
        ac.turnOn();
    }
}



class RemoteControl {
    private Command command;
    private Stack<Command> history = new Stack<>(); // For undo functionality

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        history.push(command); // Store executed command for undo
    }

    public void pressUndo() {
        if (!history.isEmpty()) {
            history.pop().undo();
        } else {
            System.out.println("⚠️ No action to undo");
        }
    }
}



public class Main {
    public static void main(String[] args) {
        // Create devices
        Light light = new Light();
        Fan fan = new Fan();
        AC ac = new AC();

        // Create commands for each device
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command fanOn = new FanOnCommand(fan);
        Command fanOff = new FanOffCommand(fan);
        Command acOn = new ACOnCommand(ac);
        Command acOff = new ACOffCommand(ac);

        // Create remote control (Invoker)
        RemoteControl remote = new RemoteControl();

        // Test Light Control
        System.out.println("📢 Testing Light Control:");
        remote.setCommand(lightOn);
        remote.pressButton();
        remote.pressUndo();

        // Test Fan Control
        System.out.println("\n📢 Testing Fan Control:");
        remote.setCommand(fanOn);
        remote.pressButton();
        remote.pressUndo();

        // Test AC Control
        System.out.println("\n📢 Testing AC Control:");
        remote.setCommand(acOn);
        remote.pressButton();
        remote.pressUndo();
    }
}
