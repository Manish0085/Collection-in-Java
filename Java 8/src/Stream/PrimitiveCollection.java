package Stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveCollection {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(numbers);

        // boxed() means we are converting this primitive type stream into wrapper
        System.out.println(IntStream.range(1, 5).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList()));

        IntStream.of(1, 5, 6, 7, 3, 23);

        DoubleStream doubles = new Random().doubles(5);
//        System.out.println(doubles.sum());
//        System.out.println(doubles.max());
//        System.out.println(doubles.min());
//        System.out.println(doubles.average());
//        System.out.println(doubles.count());
//        doubles.summaryStatistics();
//        System.out.println(doubles.mapToInt(x -> (int) (x+1)).boxed().toList());
        System.out.println(doubles.boxed().toList());

        IntStream ints = new Random().ints(5);
        System.out.println(ints.boxed().toList());
    }

}
