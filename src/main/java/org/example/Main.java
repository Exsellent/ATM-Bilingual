package org.example;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static BankAccount account;
    private static ResourceBundle messages;

    public static void main(String[] args) {
        System.out.println("Select language / Выберите язык (en/ru):");
        String lang = scanner.nextLine();
        Locale locale = new Locale(lang);

        try {
            messages = ResourceBundle.getBundle("ATM.messages", locale);
        } catch (java.util.MissingResourceException e) {
            System.out.println("Resource bundle not found for the specified locale.");
            return;
        }

        account = new BankAccount("1234", 1000.0, messages);

        while (true) {
            if (account.isBlocked()) {
                System.out.println(messages.getString("accountBlocked"));
                break;
            }

            System.out.println(messages.getString("enterPin"));
            String inputPin = scanner.nextLine();

            if (account.checkPin(inputPin)) {
                showMenu();
            } else {
                System.out.println(messages.getString("incorrectPin"));
            }
        }
    }

    private static void showMenu() {
        while (true) {
            System.out.println("\n" + messages.getString("selectAction"));
            System.out.println("1. " + messages.getString("showBalance"));
            System.out.println("2. " + messages.getString("deposit"));
            System.out.println("3. " + messages.getString("withdraw"));
            System.out.println("4. " + messages.getString("showStatement"));
            System.out.println("5. " + messages.getString("changePin"));
            System.out.println("6. " + messages.getString("exit"));

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println(messages.getString("currentBalance") + account.getBalance());
                        break;
                    case 2:
                        System.out.println(messages.getString("enterDepositAmount"));
                        double depositAmount = Double.parseDouble(scanner.nextLine());
                        account.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.println(messages.getString("enterWithdrawAmount"));
                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
                        account.withdraw(withdrawAmount);
                        break;
                    case 4:
                        account.printStatement();
                        break;
                    case 5:
                        System.out.println(messages.getString("enterNewPin"));
                        String newPin = scanner.nextLine();
                        account.changePin(newPin);
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println(messages.getString("invalidChoice"));
                }
            } catch (NumberFormatException e) {
                System.out.println(messages.getString("enterValidNumber"));
            }
        }
    }
}
