public class InterruptDemo extends Thread{


    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Running...");
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted: " + e);
        }

    }


    public static void main(String[] args) {

        InterruptDemo t1 = new InterruptDemo();
        t1 .start();
        t1.interrupt();
    }
}
