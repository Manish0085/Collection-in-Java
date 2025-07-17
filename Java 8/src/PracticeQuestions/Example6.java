package PracticeQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Example6 {

    public static void main(String[] args) {
        /*
            Question: Given a list of integers, remove the duplicate values using streams.
         */

        List<Integer> numbers = Arrays.asList(7, 58, 64, 7, 1, 2, 1, 95, 3, 2);
        Stream<Integer> distinct = numbers.stream()
                .distinct();
        distinct.forEach(System.out::println);


        /*
                Question: Sort a list of strings alphabetically using streams.
         */
        List<String> fruits = Arrays.asList("Mango", "Papaya", "Apple", "Banana", "Litchi", "Kiwi");
        fruits.stream()
                .sorted((a, b) -> a.compareTo(b))
                .forEach(x -> System.out.print(x+" "));

        System.out.println();

        /*
            Question: Sum all the numbers in a list using streams.
         */

        Optional<Integer> sum = numbers.stream()
                .reduce((Integer::sum));
        System.out.println("Sum: "+sum.get());

        /*
    Question: Convert a list of names into a single comma-separated string.
         */
        Optional<String> combineString = fruits.stream()
                .reduce((a, b) -> a + ", " + b);
        System.out.println(combineString.get());

        /*
            Question:  Write a Java 8 program to find the first non-empty string from a list.
         */
        List<String> strings = Arrays.asList("", " ", "", "Java", "Stream", "Lambda");
        Optional<String> first = strings.stream()
                .map(String::trim)
                .filter(x -> !x.isEmpty())
                .findFirst();
        if (first.isPresent())
            System.out.println("First non-empty string is "+ first.get());
        else
            System.out.println("No non-empty string found.");

    }
}