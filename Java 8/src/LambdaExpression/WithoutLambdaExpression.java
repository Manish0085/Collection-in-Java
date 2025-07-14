package LambdaExpression;

public class WithoutLambdaExpression {


    public static void main(String[] args) {

        Thread t1 = new Thread(new Task());
        // Here instead of passing Object of Task class which implements the Runnable interface
        // and creating the class of Runnable type to create the Thread
        // we can write the lambda expression  to define the thread
        // which allows as to make the code more readable, minimal and concise

    }
}

class Task implements Runnable{

    @Override
    public void run() {
        System.out.println("Without using Lambda expression...");
    }
}


class SumOperation implements MathOperation{

    @Override
    public int operation(int a, int b) {
        return a + b;
    }
}

class SubtractOperation implements MathOperation{

    @Override
    public int operation(int a, int b) {
        return a - b;
    }
}

class MultiplyOperation implements MathOperation {

    @Override
    public int operation(int a, int b) {
        return a * b;
    }
}


interface MathOperation {

    int operation(int a, int b);
}
