package Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstStreamDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(52, 78, 95, 63, 2, 55, 31);

        // LIST: EVEN Numbers from numbers list

        // ITERATION 1
        List<Integer> evenNumber1 = new ArrayList<>();
        for(int num: numbers){
            if (num % 2 == 0){
                evenNumber1 .add(num);
            }
        }
        System.out.println("Even numbers list without Streams: "+evenNumber1);


        // ITERATION 2
        Stream<Integer> integerStream1 = numbers.stream();
        Stream<Integer> integerStream2 = integerStream1.filter(p);
        List<Integer> evenNumber2 = integerStream2.toList();
        System.out.println("\nEven numbers list without Streams: "+evenNumber2);


        // ITERATION 3
        System.out.println("\nEven number list from number list: ");
        List<Integer> evenNumber3 = numbers.stream()
                .filter(p2)
                .collect(Collectors.toList());
//                .forEach(System.out::println);

        System.out.println("\nEven numbers list without Streams: "+evenNumber3);

    }

    static Predicate<Integer> p = new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            int remainder = integer % 2;
            if (remainder == 0)
                return true;
            return false;
        }
    };

    static Predicate<Integer> p2 = (num) -> num % 2 == 0;
}
