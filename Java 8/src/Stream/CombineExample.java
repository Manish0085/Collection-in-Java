package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class CombineExample {

    public static void main(String[] args) {
        // Example 1: Collecting Names By Length
        List<String> l1 = Arrays.asList("Anna", "Bob", "Alexander", "Brian", "Alice");
        System.out.println(l1.stream().collect(Collectors.groupingBy(String::length)));


        // Example 2: Counting Word Occurrences
        String sentence = "hello world hello java world";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x)));
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));


        // Example 3: Partitioning Even and Odd Numbers
        List<Integer> l2 = Arrays.asList(4, 8, 3, 9, 12, 55, 1, 33);
        System.out.println(l2.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0)));


        // Example 4: Summing values in a Map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Orange", 15);
        Collection<Integer> values = items.values();
        System.out.println("Sum of values in Map: "+items.values().stream().reduce(Integer::sum).get());
        System.out.println("Sum of values in Map using Collector: " + items.values().stream().collect(Collectors.summingInt(x -> x)));


        // Example 5: Create a Map from stream elements (Collectors.toMap())
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Kiwi");
        System.out.println(fruits.stream().collect(Collectors.toMap(String::toUpperCase, String::length)));


        // Example 6:
        List<String> l3 = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana");
        System.out.println(l3.stream().collect(Collectors.toMap(k -> k, v -> 1, (x, y) -> x+y)));
    }
}
