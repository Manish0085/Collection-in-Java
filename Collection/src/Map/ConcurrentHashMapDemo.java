package Map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
//        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        // In Java 7, It works with the help of segment based locking
        // which means map is divided into segments, by default map is divided into 16 segments
        // called small hashMaps
        // only the segment being return to or read from is locked
        // read: do not require locking unless there is a write operation happening on the same segment
        // write: lock required


        // Java 8 ---> No segmentation
        //        ---> here Compare-And-Swap approach is used
        //        ---> no locking except resizing or collision happens

        // Compare-And-Swap approach (CAS)
        // Thread-A ---> last saw ---> x = 42;
        // Thread-A ---> work ---> x to 50
        // if x is still 42 then change it to 50 else don't change and retry


        map.put("Two", 2);
        map.put("Nine", 9);
        map.put("One", 1);
        map.put("Three", 3);
        map.put("Eight", 8);
        System.out.println(map);

    }
}
