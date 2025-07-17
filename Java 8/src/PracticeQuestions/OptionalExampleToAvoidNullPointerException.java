package PracticeQuestions;

import java.util.Optional;

public class OptionalExampleToAvoidNullPointerException {


    public static void main(String[] args) {

        String str = getName();

        // wrap in optional
        Optional<String> name = Optional.of(str);

        String result = name.orElse("Default Value");
        System.out.println("Name: "+result);
    }


    public static String getName(){
        // return null to simulate missing value
        return null;
    }
}
