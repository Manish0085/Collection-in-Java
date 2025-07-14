package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluationDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        Stream<String> stream = names.stream()
                .filter(name -> {
                    System.out.println("Filtering: " + name);
                    return name.length() > 3;
                });

        // the above statement won't print because we haven't invoked the terminal operation on the above stream
        // direct the statement "Before terminal operation" will be printing
        System.out.println("Before terminal operation");
        List<String> result = stream.collect(Collectors.toList());


        System.out.println("After the terminal operation");
        System.out.println(result);
    }
}
