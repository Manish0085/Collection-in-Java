public class DaemonThreadDemo extends Thread{

    @Override
    public void run() {
        while (true){
            System.out.println("Hello World");
        }

    }

    public static void main(String[] args) {
        DaemonThreadDemo d1 = new DaemonThreadDemo();
        d1.setDaemon(true);
        DaemonThreadDemo d2 = new DaemonThreadDemo();
        d2.start();
        d1.start();
        System.out.println("Main Done");
    }
}

/*
    JVM doesn't wait to complete the daemon thread as the user threads complete their tasks JVM will get shut down
 */