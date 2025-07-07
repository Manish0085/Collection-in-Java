package ArrayList;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ShowInitialCapacity {

    public static void initialCapacity() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(40);
        list.add(7);
        list.add(8);
        list.add(45);
        list.add(99);
        list.add(62);

        System.out.println(list.get(5));
        System.out.println(list.size());

        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData= (Object[]) field.get(list);

        System.out.println("ArrayList Initial Capacity :- "+ elementData.length);
    }

    public void howCapacityGrows(){
        ArrayList<String> list = new ArrayList<>(10);   //How to set initial capacity and by default is 10
        System.out.println(list.size());  // 0

        list.add("Apple");
        list.add("Mango");
        list.add("Banana");
        list.add("Guvava");
        list.add("Date");
        list.add("Kiwi");
        list.add("PineApple");
        list.add("Papaya");
        list.add("Grapes");
        list.add("Orange");


        //here the capacity is 10

        list.add("New Fruit");
        // here  the capacity becomes 1.5 time of the initial capacity

        list.remove(2);
        list.remove("Apple");
        //but here the capacity doesn't shrink automatically

        list.trimToSize();
        //this will shrink the size

    }
}
