package LinkedList;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.LinkedList;

public class CollectionLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(8);
        linkedList.add(6);
        linkedList.add(4);
        linkedList.get(1); //O(n)
        linkedList.addLast(5); //O(1)
        linkedList.addFirst(0); //O(n)
        linkedList.getFirst();
        linkedList.getLast();

        linkedList.remove();
        linkedList.removeLast();
        linkedList.removeFirst();

        linkedList.removeIf(x -> x%2 == 0);
        System.out.println(linkedList);


        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Cat", "Dog", "Elephant", "Lion", "Tiger"));
        System.out.println(animals);
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Cat", "Dog", "Lion"));
        System.out.println(animalsToRemove);
        animals.add(3, "Monkey");
        System.out.println(animals);
        animals.removeAll(animalsToRemove);
        System.out.println(animals);
    }
}
