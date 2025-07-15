public class SetPriorityDemo extends Thread{


    public SetPriorityDemo(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority() + " - count: " + i);
            try {
                Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SetPriorityDemo low = new SetPriorityDemo("Low Priority Thread");
        SetPriorityDemo medium = new SetPriorityDemo("Medium Priority Thread");
        SetPriorityDemo high = new SetPriorityDemo("High Priority Thread");
        low.setPriority(Thread.MIN_PRIORITY);
        medium.setPriority(Thread.NORM_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);
        low.start();
        medium.start();
        high.start();
    }
}
