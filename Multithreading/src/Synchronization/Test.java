package Synchronization;

public class Test {

    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(counter.getCount());
    }
}

/*

    When a single object/resource is shared between multiple threads then there is the high chances of
    data inconsistency or the data may lose this is called critical section.

    Synchronization:-
    -----------------
        Synchronization in Java is a mechanism that ensures only one thread at a time can access a shared resource (like variables, methods or blocks of code).
        This is crucial to prevent race condition and ensures data consistency when multiple threads work on the same data.

    Why Synchronization ?
    ---------------------
        When multiple threads access shared data without synchronization, it may lead to:
            --> Inconsistency or corrupted result.
            --> Unexpected behaviour (race condition)
            --> Bugs that are hard to reproduce and debug

    Internal working:-
    ------------------
        When a thread in a synchronized method/block, it acquires a monitor lock on the object.
        Other thread trying to enter that synchronized area must wait until the lock is released.

    Downsides of Synchronization:-
    -------------------------------
        --> Reduce the performance due to thread blocking.
        --> Risk of deadlock if not used carefully.
        --> it is also unfair.
        --> No interruptibility
        --> Indefinite blocking
        --> it is not able to distinguish between read and write operation.
 */
