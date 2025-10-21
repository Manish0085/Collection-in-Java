package Revision;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        // Stream --> Assembly line / pipeline

        List<String> items = Arrays.asList("Apple", "Banana", "Cherry");
        for (String fruit: items)
            System.out.println(fruit);


        // using stream
        System.out.println();
        Stream<String> stream1 = items.stream();
        stream1.forEach(System.out::println);


        System.out.println("Items whose name starts with \"B\"");
        Stream<String> stream2 = items.stream();
        Stream<String> filteredStream = stream2.filter(item -> item.startsWith("B"));
        filteredStream.toList().forEach(System.out::println);

        System.out.println();
        items.stream()
                .filter(item -> item.startsWith("B"))
                .toList().forEach(System.out::println);



        /*
           * USE CASES:
           * 1. Filtering
           * 2. Mapping
           * 3. Aggregation
           * 4. Searching
           * 5. Iteration

         */

        List<Integer> numbers = Arrays.asList(4, 85, 65, 7, 24, 32, 6);
        List<Integer> evenList = numbers.stream()   // source
                .filter(num -> num % 2 == 0)   // Intermediate operations (filtering)
                .toList();  // Terminal operation (Collecting)


    }
}
