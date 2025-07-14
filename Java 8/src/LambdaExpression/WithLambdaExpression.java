package LambdaExpression;

import javax.swing.plaf.TableHeaderUI;

public class WithLambdaExpression {


    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Using Lambda Expression");
        });
        // here we used the lambda expression to define the thread, and it reduces the code too
        // also looking more readable
        // Mainly the Lambda Expression is used to give the implementation of the functional interface
         /*
            FUNCTIONAL INTERFACE :
                    A Functional interface is an interface which has exactly one abstract method
                    and can have any number of Default and Static method.
                    "@FunctionalInterface" Annotation is used to represent the functional interface
          */
        // Runnable is a functional interface which has only one abstract method "run()".



        // Using Lambda Expression
        MathematicsOperation sum = (int a, int b) -> {
            return a + b;
        };

        // FunctionalInterface obj = lambdaExpression
        MathematicsOperation subtract = (int a, int b) -> a - b;
        MathematicsOperation product = (a, b) -> a * b;
        MathematicsOperation division = (a, b) -> a / b;

        System.out.println(sum.operation(4, 0));
        System.out.println(subtract.operation(4, 1));
        System.out.println(product.operation(4, 0));

        // Reference of FunctionalInterface can hold Lambda Expression and this is called Functional Programming
    }






}

interface MathematicsOperation{
    int operation(int a, int b);
}


