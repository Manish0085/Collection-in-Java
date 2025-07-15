public class ThreadMethod extends Thread{

    @Override
    public void run() {
        System.out.println("Thread is running...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadMethod t1 = new ThreadMethod();
        t1.start();
        System.out.println("Hello");
        System.out.println(t1.getState());
        t1.join();
        System.out.println(t1.getState());
        System.out.println("World");
    }
}
