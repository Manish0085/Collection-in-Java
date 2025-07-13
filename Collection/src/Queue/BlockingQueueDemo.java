package Queue;

import java.util.Comparator;
import java.util.concurrent.*;

public class BlockingQueueDemo {


    public static void main(String[] args) {

        // Thread-safe
        // wait for queue to become non-empty / wait for space
        // simplify concurrency problems like producer-consumer
        // In standard queue --> the operation executes immediately
        //    ---> if standard queue is empty, and we are removing something from it than it won't wait and throw the exception
        //    ---> similarly if standard queue is full, and we are adding something in that operation on it than it won't wait and throw the exception


        /*
            BLOCKING QUEUE

            put ---> Blocks if the queue is full until space becomes available
            take ---> Blocks if the queue is empty until an element becomes available
            offer ---> wait for space to become available, up to the specified timeout

         */



        //A bounded, blocking queue backed by circular array
        // low memory Overhead
        // uses a single lock for both enqueue and dequeue operation
        // more thread --> problem
        BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<>(5);
        Thread producer = new Thread(new Producer(queue1));
        Thread consumer = new Thread(new Consumer(queue1));

        producer.start();
        consumer.start();


        BlockingQueue<Integer> queue2 = new LinkedBlockingQueue<>();
        // optionally bounded backed by LinkedList
        // Uses two separate locks for enqueue and dequeue operations
        // Higher concurrency between producer and consumer
        // useful when more no. of threads are there


        BlockingQueue<String> queue3 = new PriorityBlockingQueue<>(10, Comparator.reverseOrder());
        // Unbounded, put won't block
        // Creates a PriorityBlockingQueue with the default initial capacity 11 that orders its elements according to their natural ordering.
        // Binary heap as array and can grow dynamically
        // Head is based on their natural ordering or provided Comparator like PriorityQueue.

        queue3.add("Apple");
        queue3.add("Banana");
        queue3.add("Cherry");
        queue3.add("Mango");
        System.out.println(queue3 );





    }
}

class Producer implements Runnable{

    private BlockingQueue<Integer> queue;

    private int value = 0;

    public Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        while (true){
            try {
                System.out.println("Produced Value: "+value);
                queue.put(value++);
                Thread.sleep(1000);
            }catch (Exception e){
                Thread.currentThread().interrupted();
                System.out.println("Producer Interrupt");
            }

        }
    }
}

class Consumer implements Runnable{

    private BlockingQueue<Integer> queue;


    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }


    @Override
    public void run() {
        while (true){
            try {
                Integer take = queue.take();
                System.out.println("Consumer consumed: "+take);
                Thread.sleep(2000);
            }catch (Exception e){
                Thread.currentThread().interrupted();
                System.out.println("Consumer Interrupt");
            }

        }
    }
}
