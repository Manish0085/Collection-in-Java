package Synchronization;

public class Counter {

    private int count = 0;

    synchronized public void increment(){
        count++;  // Mutual Exclusion
    }

//    public void increment(){
//        count++;
//    }  // Race Condition

    public int getCount(){
        return count;
    }
}
