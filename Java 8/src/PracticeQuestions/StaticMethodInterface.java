package PracticeQuestions;

/*

       Can an interface have static methods in Java 8?
       -----------------------------------------------

            Yes, Interfaces can have static methods in Java8.
            These methods belong to the interface itself, not to the implementing class.
            They must be called using interface name.

       Important:
       ----------
            --> Static methods belong to the class or interface itself, not to instances.
            --> So, even if a class defines a static method with the same signature as in
                an interface, it's just method hiding, not overriding.
 */


interface MathUtils {
    static int operation(int a, int b){
        return a+b;
    }
}

class Subtract implements MathUtils{

    // This does NOT override the interface method
    static int operation(int a, int b){
        return a-b;
    }
}

public class StaticMethodInterface {

    public static void main(String[] args) {
        int add = MathUtils.operation(4, 6); // belong to "MathUtils" interface
        int subtract = Subtract.operation(4, 6); // belong to "Subtract" class.
        System.out.println("Sum: "+add);
        System.out.println("Subtract: "+subtract);
    }

}