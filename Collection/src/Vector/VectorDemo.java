package Vector;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Vector;

public class VectorDemo {

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>(5);
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        System.out.println(vector);
        System.out.println("Initial Capacity :- "+vector.capacity());
        vector.add(6); // capacity becomes double as initial capacity exceeds
        System.out.println(vector);
        System.out.println("Capacity after initial capacity exceeds:- "+vector.capacity());

        Vector<String> vector2 = new Vector<>(5, 3);
        vector2.add("Apple");
        vector2.add("Banana");
        vector2.add("Orange");
        vector2.add("Mango");
        vector2.add("Kiwi");
        System.out.println("Initial Capacity :- "+vector2);
        System.out.println(vector2.capacity());
        vector2.add("Date"); // capacity increases by 3 as initial capacity exceeds
        System.out.println(vector2);
        System.out.println("Capacity after initial capacity exceeds:- "+vector2.capacity());


        Vector<Integer> vector3 = new Vector<>(Arrays.asList(7, 5, 65, 32, 1, 3));

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Dog");
        linkedList.add("Elephant");
        linkedList.add("Cat");
        linkedList.add("Tiger");

        Vector<String> vector4 = new Vector<>(linkedList);
    }
}
