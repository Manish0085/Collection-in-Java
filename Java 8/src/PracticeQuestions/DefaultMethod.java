package PracticeQuestions;


/*
     What are default methods in interfaces? Provide an example.
     -----------------------------------------------------------

            A default method in an interface is a method with a body, introduced in Java8.
            it allows interface to evolve without breaking existing classes that implement them.


    Why ?
    -----
            Before Java8, interfaces could only have the abstract method. But adding a new mwthod to
            an interface would break all implementing classes.
            Default method solve this by providing a default method.

 */

interface Vehicle {

    void start();

    default void horn(){
        System.out.println("Beep Beep!");
    }
}

class Car implements Vehicle {


    @Override
    public void start() {
        System.out.println("Car started");
    }
}
public class DefaultMethod {

    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.horn();
    }

}
