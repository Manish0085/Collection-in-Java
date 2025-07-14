package LambdaExpression;

import java.util.function.Function;

public class FunctionDemo {


    /*
        Function is a FunctionalInterface similar to the Predicate which was introduced in Java 1.8
        which has only one abstract method "apply()".

        Predicate only checks the condition
        function does some work for you
     */

    public static void main(String[] args) {
        // Function<InputType, OutputType>
        Function<Integer, Integer> doubleIt = x -> 2*x;
        Function<Integer, Integer> tripleIt = x -> 3*x;
        System.out.println(doubleIt.apply(4));
        System.out.println(tripleIt.apply(3));

//        Function<Integer, Integer> combineFunction1 = doubleIt.andThen(tripleIt);
        System.out.println(doubleIt.andThen(tripleIt).apply(4));
        System.out.println(tripleIt.andThen(doubleIt).apply(4)); // same to compose
        System.out.println(doubleIt.compose(tripleIt).apply(4)); // same to above

        // identity is a static Method which can be called using just interface name
        Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(5)); // return the input same
    }
}
