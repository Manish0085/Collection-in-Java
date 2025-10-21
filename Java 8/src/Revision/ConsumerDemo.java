package Revision;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer<String> consumer1 = (str) -> System.out.println(str);
        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("Hello ");

        Consumer<String> consumer3 = (str) -> System.out.println(str.length());
        consumer3.accept("Java");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> multiplyBy2 = n -> System.out.println(n * 2);

        numbers.forEach(multiplyBy2);
    }
}
