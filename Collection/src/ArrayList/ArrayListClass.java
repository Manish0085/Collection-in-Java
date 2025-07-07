package ArrayList;

import java.util.ArrayList;

public class ArrayListClass {

    public static void intoToArrayList(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(40);
        list.add(7);
        list.add(8);
        list.add(45);
        list.add(99);
        list.add(62);

        System.out.println(list.get(5));
        System.out.println(list.size());


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("*************");
        list.set(4, 33);  //set element at the given index or replace the previous one on the give index
        list.add(1, 3);  // add the element on the given index and move the other element to right by one place
        list.remove(5);  // remove the element from the given index
        list.remove(Integer.valueOf(40)); // remove the given object from the list
        for (int x: list){
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        intoToArrayList();
    }
}
