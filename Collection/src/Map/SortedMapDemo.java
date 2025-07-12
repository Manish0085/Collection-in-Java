package Map;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo  {

    public static void main(String[] args) {
        SortedMap<String, Integer> sortedMap1 = new TreeMap<>((a, b) -> b.compareTo(a));
        sortedMap1.put("Shubham", 91);
        sortedMap1.put("Inkesh", 78);
        sortedMap1.put("Akshit", 99);
        sortedMap1.put("Mohit", 35);
//        sortedMap1.put(null, 35);   // give exception because it needs data to sort null can't compared with anything
        System.out.println(sortedMap1);

        System.out.println(sortedMap1.headMap("Shubham")); // exclude
        System.out.println(sortedMap1.tailMap("Mohit"));
        System.out.println(sortedMap1.firstKey());
        System.out.println(sortedMap1.lastKey());

        // sorted based on keys
        Map<Integer, String> sortedMap2 = new TreeMap<>();
        sortedMap2.put(91, "Shubham");
        sortedMap2.put(78, "Inkesh");
        sortedMap2.put(99, "Akshit");
        sortedMap2.put(35,"Mohit");
        System.out.println(sortedMap2);

//        System.out.println(sortedMap2.);
//        System.out.println(sortedMap2.tailMap("Inkesh"));
//        System.out.println(sortedMap2.firstKey());
//        System.out.println(sortedMap2.lastKey());
    }
}
