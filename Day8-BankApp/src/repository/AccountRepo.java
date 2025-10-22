package repository;

import domain.Account;
import domain.Customer;

import java.util.*;

public class AccountRepo {

    private final Map<String, Account> accountByNumber =
            new HashMap<>();

    public void save(Account account){
        accountByNumber.put(account.getAccountNumber(), account);
    }


    public List<Account> findAll(){
        return new ArrayList<>(accountByNumber.values());
    }

    public Optional<Account> findByAccountNumber(String acccountNumber) {
        return Optional.ofNullable(accountByNumber.get(acccountNumber));
    }

    public List<Account> findByCustomerId(String customerId) {
        ArrayList<Account> result = new ArrayList<>();
        for (Account account: accountByNumber.values()){
            if (account.getCustomerId().equals(customerId)){
                result.add(account);
            }
        }
        return result;
    }
}
