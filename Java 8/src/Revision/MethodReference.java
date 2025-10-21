package Revision;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReference {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Charlie", "Bob");
        // 1. Using for loop
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
        // 2. Using enhanced for loop
        System.out.println();
        for (String name: names)
            System.out.println(name);

        // 3.
        System.out.println();
        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // 4.
        System.out.println();
        names.forEach((name) -> System.out.println(name));

        // 5. Using Method Reference
        System.out.println();
        names.forEach(System.out::println);
    }
}
