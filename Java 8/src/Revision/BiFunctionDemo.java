package Revision;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionDemo {

    public static BiFunction<Integer, Integer, Integer> addFunction = (a, b) -> a + b;


    public static BiFunction<Integer, Integer, Integer> subtractFunction = (a, b) -> a - b;


    public static void main(String[] args) {
        int result = addFunction.apply(10, 20);
        System.out.println("Sum: " + result);

        System.out.println("Subtraction: " + subtractFunction.apply(41, 8));

        Function<Integer, Integer> multiply = x -> x * 2;
        BiFunction<Integer, Integer, Integer> combinedFunction =
                addFunction.andThen(multiply);
        System.out.println(combinedFunction.apply(4, 5));

    }
}
