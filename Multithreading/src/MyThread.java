public class MyThread extends Thread {



    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread(); // NEW STATE of the thread
        System.out.println(t1.getState());
        t1.start(); // RUNNABLE STATE of the thread
        System.out.println(t1.getState());
        // runnable state means either the thread is running or it is ready to run.
//        System.out.println(Thread.currentThread().getName() + " thread is in " + Thread.currentThread().getState() + " state.");
        Thread.sleep(1000);
        System.out.println(t1.getState());
        t1.join();
        // Here the main method will wait until the thread is executed its task
        System.out.println(t1.getState());
    }
}
