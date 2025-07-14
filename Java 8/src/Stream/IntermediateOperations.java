package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {

    public static void main(String[] args) {

        // Intermediate Operations transforms a stream into another stream
        // They are lazy, meaning they don't execute until the terminal operation is invoked


        // 1. filter()
        List<String> list = Arrays.asList("Akshit", "Ram", "Shyam", "Akshit", "Ghanshyam", "Arman");
        list.stream(); // converting the collection into stream
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("A"));// performing filter (Intermediate Operation) on the stream whose result will be another stream
        // no filtering is happened at this point because we haven't preformed the terminal operation yet
        // and as we know that streams are lazy because they don't execute until terminal operation is performed

        long result = list.stream().filter(x -> x.startsWith("A")).count();
        // now the filtering is happened because the terminal operation(count()) is used.
        System.out.println(result);


        // 2. map()
        Stream<String> stringStream1 = list.stream().map(x -> x.toUpperCase());
        Stream<String> stringStream2 = list.stream().map(String::toUpperCase);


        // 3. sorted()
        Stream<String> sortedStream1 = list.stream().sorted();
        Stream<String> sortedStreamUsingComparator  = list.stream().sorted((a, b) -> b.length() - a.length());


        // 4. distinct()
        System.out.println("Without distinct: "+list.stream().filter(x -> x.startsWith(x)).count());
        System.out.println("With distinct: "+list.stream().filter(x -> x.startsWith(x)).distinct().count());


        // 5. limit()
//        System.out.println(Stream.iterate(1, x -> x+1).count());
        System.out.println(Stream.iterate(1, x -> x+1).limit(100).count());


        // 6. skip()
        System.out.println(Stream.iterate(1, x -> x+1).skip(10).limit(100).count()); //starts from 11 and will go upto 110 because limit is still 100

        // 7. peek()
        // similar work to forEach() but forEach is terminal Operator nad peek() is a intermediate operation
        // perform an action on each element as it is consumed
        Stream.iterate(1, x -> x+1).skip(10).limit(100).peek(System.out::println).count();


        // 9.flatMap
        // Handle streams of collections, lists or arrays where each element is itself a collection
        // flatten nested structures (e.g., lists within lists) so that they can be processed as a single sequence of elements
        // Transforms and flatten elements at the same time
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grapes")
        );
        System.out.println(listOfLists.get(1).get(1)); // kiwi
        System.out.println(listOfLists.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList());

        List<String> sentences = Arrays.asList(
                "Hello World",
                "Java streams are powerful",
                "flatMap is useful"
        );
        System.out.println(sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).map(String::toUpperCase).toList());

    }
}
