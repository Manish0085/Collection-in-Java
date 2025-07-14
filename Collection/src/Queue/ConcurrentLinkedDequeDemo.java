package Queue;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeDemo {

    // non-blocking, thread-safe double-ended queue
    //CAS(Compare-And-Swap)

    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();
        deque.add("Element1");
        deque.addFirst("Element2");
        deque.addLast("Element3");
        System.out.println(deque);

        String first = deque.removeFirst();
        deque.removeLast()
    }
}
