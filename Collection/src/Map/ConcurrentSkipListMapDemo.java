package Map;

import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapDemo {

    public static void main(String[] args) {

        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>((a, b) -> b-a);

        map.put(5, "Apple");
        map.put(1, "PineApple");
        map.put(9, "Date");
        map.put(3, "Kiwi");
        map.put(2, "Banana");
        map.put(8, "Papaya");
        map.put(6, "Orange");

        System.out.println(map);
        concurrencyDemo();
    }

    public static void  concurrencyDemo(){
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, "Thread-1");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                map.put(i, "Thread-2");
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Size of ConcurrentSkipListMap after working on it by two threads: "+map.size());
    }
}
