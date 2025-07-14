package LambdaExpression;

import java.util.function.Supplier;

public class SupplierDemo {

    /*
        Supplier Doesn't take any argument but returns something
     */

    public static void main(String[] args) {

        Supplier<String> giveHelloWorld = () -> "Hello World";
        System.out.println(giveHelloWorld.get());
    }

}
