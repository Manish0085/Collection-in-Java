package PracticeQuestions;

@FunctionalInterface
interface Square {
    int calculate(int x);
}
public class Example1 {

    // Write a lambda expression to calculate the square of a number.
    public static void main(String[] args) {
        Square res = num -> num = num * num;
        System.out.println(res.calculate(5));
    }
}
