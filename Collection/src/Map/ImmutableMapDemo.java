package Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapDemo {

    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);
        System.out.println(map1);
        map1.put("B", 34);
        System.out.println(map1);

        // Immutable map
//        Map<String, Integer> map2 = Collections.unmodifiableMap(map1);
//        System.out.println(map2);
//        map2.put("B", 77);  // Throw an UnsupportedOperationException because the map is immutable
//        System.out.println(map2);
        demo();


    }

    public static void demo(){

        // only 10 entries can be given to this  Map.Of() method
        Map<String, Integer> immutableMap = Map.of("Shubham", 21, "Akshit", 23, "Raman", 93, "Bhuj", 79);
        System.out.println(immutableMap);
        immutableMap.put("Rajat", 41); // Throw UnsupportedOperationException
        System.out.println(immutableMap);

        // Other method and also immutable
        Map<String, Integer> map = Map.ofEntries(Map.entry("Rajat", 41), Map.entry("Saurabh", 93), Map.entry("Jatin", 74), Map.entry("Rahul", 6));
        System.out.println(map);
    }
}
