package Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskSubmissionSystem {

    private static ConcurrentLinkedQueue<String> taskQueue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {

        Thread producer = new Thread(() -> {
            while(true){
                try {
                    taskQueue.add("Task "+System.currentTimeMillis()); // Adds task (will use locks internally)

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true){
                try {
                    String task = taskQueue.peek();
                    System.out.println("Processing: "+task); // Takes task (will use lock internally)

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
