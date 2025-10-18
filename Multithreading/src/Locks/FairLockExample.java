package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {


    private final Lock lock = new ReentrantLock(true);

    public void accessLock(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock");
            Thread.sleep(1000);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            System.out.println(Thread.currentThread().getName() + " released the lock");
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        FairLockExample example = new FairLockExample();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessLock();
            }
        };
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
