package Revision.TerminalOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TerminalOperationDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 8, 65, 1, 32, 13);

        // reduce()
//        int sum = numbers.stream()
//                .reduce(0, (acc, num) -> acc + num)
//                .intValue();
        int sum = numbers.stream()
                        .reduce(0, Integer::sum);

        System.out.println("Sum: " + sum);



        // collect()
        List<Integer> evenNumber = numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even number: "+evenNumber);

        Set<Integer> oddNumber = numbers.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toSet());
        System.out.println("Odd number: "+oddNumber);

        // find & match
        System.out.println("First Element of List: " + numbers.stream()
                .findFirst().get());
        System.out.println("Random Element of List: " + numbers.stream()
                .findAny().get());

        System.out.println(numbers.stream()
                .anyMatch(num -> num == 13));



        // iteration
        numbers.stream()
                .forEach(System.out::println);
    }
}
