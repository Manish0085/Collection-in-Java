package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStreams {

    /*
        A type of stream that enables parallel processing of elements.
        Allowing multiple threads to process parts of the stream simultaneously.
        This can significantly improve performance for large data sets.
        Workload is distributed across multiple threads
     */

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
//        System.out.println(list);
        List<Long> factorials = list.stream().map(ParallelStreams::factorial).toList();
//        System.out.println(factorials);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with streams: "+(endTime - startTime) + " ms");


        startTime = System.currentTimeMillis();
        factorials = list.parallelStream().map(ParallelStreams::factorial).toList();
//        factorials = list.parallelStream().map(ParallelStreams::factorial).sequential().toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallelStream: "+(endTime - startTime) + " ms");

        // Parallel streams are most effective for CPU-intensive tasks or large datasets where tasks are independent
        // They may add overhead for simple tasks or small datasets


        // Cumulative Sum
        // [1, 2, 3, 4, 5] --> [1, 3, 6, 10, 15]

        List<Integer> cumulativeSum = Arrays.asList(1, 2, 3, 4, 5, 6);
        // The variable used in the lambda expression should be final or effectively final otherwise inconsistency may cause hence we cannot use sum variable like this here
//        int sum = 0;
//        cumulativeSum .parallelStream().map(
//                x -> {
//                    int i = x + sum;
//                    sum = i;
//                    return i;
//                }
//        ).toList();


        AtomicInteger sum = new AtomicInteger(1);
        List<Integer> sumList = cumulativeSum.parallelStream().map(x -> sum.addAndGet(x)).toList();
        System.out.println("Expected Sum [1, 3, 6, 10, 15]");;
        System.out.println("Actual result with parallel stream: "+sumList);
    }

    private static long factorial(int n){
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
