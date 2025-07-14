package LambdaExpression;

import javax.management.openmbean.CompositeDataSupport;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {

    /*
        Consumer is also a functional interface just similar to the Predicate and Function
        which has only one abstract method "accept(T t)".

        Doesn't return anything
     */

    public static void main(String[] args) {

        Consumer<Integer> print = x -> System.out.println(x);

        print.accept(41);

        List<Integer> list = Arrays.asList(7, 54, 2, 3, 39, 1);
        Consumer<List<Integer>> printList = x -> {
            for (Integer num: x)
                System.out.print(num+" ");
        };
        printList.accept(list);
    }
}
