package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i: list){
            System.out.println(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
//
//        for (Integer num: numbers){
//            if (num % 2 == 0){
//                numbers.remove(num);
//            }
//        }


        // iterators allows you to update while reading the collection
        Iterator<Integer> iterator1 = numbers.iterator();
        while (iterator1.hasNext()){
            Integer number = iterator1.next();
            if (number % 2 == 0){
                iterator1.remove();
            }
        }
        System.out.println(numbers);

        ListIterator<Integer> integerListIterator = numbers.listIterator();

        while (integerListIterator.hasNext()){
            integerListIterator.set(4);
        }

    }

}
