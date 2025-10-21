package PracticeQuestions;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Examples {

    public static void main(String[] args) {
        // Question 1: Use Java 8 Stream API to filter even numbers from a list.
        List<Integer> numbers = Arrays.asList(8, 6, 25, 7, 65, 21, 23, 74, 62);
        System.out.print("Even number in the list are: ");
        numbers.stream()
                .filter(x -> x % 2 == 0)
                .forEach(x -> System.out.print(x + " "));
        System.out.println();


        // Question 2: Use lambda to sort a list of strings by length.
        System.out.print("Sorted list of string based on their length: ");
        List<String> strings = Arrays.asList("Java", "Spring", "Hibernate", "JSP");
        strings.stream()
                .sorted((a, b) -> a.length() - b.length())
                .forEach(x -> System.out.print(x + ", "));
        System.out.println();


        // Question 3: Write a program to count the number of strings starting with "A" using Streams.
        List<String> list1 = Arrays.asList("Apple", "Banana", "Avocado", "Cherry");
        long count = list1.stream()
                .filter(x -> x.startsWith("A"))
                .count();
        System.out.println("No. of string starts with \"A\" in the list: "+count);


        // Question 4: Optional to avoid NullPointerException.
        Optional<String> optionalString = Optional.ofNullable(null);
        System.out.println("Optional String Value: "+optionalString.orElse("Default Name"));


        // Question 5: Use map() and reduce() to sum squares of numbers.
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        Integer sum = nums.stream()
                .map(x -> x * x)
                .reduce(0, Integer::sum);
        System.out.println("Sum of square of Integers: "+sum);


        // Question 6: How do you sort a List<String> by the last character using Java 8?
        List<String> list2 = Arrays.asList("Java", "Spring", "Hibernate", "Kotlin");
        System.out.print("Sorted List by the last character: ");
        list2.stream()
                .sorted((x, y) -> x.charAt(x.length() - 1) - y.charAt(y.length() - 1))
                .forEach(x -> System.out.print(x+", "));
        System.out.print("\nSorted List by the last character using Comparator.comparing(): ");
        list2.stream()
                .sorted(Comparator.comparing(x -> x.charAt(x.length() - 1)))
                .forEach(x -> System.out.print(x + ", "));
        System.out.println();


        // Question 7: Find the first non-empty string in a list using Optional
        List<String> list3 = Arrays.asList("", null, "Java", "Spring");
        Optional<String> first = list3.stream()
                .filter(x -> x != null && !x.isEmpty())
                .findFirst();
        System.out.print("first non-empty string in a list: ");
        first.ifPresent(System.out::println);


        // Question 8: Write code to group a list of words by their length.
        List<String> words1 = Arrays.asList("apple", "banana", "cherry", "dog", "egg");
        Map<Integer, List<String>> collect = words1.stream()
                .collect(Collectors.groupingBy(x -> x.toString().length()));
        System.out.println(collect);

        // Question 9:  Count occurrences of each word in a list (word frequency map).
        List<String> words2 = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        Map<String, Long> collect1 = words2.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);
    }
}
