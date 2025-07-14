package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {

    // Terminal Operations means "Extract the result form the stream".
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 5, 8, 7, 2, 9);

         // 1. collect()
        System.out.println(list.stream().skip(3).collect(Collectors.toList()));
        System.out.println(list.stream().skip(5).toList()); // toList() accumulate the stream into Unmodifiable list

        // 2. forEach()
        list.stream().forEach(System.out::println);

        // 3. reduce(): Combines elements to produce a single result
        // "(x, y) -> x + y" also called as accumulator
        Optional<Integer> optionalInteger = list.stream().reduce((x, y) -> x + y);
        Optional<Integer> optionalInteger1 = list.stream().reduce(Integer::sum);
        System.out.println(optionalInteger1.get());

        // 4. count()
        System.out.println(list.stream().filter(x -> x  % 2 == 0).count());


        // anyMatch(), allMatch(), noneMatch(), findFirst(), findAny() are these are short circuit operations because as soon as they find something they stop processing ahead
        // 5. anyMatch(), allMatch(), noneMatch()
        System.out.println(list.stream().anyMatch(x -> x % 2 == 0));
        System.out.println(list.stream().allMatch(x -> x % 2 == 0));
        System.out.println(list.stream().noneMatch(x -> x % 2 == 0));


        // 6. findFirst(), findAny()
        System.out.println(list.stream().findAny().get());
        System.out.println(list.stream().findFirst().get());

        // 7. toArray()
        // to convert the stream into array
        Object[] array = Stream.of(1, 2, 3, 4).toArray();

        // 8. min / max
        System.out.println("Max: "+Stream.of(2, 77, 26, 85, 2, 65).max(Comparator.naturalOrder()).get());
        System.out.println("Min: "+Stream.of(2, 77, 26, 85, 2, 65).min((a, b) -> a-b).get());


        // 9. forEachOrdered()
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Using forEach with parallel stream: ");
        list1.stream().forEach(System.out::println);
        System.out.println("Using forEachOrdered with parallel stream: ");
        list1.stream().forEachOrdered(System.out::println);


    }
}
