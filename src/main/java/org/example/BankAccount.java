package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

class BankAccount {
    private String pinCode;
    private double balance;
    private final List<Transaction> transactions;
    private int failedAttempts;
    private ResourceBundle messages;

    public BankAccount(String pinCode, double balance, ResourceBundle messages) {
        this.pinCode = pinCode;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        this.failedAttempts = 0;
        this.messages = messages;
    }

    public boolean checkPin(String inputPin) {
        if (pinCode.equals(inputPin)) {
            failedAttempts = 0;
            return true;
        } else {
            failedAttempts++;
            return false;
        }
    }

    public boolean isBlocked() {
        return failedAttempts >= 3;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("deposit", amount);
            System.out.println(messages.getString("depositSuccess"));
        } else {
            System.out.println(messages.getString("depositNegative"));
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(messages.getString("withdrawalNegative"));
        } else if (amount > balance) {
            throw new IllegalArgumentException(messages.getString("insufficientFunds"));
        } else {
            balance -= amount;
            addTransaction("withdrawal", amount);
            System.out.println(messages.getString("withdrawalSuccess"));
        }
    }


    public void printStatement() {
        System.out.println(messages.getString("statementHeader"));
        transactions.subList(Math.max(0, transactions.size() - 5), transactions.size())
                .forEach(System.out::println);
    }

    public void changePin(String newPin) {
        if (isValidPin(newPin)) {
            this.pinCode = newPin;
            System.out.println(messages.getString("pinChanged"));
        } else {
            System.out.println(messages.getString("invalidPin"));
        }
    }

    private boolean isValidPin(String pin) {
        // ПИН-код должен быть длиной 4-6 цифр
        return pin.matches("\\d{4,6}");
    }

    private void addTransaction(String type, double amount) {
        transactions.add(new Transaction(type, amount));
    }


    public void setMessages(ResourceBundle messages) {
        this.messages = messages;
    }
}
