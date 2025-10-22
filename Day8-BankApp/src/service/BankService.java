package service;

import domain.Account;
import domain.Transaction;

import java.util.List;

public interface BankService {

    String openAccount(String name, String email, String accountType);

    List<Account> listAccounts();

    void deposit(String accountNumber, Double amount, String deposit);

    void withdraw(String accountNumber, Double amount, String note);

    void transfer(String fromAccount, String toAccount, Double amount, String note);

    List<Transaction> getStatements(String accountNumber);

    List<Account> searchAccountsByCustomerName(String query);
}
