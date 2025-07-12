package Concurrency;

import Map.Hash;
import Map.HashTableDemo;

import java.util.HashMap;
import java.util.Hashtable;

public class ConcurrencyDemo {

    public static void main(String[] args) {
        concurrencyDemoUsingHashMap();
        concurrencyDemoUsingHashtable();
    }

    public static void concurrencyDemoUsingHashMap(){
        HashMap<Integer, String> map = new HashMap<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, "Thread1");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                map.put(i, "Thread2");
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Size of hashMap after working thread1 and thread2 on it: "+map.size());
        // Ideally the size should be 2000
        // but it won't be, It might be for very rear case
        // it is because HashMap is asynchronized(not thread-safe)
    }


    public static void concurrencyDemoUsingHashtable(){
        Hashtable<Integer, String> map = new Hashtable<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, "Thread1");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                map.put(i, "Thread2");
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Size of hashtable after working thread1 and thread2 on it: "+map.size());
        // the size will be 2000 in this case
        // because now we are using hashtable instead of hashMap
        // and it is synchronized(thread-safe)
    }
}
