package com.romitshrivastava.Design_Patterns.Structural_Pattern.Bridge_Design_Pattern;

// Step 1: Implementation Interface
interface TV {
    void on();
    void off();
    void setChannel(int channel);
}

// Step 2: Concrete Implementations
class SonyTV implements TV {
    public void on() {
        System.out.println("Turning on Sony TV");
    }

    public void off() {
        System.out.println("Turning off Sony TV");
    }

    public void setChannel(int channel) {
        System.out.println("Setting Sony TV channel to " + channel);
    }
}

class LGTV implements TV {
    public void on() {
        System.out.println("Turning on LG TV");
    }

    public void off() {
        System.out.println("Turning off LG TV");
    }

    public void setChannel(int channel) {
        System.out.println("Setting LG TV channel to " + channel);
    }
}

// Step 3: Abstraction
abstract class RemoteControl {
    protected TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void changeChannel(int channel);
}

// Step 4: Refined Abstraction
class BasicRemoteControl extends RemoteControl {

    public BasicRemoteControl(TV tv) {
        super(tv);
    }

    public void turnOn() {
        tv.on();
    }

    public void turnOff() {
        tv.off();
    }

    public void changeChannel(int channel) {
        tv.setChannel(channel);
    }
}


public class Main_TV {
    public static void main(String[] args) {
        TV sony = new SonyTV();
        RemoteControl sonyRemote = new BasicRemoteControl(sony);

        sonyRemote.turnOn();
        sonyRemote.changeChannel(10);
        sonyRemote.turnOff();

        System.out.println("-----");

        TV lg = new LGTV();
        RemoteControl lgRemote = new BasicRemoteControl(lg);

        lgRemote.turnOn();
        lgRemote.changeChannel(5);
        lgRemote.turnOff();
    }
}
