package PracticeQuestions;

/*
    Convert the following anonymous class to a lambda:

        Runnable r = new Runnable() {
            public void run() {
                System.out.println("Hello");
        }
    };

 */

public class Example2 {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Defining the thread Using Lambda Expressing by Runnable interface");
        runnable.run();
    }
}
