package Map;

import java.util.Hashtable;

public class HashTableDemo {

    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();

        // HashTable is synchronized(Thread-safe)
        // no null key and value
        // Legacy class (From Java 1.0) and currently not in used
        // Replaced by ConcurrentHashMap
        // Because of being synchronized, It is slower than HashMap
        // Keep the data in decreasing sorted order
        // only Linked List is used in case of collision

        hashtable.put(1, "Apple");
        hashtable.put(2, "Banana");
        hashtable.put(4, "Fig");
        hashtable.put(3, "Orange");
        hashtable.put(5, "Kiwi");
        System.out.println(hashtable);

//        hashtable.put(null, "Value");  // Throw exception
//        hashtable.put(6, null);  // Throw exception
    }
}
