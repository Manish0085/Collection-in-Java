package LambdaExpression;

import java.util.function.Predicate;

public class PredicateDemo {

    /*
        Predicate

               --> Predicate is a FunctionalInterface which has only one abstract method "test()"(A boolean valued Function)

     */

    public static void main(String[] args) {
        // Predicate holds a condition
        // You store the condition into a variable
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(5));

        Predicate<String> isWordStartingWithLetterA = x -> x.startsWith("A");
        System.out.println("For Ankit: "+isWordStartingWithLetterA.test("Ankit"));
        System.out.println("For Ramesh: "+isWordStartingWithLetterA.test("Ramesh"));
        System.out.println("For ankit: "+isWordStartingWithLetterA.test("ankit"));

        Predicate<String> isWordEndsWithA = x -> x.endsWith("A");
        System.out.println(isWordEndsWithA.test("Akshita"));

        // You can combine the predicate
        Predicate<String> combinesWithAnd = isWordStartingWithLetterA.and(isWordEndsWithA);
        System.out.println(combinesWithAnd.test("Akshita"));
        Predicate<String> combinesWithOr = isWordStartingWithLetterA.or(isWordEndsWithA);
        System.out.println(combinesWithOr.test("Akshita"));
    }
}
