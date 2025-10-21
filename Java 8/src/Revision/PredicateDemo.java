package Revision;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(10));
        System.out.println(isEven.test(101));

        BiPredicate<Integer, Integer> isSumEven = (a, b) -> (a + b) % 2 == 0;
        System.out.println(isSumEven.test(12, 52));
        System.out.println(isSumEven.test(12, 21));
    }
}
