package com.romitshrivastava.Design_Patterns.Structural_Pattern.Adapter_Design_Pattern.Notes;


// Step 1: Target Interface (what client expects)
interface ThreePinSocket {
    void powerWithThreePin();
}

// Step 2: Adaptee (incompatible interface)
class TwoPinSocket {
    public void powerWithTwoPin() {
        System.out.println("Powering with 2-pin socket");
    }
}

// Step 3: Adapter (converts TwoPinSocket to ThreePinSocket)
class SocketAdapter implements ThreePinSocket {
    private TwoPinSocket twoPinSocket;

    public SocketAdapter(TwoPinSocket twoPinSocket) {
        this.twoPinSocket = twoPinSocket;
    }

    @Override
    public void powerWithThreePin() {
        System.out.println("Adapter converting 3-pin to 2-pin...");
        twoPinSocket.powerWithTwoPin();
    }
}

// Step 4: Client (device that needs 3-pin socket)
class Appliance {
    private ThreePinSocket socket;

    public Appliance(ThreePinSocket socket) {
        this.socket = socket;
    }

    public void turnOn() {
        System.out.println("Appliance needs a 3-pin socket to work...");
        socket.powerWithThreePin();
        System.out.println("Appliance is running!\n");
    }
}

// Step 5: Test the Adapter Pattern
 class Socket {
    public static void main(String[] args) {
        // Old two-pin socket in wall
        TwoPinSocket twoPinSocket = new TwoPinSocket();

        // Adapter bridges two-pin to three-pin
        ThreePinSocket adapter = new SocketAdapter(twoPinSocket);

        // Appliance using the adapter
        Appliance appliance = new Appliance(adapter);
        appliance.turnOn();
    }
}
