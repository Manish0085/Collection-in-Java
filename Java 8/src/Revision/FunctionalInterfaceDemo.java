package Revision;

@FunctionalInterface
interface  BookAction {
    void perform();

//    void performAny();
}

@FunctionalInterface
interface Operation {
    int add(int a, int b);
}


public class FunctionalInterfaceDemo {

    public static void main(String[] args) {

//        STEP: 1
        BookAction action1 = new BookAction() {
            @Override
            public void perform() {
                System.out.println("Action Performed");
            }
        };
        action1.perform();

//        STEP: 1
        BookAction action2 = () -> {
            System.out.println("Action Performed");
        };
        action2.perform();


        BookAction action3 = () -> System.out.println("Action Performed");
        action3.perform();

        Operation operation = (a, b) -> {
            return a + b;
        };

        System.out.println(operation.add(55, 9));

        // Runnable Interface
        Thread t1 = new Thread( () ->
                System.out.println("NEW THREAD")
        );

        t1.start();
    }
}
