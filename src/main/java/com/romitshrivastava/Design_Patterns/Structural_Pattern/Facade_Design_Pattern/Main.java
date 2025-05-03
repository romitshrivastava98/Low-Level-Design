package com.romitshrivastava.Design_Patterns.Structural_Pattern.Facade_Design_Pattern;

// Subsystem 1: Account Verification
class AccountVerifier {
    private int accountNumber;

    public AccountVerifier(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean verifyAccount(int accountNumber) {
        return this.accountNumber == accountNumber;
    }
}

// Subsystem 2: Fund Verification
class FundChecker {
    private double balance = 1000.00;  // Example starting balance

    public boolean hasSufficientFunds(double amount) {
        return balance >= amount;
    }

    public void withdrawFunds(double amount) {
        balance -= amount;
        System.out.println("Withdrawal Successful. New Balance: " + balance);
    }

    public void depositFunds(double amount) {
        balance += amount;
        System.out.println("Deposit Successful. New Balance: " + balance);
    }
}

// Subsystem 3: Transaction Processor
class TransactionProcessor {
    public void processWithdrawal() {
        System.out.println("Processing withdrawal...");
    }

    public void processDeposit() {
        System.out.println("Processing deposit...");
    }
}

// The Facade Class: Simplifies interactions
class BankFacade {
    private AccountVerifier accountVerifier;
    private FundChecker fundChecker;
    private TransactionProcessor transactionProcessor;

    public BankFacade(int accountNumber) {
        this.accountVerifier = new AccountVerifier(accountNumber);
        this.fundChecker = new FundChecker();
        this.transactionProcessor = new TransactionProcessor();
    }

    public void withdrawCash(int accountNumber, double amount) {
        System.out.println("\n--- Withdrawal Request ---");
        if (accountVerifier.verifyAccount(accountNumber)) {
            if (fundChecker.hasSufficientFunds(amount)) {
                transactionProcessor.processWithdrawal();
                fundChecker.withdrawFunds(amount);
            } else {
                System.out.println("Insufficient Funds!");
            }
        } else {
            System.out.println("Invalid Account!");
        }
    }

    public void depositCash(int accountNumber, double amount) {
        System.out.println("\n--- Deposit Request ---");
        if (accountVerifier.verifyAccount(accountNumber)) {
            transactionProcessor.processDeposit();
            fundChecker.depositFunds(amount);
        } else {
            System.out.println("Invalid Account!");
        }
    }
}

// Client Code
public class Main {
    public static void main(String[] args) {
        int myAccount = 12345;
        BankFacade myBank = new BankFacade(myAccount);

        // Withdraw Cash
        myBank.withdrawCash(12345, 500);

        // Deposit Cash
        myBank.depositCash(12345, 300);

        // Trying with an invalid account
        myBank.withdrawCash(99999, 100);
    }
}

