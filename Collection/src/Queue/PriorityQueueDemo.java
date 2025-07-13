package Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {

    public static void demo(){

        // Part of the Queue Interface
        // Order the elements based on their natural ordering (for primitives lowest first)
        // can use Custom Comparator for customize ordering
        // does not allow null elements
        // not in sorted manner

        Queue<Integer> priQueue = new PriorityQueue<>();
        priQueue.add(15);
        priQueue.add(10);
        priQueue.add(30);
        priQueue.add(5);
        priQueue.add(33);

        System.out.println(priQueue);
        System.out.println("Peek: "+priQueue.peek());

        while (!priQueue.isEmpty()){
            System.out.println(priQueue.poll());
        }

        // Internal working of the PriorityQueue
        // PriorityQueue is implemented as a min-heap by default (for natural ordering)
        // Min-heap is a binary tree in which each node's value is equal or less than its children node
        // In Min-heap ---> insert ---> O(log N)
        //             ---> delete ---> O(log N)
        //             ---> top ---> O(1)
    }

    public static void main(String[] args) {
        demo();
    }
}
