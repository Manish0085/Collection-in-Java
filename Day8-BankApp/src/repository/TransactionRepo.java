package repository;

import domain.Transaction;

import java.util.*;

public class TransactionRepo {

    private final Map<String, List<Transaction>> txByAccount =
            new HashMap<>();


    public void save(Transaction transaction) {
//        List<Transaction> transactions = txByAccount.computeIfAbsent(transaction.getAccountNumber(),
//                key -> new ArrayList<>());
//        transactions.add(transaction);


        txByAccount.computeIfAbsent(transaction.getAccountNumber(),
                key  -> new ArrayList<>()).add(transaction);
    }

    public List<Transaction> findByAccountNumber(String accountNumber) {
        return new ArrayList<>(txByAccount.getOrDefault(accountNumber, Collections.emptyList()));
    }
}
