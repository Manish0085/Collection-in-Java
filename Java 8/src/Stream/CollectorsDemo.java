package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {

    public static void main(String[] args) {
        // Collector is a utility class
        // provides a set of methods to create common collectors

        // 1. Collecting to List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> res = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(res);

        // 2. Collecting to set
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 4, 5, 3);
        Set<Integer> set = nums.stream().collect(Collectors.toSet());
        System.out.println(set);

        // 3. Collecting to a specified Collection
        ArrayDeque<String> arrayDeque = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));
        // Any collection can be passed to "toCollection(supplier)"

        // 4. Joining Strings
        // Concatenates stream elements to a single String
        System.out.println(names.stream().map(String::toUpperCase).collect(Collectors.joining()));
        System.out.println(names.stream().map(String::toUpperCase).collect(Collectors.joining(",")));
        System.out.println(names.stream().map(String::toUpperCase).collect(Collectors.joining(", ")));

        // 5. Summarizing Data
        // Generates statistical summary(count, sum, min, average, max)
        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11);
        IntSummaryStatistics states = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: "+states.getCount());
        System.out.println("Sum: "+states.getSum());
        System.out.println("Min: "+states.getMin());
        System.out.println("Max: "+states.getMax());
        System.out.println("Average: "+states.getAverage());


        // 6. Calculating Averages
        System.out.println("Calculating Average using stream directly: "+ numbers.stream().collect(Collectors.averagingInt(x -> x)));

        // 7. Counting Elements
        System.out.println("Counting elements in collection using stream directly: " + numbers.stream().collect(Collectors.counting()));

        // 8. Grouping Elements
        List<String> words = Arrays.asList("Hello", "World", "Java", "streams", "collecting");
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.joining(", "))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));
        TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(treeMap);

        // 9. Partitioning Elements
        // Partitions element into two groups (true or false) based on a predicate
        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)));

        // 10. Mapping and Collecting
        // Applies a mapping function before collecting
        System.out.println(words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList())));
    }
}
