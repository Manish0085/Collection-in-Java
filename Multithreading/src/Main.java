public class Main {
    public static void main(String[] args) {

        CreatingThreadUsingThreadClass obj1 = new CreatingThreadUsingThreadClass();
        // NEW STATE of thread because upto here the thread is only created
        obj1.start(); // RUNNABLE STATE of thread

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
        }


        CreatingThreadUsingRunnableInterface obj2 = new CreatingThreadUsingRunnableInterface();
        Thread t1 = new Thread(obj2);
        t1.start();
    }
}