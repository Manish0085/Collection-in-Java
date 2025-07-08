package Vector;

import javax.swing.plaf.TableHeaderUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class VectorThreadSafetyDemo {

    public static void testArrayListThreadSafety(){
        ArrayList<Integer> list = new ArrayList<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        t1.start();
        t2.start();

        try {

            t1.join();
            t2.join();

        } catch (Exception e){
            e.printStackTrace();
        }


        //  Ideally the output should be 2000 asd we run the loop 2000 times on the single list by two threads
        // but the output won't be because ArrayList is Synchronized (not thread-safe)
        System.out.println("Size of the List after performing the operation on the list by two threads :- "+list.size());
    }


    public static void testVectorThreadSafety(){

        Vector<Integer> vector = new Vector<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                vector.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                vector.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("Size of the vector after performing the operation on the vector by two threads :- "+vector.size());
    }

    public static void main(String[] args) {
        testArrayListThreadSafety();
        testVectorThreadSafety();
    }
}
