package Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;

public class SynchronousQueueDemo {

    public static void main(String[] args) {


        BlockingQueue<String> queue4 = new SynchronousQueue<>();
        // Each insert operation must wait for a corresponding remove operation by another thread and vice versa.
        // it cannot store element, capacity of at most one element

        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer is waiting to transfer...");
                queue4.put("Hello from Producer!");
                System.out.println("Producer has transformed the message.");
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Producer was interrupted");
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Consumer is waiting to receive...");
                String message = queue4.take();
                System.out.println("Consumer received: "+message);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Consumer was interrupted");
            }
        });

        producer.start();
        consumer.start();
    }
}
