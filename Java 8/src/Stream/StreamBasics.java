package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasics {

    /*
        Stream is a feature introduce in Java8.
        It processes the collection of data in a functional and declarative manner
        It simplifies the data processing and enables the functional programming
        Improves the readability and maintainability
        Also we can achieve the parallelism with the help of stream without dealing the complexity of multithreading (Enables easy Parallelism)

        What is stream ?
        ----------------

        Stream is a sequence of elements supporting various operations(functional and declarative programming)

        How to use Streams ?
        ---------------------

        When we use stream, we will be having some source and then some intermediate operation will be performing on that source
        and then lastly the terminal operation will be performed on that source of stream
     */


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 6, 8, 6, 7, 0);
        // Here the source is numbers 1, 2, 6, 8, 6, 7, 0 which is to be converted into stream

        // we can convert any collection into stream by calling stream() method on it
        Stream<Integer> stream = numbers.stream();


        // Creating Stream
        // 1. From Collection
        // find even number using stream
        long count = numbers.stream().filter(x -> x % 2 == 0).count();
        System.out.println(count);

        // 2. From Array
        String[] array = {"Apple", "Banana", "Mango", "Orange"};
        Stream<String> stream1 = Arrays.stream(array);
         
        // 3. Stream.of()
        Stream<String> stream2 = Stream.of("Apple", "Banana", "Mango", "Orange");

        // Infinite Stream
        Stream<Integer> generate = Stream.generate(() -> 1); //  infinite Stream
        Stream<Integer> limit = Stream.generate(() -> 10).limit(100); // Stream of size 100
        System.out.println(generate);
        List<Integer> collect = Stream.iterate(1, x -> x + 1).limit(100).collect(Collectors.toList());
        System.out.println(collect);
    }

}


