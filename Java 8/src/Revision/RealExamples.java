package Revision;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class RealExamples {

    public static void main(String[] args) {

        BiFunction<String, Double, String> formatter = (title, price) -> title + " costs $" + price;
        System.out.println(formatter.apply("Java Basics", 45.2));
        System.out.println(formatter.apply("The Head First Java", 52.29));
        System.out.println(formatter.apply("C++ Basics", 6.5));


        System.out.println();
        BiConsumer<String, Double> formatterConsumer = (title, price) -> System.out.println(title + " costs $" + price);
        formatterConsumer.accept("Java Basics", 45.2);
        formatterConsumer.accept("The Head First Java", 52.29);

        // isExpensive
        System.out.println();
        Predicate<Double> isExpensive = price -> price > 50;
        System.out.println(isExpensive.test((52.29)));
        System.out.println(isExpensive.test((45.2)));
    }
}
