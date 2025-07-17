package PracticeQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example5 {



    public static void main(String[] args) {
        /*
            Question:  Given a list of integers, write a stream operation to print all even numbers.
        */
        List<Integer> numbers = Arrays.asList(7, 8, 91, 24, 3, 6, 414, 9);
        numbers.stream()
                .filter(x -> x % 2 == 0)
                .forEach(x -> System.out.print(x+" "));
        System.out.println("\n");

         /*
            Question: Find the maximum number in a list using Java Stream.
          */
        System.out.println("Max: "+numbers.stream().max((a, b) -> a - b).get());
        Integer i = numbers.stream()
                .reduce((a, b) -> a > b ? a : b).get();
        System.out.println("Max using reduce(): "+i);

        /*
        Question: Count how many strings in a list start with the letter "A".

     */
        List<String> names = Arrays.asList("Ankit", "Shakshi", "Anuradha", "Amit", "Rohan", "Ramneet");
        long count = names.stream()
                .filter(x -> x.startsWith("A"))
                .count();

        System.out.println("In the list of names "+ count+" names starts with \"A\"");

        /*
            Question: Convert a list of strings to uppercase using streams.
         */
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    /*
        Question: What are method references? Convert the lambda below into a method reference:
                "list.forEach(s -> System.out.println(s));"

                Method reference is a shortened notation of a lambda expression to call a method
                instead of full lambda expression, you just refer to an existing method by name using
                "::" operator.
                list.forEach(System.out::println);
     */

}
