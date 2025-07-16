package Locks;

public class BankAccount {

    private int balance = 1000;

    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" attempting to withdraw "+amount);
        if (balance >= amount){
            System.out.println(Thread.currentThread().getName() + " processing with withdrawal");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName()+" completed withdrawal. Remaining balance "+balance);

        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient balance");
        }
    }
}
