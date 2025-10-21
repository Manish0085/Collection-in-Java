package Revision;

import java.util.function.Function;

public class FunctionInterface {

    public static Function<Integer, Integer> addFunction = (a) -> a + 3;

    public static Function<Integer, Integer> substarctFunction = (a) -> a - 10;

    public static Function<Integer, Integer> combinedFunction =
            addFunction.andThen(substarctFunction);

    public static void main(String[] args) {
        System.out.println(addFunction.apply(4));
        System.out.println(substarctFunction.apply(101));
        System.out.println("Combined Function: " + combinedFunction.apply(18));
    }
}
