package com.romitshrivastava.Design_Patterns.Creational_Pattern.Abstract_Factory_Design_Pattern;

 interface Button {
    void paint();
}

 interface Checkbox {
    void paint();
}

// Windows versions
 class WindowsButton implements Button {
    public void paint() {
        System.out.println("Rendering Windows Button");
    }
}

 class WindowsCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering Windows Checkbox");
    }
}

// Mac versions
 class MacButton implements Button {
    public void paint() {
        System.out.println("Rendering Mac Button");
    }
}

 class MacCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering Mac Checkbox");
    }
}


 interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}


 class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

 class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}


 class Main {
    private Button button;
    private Checkbox checkbox;

    public Main(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }

    public static void main(String[] args) {
        // Example: based on OS
        String osType = "mac"; // or "windows"

        GUIFactory factory;
        if (osType.equalsIgnoreCase("mac")) {
            factory = new MacFactory();
        } else {
            factory = new WindowsFactory();
        }

        Main app = new Main(factory);
        app.paint();
    }
}
