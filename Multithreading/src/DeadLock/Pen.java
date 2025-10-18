package DeadLock;

public class Pen {

    public synchronized void writeWithPenAndPage(Paper paper){
        System.out.println(Thread.currentThread().getName() + " is using pen "+ this+ " and trying to use paper");
        paper.finishedWriting();

    }



    public synchronized void finishedWriting(){
        System.out.println(Thread.currentThread().getName() + " finished using pen "+ this);
    }
}

class Paper{


    public synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName() + " is using paper "+ this+ " and trying paper");
        pen.finishedWriting();

    }

    public synchronized void finishedWriting(){
        System.out.println(Thread.currentThread().getName() + " finished using paper "+ this);
    }
}
