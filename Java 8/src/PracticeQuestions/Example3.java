package PracticeQuestions;


/*
    What is a functional interface? Give an example from java.util.function package.
    Write a functional interface named MathOperation with one method operate(int a, int b).

    Definition: A functional Interface is the interface which only single abstract method, but it can have any no. of static and default methods.
    Example from java.util.function package is Predicate.
            Predicate is the abstract method from the java.util.function package which has the single abstract method called "test()" method.
 */

interface MathOperation {
    int operate(int a, int b);
}
public class Example3 {


    public static void main(String[] args) {
        MathOperation sum = (a, b) -> a+b;
        MathOperation subtract = (a, b) -> a-b;
        MathOperation multiply = (a, b) -> a*b;
        MathOperation divide = (a, b) -> a/b;


        int a = 5;
        int b = 23;
        System.out.println("Addition of "+ a + " and "+b+ ": "+sum.operate(a, b));
        System.out.println("Subtraction of "+ a + " and "+b+ ": "+subtract.operate(a, b));
        System.out.println("Multiplication of "+ a + " and "+b+ ": "+multiply.operate(a, b));
        System.out.println("Division of "+ a + " and "+b+ ": "+divide.operate(a, b));
    }
}



