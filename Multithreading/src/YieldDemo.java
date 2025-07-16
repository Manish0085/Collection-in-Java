public class YieldDemo extends Thread{


    public YieldDemo(String name){
        super(name);
    }


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running...");
            Thread.yield(); // gives the instruction to the schedular or JVM that you can give the chance to other thread also
        }
    }

    public static void main(String[] args) {
        YieldDemo t1 = new YieldDemo("t1");
        YieldDemo t2 = new YieldDemo("t2");
        t1.start();
        t2.start();
    }
}
