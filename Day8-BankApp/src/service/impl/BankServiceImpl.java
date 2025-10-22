package service.impl;


import domain.Account;
import domain.Customer;
import domain.Transaction;
import domain.Type;
import exception.AccountNotFoundException;
import exception.InsufficientFundsException;
import exception.ValidationException;
import repository.AccountRepo;
import repository.CustomerRepo;
import repository.TransactionRepo;
import service.BankService;
import util.Validation;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService {

    private final AccountRepo accountRepo = new AccountRepo();
    private final TransactionRepo transactionRepo = new TransactionRepo();
    private final CustomerRepo customerRepo = new CustomerRepo();

    private final Validation<String> validateName = name -> {
        if (name == null || name.isBlank()){
            throw new ValidationException("Name is required");
        }
    };

    private final Validation<String> validateEmail = email -> {
        if (email == null || !email.contains("@")){
            throw new ValidationException("Email is required");
        }
    };

    private final Validation<String> validateType = type -> {
        if (type == null || !(type.equalsIgnoreCase("SAVINGS") || type.equalsIgnoreCase("CURRENT"))){
            throw new ValidationException("Type must be \"CURRENT\" or \"SAVING\"");
        }
    };

    private final Validation<Double> validateAmount = amount -> {
        if (amount == null || amount < 0){
            throw new ValidationException("Please enter valid amount");
        }
    };

    @Override
    public String openAccount(String name, String email, String accountType) {
        validateName.validate(name);
        validateEmail.validate(email);
        validateType.validate(accountType);
        String customerId = UUID.randomUUID().toString();

        // Create Customer
        Customer customer = new Customer(customerId, name, email);
        customerRepo.save(customer);

        // Change later --> accountSize + 1 = ACSize
//        String accountNumber = UUID.randomUUID().toString();
        String accountNumber = getAccountNumber();
        Account account = new Account(accountNumber, customerId, 0.0, accountType);
        accountRepo.save(account);
        return accountNumber;
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepo.findAll()
                .stream()
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
    }

    @Override
    public void deposit(String accountNumber, Double amount, String note) {
        validateAmount.validate(amount);
        Account account = accountRepo.findByAccountNumber(accountNumber)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account Not Found "+accountNumber)
                );
        account.setBalance(account.getBalance() + amount);
        Transaction transaction = new Transaction(UUID.randomUUID().toString(), Type.DEPOSIT, account.getAccountNumber(), amount, LocalDateTime.now(), note);
        transactionRepo.save(transaction);

    }

    @Override
    public void withdraw(String accountNumber, Double amount, String note) {
        validateAmount.validate(amount);
        Account account = accountRepo.findByAccountNumber(accountNumber)
                .orElseThrow(() ->
                        new AccountNotFoundException("Account Not Found "+accountNumber)
                );
        if (account.getBalance().compareTo(amount) < 0){
            throw new InsufficientFundsException("Insufficient Balance");
        }
        account.setBalance(account.getBalance() - amount);
        Transaction transaction = new Transaction(UUID.randomUUID().toString(), Type.WITHDRAW, account.getAccountNumber(), amount, LocalDateTime.now(), note);
        transactionRepo.save(transaction);
    }

    @Override
    public void transfer(String from, String to, Double amount, String note) {
        validateAmount.validate(amount);
        if (from.equals(to)) {
            throw new ValidationException("Cannot transfer to your own account");
        }

        Account fromAccount = accountRepo.findByAccountNumber(from)
                .orElseThrow(() -> new AccountNotFoundException("Account Not Found: " + from));

        Account toAccount = accountRepo.findByAccountNumber(to)
                .orElseThrow(() -> new AccountNotFoundException("Account Not Found: " + to));

        // Check balance before transfer
        if (fromAccount.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient Balance");
        }

        // Update balances
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        // Save accounts
        accountRepo.save(fromAccount);
        accountRepo.save(toAccount);

        // Record transactions
        transactionRepo.save(new Transaction(
                UUID.randomUUID().toString(),
                Type.TRANSFER_OUT,
                fromAccount.getAccountNumber(),
                amount,
                LocalDateTime.now(),
                note
        ));

        transactionRepo.save(new Transaction(
                UUID.randomUUID().toString(),
                Type.TRANSFER_IN,
                toAccount.getAccountNumber(),
                amount,
                LocalDateTime.now(),
                note
        ));
    }

    @Override
    public List<Transaction> getStatements(String accountNumber) {
        return transactionRepo.findByAccountNumber(accountNumber)
                .stream()
                .sorted(Comparator.comparing(Transaction::getTimeStamp))
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> searchAccountsByCustomerName(String query) {
        String q = (query == null) ? "" : query.toLowerCase();
//        ArrayList<Account> result = new ArrayList<>();
//        for (Customer customer: customerRepo.findAll()){
//            if (customer.getName().toLowerCase().contains(q)){
//                result.addAll(accountRepo.findByCustomerId(customer.getCustomerId()));
//            }
//        }
//        result.sort(Comparator.comparing(Account::getAccountNumber));


        return customerRepo.findAll()
                .stream()
                .filter(c -> c.getName().toLowerCase().contains(q))
                .flatMap(c -> accountRepo.findByCustomerId(c.getCustomerId())
                        .stream())
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
//        return result;
    }


    private String getAccountNumber() {
        int size = accountRepo.findAll().size() + 1;
        return String.format("AC%06d", size);
    }
}
