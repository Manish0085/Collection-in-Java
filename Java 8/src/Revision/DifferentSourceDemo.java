package Revision;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DifferentSourceDemo {

    /*
     * From Collections: e.g., collection.stream().
     * From Arrays: e.g., Arrays.stream(array).
     * From Specific Values: e.g., Stream.of("a", "b", "c").
     * From Functions: e.g., Stream.iterate(0, n -> n + 2).
     * From Files: e.g., Files.lines(path).
     * Empty Stream: e.g., Stream.empty().
     */

    public static void main(String[] args) {
        System.out.println("Stream from Collection: ");
        List<Integer> numbers = Arrays.asList(1, 85, 65, 32, 42, 43);
        Stream<Integer> inputStream = numbers.stream();
        inputStream.forEach(System.out::println);

        System.out.println("\nStream form Array: ");
        int[] numberArray = {1, 85, 65, 32, 42, 43};
        IntStream arrayStream = Arrays.stream(numberArray);
        arrayStream.forEach(System.out::println);

        System.out.println("\nStream from Spcific values");
        Stream<String> stringStrem = Stream.of("a", "b", "c", "d");
        Stream<Integer> integerStream1 = Stream.iterate(0, n -> n + 2);
//        integerStream1.forEach(System.out::println);

        System.out.println("\nStream form File: ");
        try {
            Stream<String> path = Files.lines(Path.of("PATH"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        System.out.println("\nEmpty Stream: ");
        Stream<Object> emptyStream = Stream.empty();

    }
}
