package app;

import domain.Account;
import service.BankService;
import service.impl.BankServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService bank = new BankServiceImpl();
        System.out.println("Welcome to Console Bank");
        boolean running = true;
        while (running){
            System.out.println("""
                    1. Open Account
                    2. Deposit
                    3. Withdraw
                    4. Transfer
                    5. Account Statement
                    6. List Accounts
                    7. Search Accounts by Customer Name
                    0. Exit
                """);
            System.out.print("CHOOSE: ");
            String choice = scanner.nextLine().trim();
            System.out.println("CHOICE: "+choice);

            switch (choice){
                case "1" -> openAccount(scanner, bank);
                case "2" -> deposit(scanner, bank);
                case "3" -> withdraw(scanner, bank);
                case "4" -> transfer(scanner, bank);
                case "5" -> statements(scanner, bank);
                case "6" -> listAccounts(scanner, bank);
                case "7" -> searchAccount(scanner, bank);
                case "0" -> running = false;
            }
        }


    }



    private static void openAccount(Scanner scanner, BankService bankService) {
        System.out.print("Customer name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Customer email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Account Type (SAVING/CURRENT): ");
        String type = scanner.nextLine().trim();
        System.out.print("Initial Deposit(optional blank for 0): ");
        String amountStr = scanner.nextLine().trim();
        if (amountStr.isBlank()){
            amountStr = "0";
        }
        Double amount = Double.valueOf(amountStr);
        String accountNumber = bankService.openAccount(name, email, type);
        if (amount > 0){
            bankService.deposit(accountNumber, amount, "Initial Deposit");
        }
        System.out.println("Account opened: " + accountNumber);

    }


    private static void deposit(Scanner scanner, BankService bankService) {
        System.out.print("Account Number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.print("Amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankService.deposit(accountNumber, amount, "Deposit");
        System.out.println("Deposited");

    }

    private static void withdraw(Scanner scanner, BankService bankService) {
        System.out.print("Account Number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.print("Amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankService.withdraw(accountNumber, amount, "Withdraw");
        System.out.println("Deposited");


    }

    private static void transfer(Scanner scanner, BankService bankService) {
        System.out.print("From Number: ");
        String fromAccount = scanner.nextLine().trim();
        System.out.print("To Account: ");
        String toAccount = scanner.nextLine().trim();
        System.out.print("Amount: ");

        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankService.transfer(fromAccount, toAccount, amount, "Transfer");
        System.out.println("Deposited");
    }

    private static void statements(Scanner scanner, BankService bankService) {
        System.out.print("Account Statements: ");
        String accountNumber = scanner.nextLine().trim();
        bankService.getStatements(accountNumber)
                .forEach(t -> {
                    System.out.println(t.getTimeStamp() + " | " + t.getType() + " | "  + t.getAmount() + " | " + t.getNote());
                });
    }

    private static void listAccounts(Scanner scanner, BankService bankService) {
        bankService.listAccounts()
                .forEach(account -> {
                    System.out.println(account.getAccountNumber() + " | " + account.getAccountType() + " | " + account.getBalance());
                });
    }

    private static void searchAccount(Scanner scanner, BankService bankService) {
        System.out.print("Customer name contains: ");
        String query = scanner.nextLine().trim();
        bankService.searchAccountsByCustomerName(query)
                .forEach(account -> {
                    System.out.println(account.getAccountNumber() + " | " + account.getAccountType() + " | " + account.getBalance());
                });
    }

}
