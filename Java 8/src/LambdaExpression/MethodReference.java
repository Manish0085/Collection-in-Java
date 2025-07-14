package LambdaExpression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReference {

    /*
        Method Reference --> Method reference allows you to use the method without invoking that method & in place of lambda Expression
                         --> Lambda Expression can be replaced with method reference which minimizes the code too.
     */

    public static void main(String[] args) {

        List<String> students = Arrays.asList("Ram", "Shyam", "Ghanshyam");
        students.forEach(x -> System.out.println(x));
        // In above expression we use lambda expression and invoke the println() method by calling it.
        System.out.println();
        students.forEach(System.out::println); // Lambda Expression is replaced by Method reference
        // in the above statement we didn't invoke the println method to print each student,
        // instead we give the reference of the println() method using the "::" operator.

        // Constructor Reference
        List<String> names = Arrays.asList("A", "B", "C");
        List<MobilePhone> listOfMobilePhone = names.stream().map(MobilePhone::new).collect(Collectors.toList());

    }

}

class MobilePhone {
    String name;

    public MobilePhone(String name) {
        this.name = name;
    }
}
