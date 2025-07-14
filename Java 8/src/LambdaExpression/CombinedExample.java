package LambdaExpression;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CombinedExample {

    public static void main(String[] args) {
        // holds the condition
        Predicate<Integer> predicate = x -> x % 2 == 0;

        // Take something and process that and give the output
        Function<Integer, Integer> function = x -> x*x;

        Consumer<Integer> consumer = x -> System.out.println(x);

        // return something only
        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }



    }
 }
