package Stream;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Examples {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Anna", "Bob", "Charlie", "David", "");

        // Example 1: find those names from above list/collection which has the length greater than 3
        List<String> greaterThan3 = names.stream().filter(x -> x.length() > 3).toList();
        greaterThan3.stream().forEach(System.out::println);

        // Example 2: Squaring and sorting numbers
        List<Integer> numbers1 = Arrays.asList(5, 2, 9, 1, 6);
        System.out.println(numbers1.stream().map(x -> x * x).sorted().toList());

        // Example 3: Summing Values
        List<Integer> numbers2 = Arrays.asList(1, 8, 5, 3, 12, 0);
        System.out.println(numbers2.stream().reduce(Integer::sum).get());
        // we are going to reduce the collection hence we used the reduce operation


        // Example 4: counting occurrence of characters
        String sentence = "Hello World";
        // someString.chars() is the method to create a stream of sentence which creates a stream of integers corresponding to the characters in the sentence
        IntStream chars = sentence.chars();
        System.out.println(sentence.chars().filter(x -> x == 'l').count());


        // Example 5:
        // Stream cannot be reused after a terminal operation has been called
        Stream<String> streamOfName = names.stream();
        streamOfName.forEach(System.out::println);
        System.out.println(streamOfName.map(String::toUpperCase).toList()); // throws as stream is again used after applying the terminal(forEach() operation) operation on it


        // stateful and stateless operations

    }
}
