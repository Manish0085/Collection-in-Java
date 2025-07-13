package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void stackOfList(){
        // Linked act as Stack
        LinkedList<Integer> stackOfList = new LinkedList<>();
        stackOfList.addFirst(5);
        stackOfList.addFirst(54);
        stackOfList.addFirst(63);
        stackOfList.addFirst(2);
        stackOfList.addFirst(99); // push()
        System.out.println(stackOfList);
        stackOfList.removeFirst(); // pop()
        System.out.println(stackOfList);
        System.out.println(stackOfList.getFirst()); //peek()
    }

    public static void queueOfList(){
        // LinkedList act as Queue
        LinkedList<Integer> queueOfList = new LinkedList<>();
        queueOfList.addLast(5); // enqueue
        queueOfList.addLast(54); // enqueue
        queueOfList.addLast(63); // enqueue
        queueOfList.addLast(2); // enqueue
        queueOfList.addLast(99); // enqueue
        System.out.println(queueOfList);
        queueOfList.removeFirst(); // dequeue
        System.out.println(queueOfList);
    }

    public static void actualQueueInterface(){
        Queue<Integer> queue = new LinkedList<>();
        System.out.println("Initially the size of queue is "+queue.size());
        queue.add(Integer.valueOf('d'));

        System.out.println(queue.remove()); // Throws the exception if the Queue is empty
        System.out.println(queue.poll()); // return null if the queue is empty

        System.out.println(queue.element()); // Throw the exception if the Queue is empty
        System.out.println(queue.peek()); // return null if the queue is empty


    }

    public static void main(String[] args) {
//        stackOfList();
//        queueOfList();
        actualQueueInterface();

     }
}
