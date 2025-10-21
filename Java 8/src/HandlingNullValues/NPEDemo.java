package HandlingNullValues;

import java.util.Optional;

public class NPEDemo {

    public static void main(String[] args) {
//        String name = null;
        String name = "Java";
        if (name != null) {
            System.out.println("Length of " + name + ": " + name.length());
        } else {
            System.out.println("No name value");
        }

        // Optional --> Introduced in Java8
        Optional<String> optionalString = Optional.of("Java");
        System.out.println(optionalString);

        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        Optional<String> mayBe = Optional.ofNullable(null);
        System.out.println(mayBe);

        // Checking values
        System.out.println(optionalString.isPresent());
        System.out.println(mayBe.isPresent());

        System.out.println("\n"+optionalString.isEmpty());
        System.out.println(mayBe.isEmpty());

        // get()
        System.out.println("\n"+optionalString.get());
//        System.out.println(mayBe.get());


        // Type Safe ways to access value
        // orElse("Default Value")
        System.out.println("\n"+optionalString.orElse("default"));
        System.out.println(mayBe.orElse("default"));
        System.out.println(mayBe.orElse(null));
        String temp = mayBe.orElse("default");
        System.out.println(temp);

        // orElseGet(<supplier>)
        System.out.println();
        String result1 = mayBe.orElseGet(() -> {
            System.out.println("Generating default values...");
            return "defult";
        });
        System.out.println(result1);

        String result2 = optionalString.orElseGet(() -> {
            System.out.println("Generating default values...");
            return "default";
        });
        System.out.println(result2);


        // orElseThrow()
        System.out.println();
        String result3 = optionalString.orElseThrow(() ->
                new RuntimeException("Not Found")
        );
        System.out.println(result3);

        String result4 = mayBe.orElseThrow(() ->
            new RuntimeException("Not Found")
        );
        System.out.println(result4);

    }
}
