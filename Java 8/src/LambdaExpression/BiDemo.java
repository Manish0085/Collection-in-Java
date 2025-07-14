package LambdaExpression;

import java.awt.im.InputContext;
import java.util.function.*;

public class BiDemo {


    public static void main(String[] args) {

        BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x+y) % 2 == 0;
        System.out.println(isSumEven.test(4, 8));

        BiConsumer<Integer, String> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };

        BiFunction<String, String, Integer> biFunction = (x, y) -> (x + y).length();

        System.out.println(biFunction.apply("abc", "xyz"));

        // UnaryOperator : functional Interface that extends the Function functionalInterface
        //  alternative of Function
        UnaryOperator<Integer> unaryOperator = x -> 2*x;
        // alternative of BiFunction
        BinaryOperator<Integer> binaryOperator = (x, y) -> (x + y);
    }
}
