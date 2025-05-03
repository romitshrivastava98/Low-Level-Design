package com.romitshrivastava.Design_Patterns.Behavioral_Pattern.Chan_Of_Responsibility_Design_Pattern;

// Defines a common interface for all support levels
interface SupportHandler {
    void setNextHandler(SupportHandler nextHandler);
    void handleRequest(String issue, int severity);
}

// Level 1 Support: Handles minor issues (severity ≤ 1)
class Level1Support implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String issue, int severity) {
        if (severity <= 1) {
            System.out.println("Level 1 Support: Resolved the issue - " + issue);
        } else if (nextHandler != null) {
            System.out.println("Level 1 Support: Escalating to Level 2...");
            nextHandler.handleRequest(issue, severity);
        } else {
            System.out.println("Level 1 Support: Unable to handle the issue.");
        }
    }
}

// Level 2 Support: Handles moderate issues (severity ≤ 2)
class Level2Support implements SupportHandler {
    private SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(String issue, int severity) {
        if (severity <= 2) {
            System.out.println("Level 2 Support: Resolved the issue - " + issue);
        } else if (nextHandler != null) {
            System.out.println("Level 2 Support: Escalating to Level 3...");
            nextHandler.handleRequest(issue, severity);
        } else {
            System.out.println("Level 2 Support: Unable to handle the issue.");
        }
    }
}

// Level 3 Support: Final escalation level
class Level3Support implements SupportHandler {
    @Override
    public void setNextHandler(SupportHandler nextHandler) {
        // Level 3 is the end of the chain
    }

    @Override
    public void handleRequest(String issue, int severity) {
        System.out.println("Level 3 Support: Resolved the issue - " + issue);
    }
}

// Client code to simulate support system
public class SupportSystem {
    public static void main(String[] args) {
        // Creating the chain of responsibility
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();

        // Setting up the chain
        level1.setNextHandler(level2);
        level2.setNextHandler(level3);

        // Simulate various support requests
        System.out.println("User reports a minor issue (Severity 1)");
        level1.handleRequest("Password Reset", 1);

        System.out.println("\nUser reports a moderate issue (Severity 2)");
        level1.handleRequest("System Crash", 2);

        System.out.println("\nUser reports a critical issue (Severity 3)");
        level1.handleRequest("Database Corruption", 3);
    }
}
