package Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        Integer pop = stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());

        int search = stack.search(4  );
        System.out.println(search);

        //LinkedList as Stack
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.removeLast(); //pop()
        list.getLast(); // peek()
        list.isEmpty();


        // ArrayList as Stack (Not good practice)
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        arrayList.get(arrayList.size()-1); //peek()
        arrayList.remove(arrayList.size()-1); //pop()

    }
}
