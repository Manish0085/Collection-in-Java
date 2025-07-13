package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

    // Deque --> Double ended Queue

    public static void dequeDemo(){

        // Deque is double ended queue
        // allows insertion and removal of elements from both ends
        // versatile than regular queues and stacks because they support all the operations of both


        /*
            INSERTION METHOD

            addFirst(E e): Insert the specified element at the front.
            addLast(E e): Insert the specified element at the end.
            offerFirst(E e): Insert the specified element at the front if possible.
            offerLast(E e): Insert the specified element at the end if possible

         */

        /*

             DELETION METHOD

             removeFirst(): Retrieves and removes the first element.
             removeLast(): Retrieves and removes the Last element.
             pollFirst(): Retrieves and removes the first element, or return null if empty.
             pollLast(): Retrieves and removes the Last element, or return null if empty.
         */


        /*

             EXAMINATION METHOD

             getFirst(): Retrieves, but does not remove the first element.
             getLast(): Retrieves, but does not remove the Last element.
             peekFirst(): Retrieves but does not remove the first element, or return null if empty.
             peekLast(): Retrieves but does not remove the Last element, or return null if empty.
         */

        /*
              STACK METHODS

              push(E e): Adds an element at the front (equivalent to addFirst(E e)).
              pop(): Removes and returns the first element (equivalent to removeFirst()).
         */


        // In case of ArrayList, An internal array is used to store the data
        // it is memory efficient(low memory usage)
        // faster iteration because array stores the data at the contiguous memory location
        // No null allowed
        // Also in ArrayDeque, the circular array is used
        // head and tail pointers are used to point start and end of the array
        // hence there is no need to shift the elements as we perform add, remove operation on the Deque
        Deque<Integer> deque1 = new ArrayDeque<>();
        deque1.addFirst(10);  // 10
        deque1.addLast(20);   // 10 20
        deque1.offerFirst(5); // 5 10 20
        deque1.offerLast(25); // 5 10 20 25

        System.out.println(deque1);
        System.out.println("First Element: "+deque1.getFirst()); // output 5
        System.out.println("Last Element: "+deque1.getLast()); // output 25

        deque1.removeFirst(); // removes 5
        // Here as we remove the 5 from the front of the deque than instead of shifting all the elements of the array to left side (in the direction of front)
        // the pointer which has been pointing to the five will increase by 1 and will be pointing to the next element in the array
        // Hence No need to shift the elements to right or left, just move the pointers.
        deque1.pollLast(); // removes 25
        // Current Deque: [10, 20]

        for(Integer num: deque1){
            System.out.println(num);
        }

        // In case of LinkedList, LinkedList is used to store the data
        // it is memory inefficient because(more memory usage)
        // slower iteration because LinkedList stores the data in nodes
        // No null allowed
        // Use only when we require the insertion, deletion somewhere in the middle
        Deque<Integer> deque2  = new LinkedList<>();
    }

    public static void main(String[] args) {
        dequeDemo();
    }

}
