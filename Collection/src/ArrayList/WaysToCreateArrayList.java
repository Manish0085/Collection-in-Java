package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WaysToCreateArrayList {
    
    public static void way(){

        // way 1
        ArrayList<String> list1 = new ArrayList<>();
        System.out.println(list1.getClass().getName());


        // way 2
        // but this will create a unmodified list
        List<String> list2 = Arrays.asList("Onion", "Potato", "Tomato");
        System.out.println(list2.getClass().getName());
//        list2.add("Reddish");   // throw an exception because we can't be add
        list2.set(2, "Reddish"); // but we can set the element at the existing index

        System.out.println(list2);


        
        // way 3
        String[] days = {"Monday", "Tuesday", "Wednesday"};
        List<String> list3 = Arrays.asList(days);
        System.out.println(list3.getClass().getName());
        
        // way 4
        // returns unmodifiable list
        List<Integer> list = List.of(1, 8, 9, 5, 6);
//        list.set(2, 80);  //exception

        List<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(5);
        list4.add(2);
        list4.addAll(list);
//        list.addAll(list4);
        System.out.println(list4);
    }

    public static void createArrayFromList(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        Object[] array = list.toArray();
        for (Object x: array)
            System.out.println(x);

        list.toArray(list.toArray(new Integer[0]));
    }

    public static void main(String[] args) {
        createArrayFromList();
    }
}
