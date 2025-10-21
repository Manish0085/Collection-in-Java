package HandlingNullValues;

import java.util.Optional;

public class FunctionalOperations {

    public static void main(String[] args) {

        Optional<String> name = Optional.of("Java");
        Optional<String> nullOptional = Optional.ofNullable(null);

        // ifPresent()
        name.ifPresent(value ->
                System.out.println(value)
        );
        nullOptional.ifPresent((a) -> {
            System.out.println("Null Found");
            System.out.println(a);
        });


        // map()
        System.out.println();
        Optional<String> upperCase = nullOptional.map(String::toUpperCase);
        System.out.println(upperCase.orElse("default"));


        // filter()
//        Optional<String> temp = name.filter(n -> n.startsWith("J"));
//        temp.ifPresent(System.out::println);

        name.filter(n -> n.startsWith("J"))
                .ifPresent(System.out::println);

        System.out.println();

        // Combined Operation
        name.filter(n -> n.startsWith("J"))
                .map(String::toUpperCase)
                .ifPresent(System.out::println);
    }
}
