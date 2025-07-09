package LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheDemo<K, V> extends LinkedHashMap<K, V> {


    private int capacity;

    public LRUCacheDemo(int capacity){
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo<String, Integer> students = new LRUCacheDemo<>(3);
        students.put("Alice", 99);
        students.put("Bob", 89);
        students.put("Ram", 91);
        students.get("Alice");
        students.put("Vipul", 89);

//        students.get("Ram");
        System.out.println(students);
    }
}
