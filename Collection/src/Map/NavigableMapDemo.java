package Map;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapDemo {

    public static void main(String[] args) {

        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(1, "One");
        navigableMap.put(4, "four");
        navigableMap.put(6, "six");
        navigableMap.put(9, "Nine");
        navigableMap.put(3, "three");
        navigableMap.put(2, "two");
        navigableMap.put(10, "ten");
        System.out.println(navigableMap);

        System.out.println(navigableMap.ceilingKey(5));  // return 6
        System.out.println(navigableMap.higherEntry(6)); // return 9, just high to the provided key
        System.out.println(navigableMap.lowerEntry(6));  // return 4
        System.out.println(navigableMap.floorEntry(7));  // return 6
        System.out.println(navigableMap.descendingMap());
     }

}
