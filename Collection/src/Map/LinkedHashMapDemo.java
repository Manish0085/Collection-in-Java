package Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();  // uses the doubly linked list to maintain the insertion order

        linkedHashMap.put("Orange", 10);
        linkedHashMap.put("Apple", 20);
        linkedHashMap.put("Banana", 30);
        linkedHashMap.put("Papaya", 40);


        for (Map.Entry<String, Integer> entry: linkedHashMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        // access order
        // By default access order is false which means the insertion order will maintain
        // but if we set the access order as true, the Least recently used(LRU) item will put on the top;
        LinkedHashMap<String, Integer> linkedHashMap1 = new LinkedHashMap<>(11, 0.75f, true);
        linkedHashMap1.put("Dog", 101);
        linkedHashMap1.put("Tiger", 102);
        linkedHashMap1.put("Lion", 103);
        linkedHashMap1.put("Cat", 104);
        linkedHashMap1.put("Cow", 105);

        for (Map.Entry<String, Integer> entry: linkedHashMap1.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        linkedHashMap1.get("Tiger"); // this item of linkedHashMap will put at the end because it is accessing repeatedly
        linkedHashMap1.get("Dog");
        for (Map.Entry<String, Integer> entry: linkedHashMap1.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Shubham", 90);
        hashMap.put("Alice", 91);
        hashMap.put("Bob", 73);
        
        
        LinkedHashMap<String, Integer> linkedHashMap2 = new LinkedHashMap<>(hashMap);
        Integer res1 = linkedHashMap2.getOrDefault("Shubham", 0); // value will be 90 because "Shubham" key is present in the map and the value corresponding to this value is 90.
        Integer res2 = linkedHashMap1.getOrDefault("Akshit", 0); // value will be 0 because the key "Akshit" is not present in the map hence the provided default value will be returned.
        linkedHashMap1.putIfAbsent("Bob", 79); // put the pair into the map only if the key is not present in the map.


    }
}
