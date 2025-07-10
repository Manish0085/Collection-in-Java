package Map;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {

    public static void main(String[] args) {
        demo1();
        demo2();
    }


    private static void demo1(){
        String key1 = new String("key");
        String key2 = new String("key");
        // In memory , two object will be creating of String class because both are creating using the new keyword even though both objects have the same value.


        // class hashCode/Object hashCode and equals()
        Map<String, Integer> map = new HashMap<>();
        map.put(key1, 1);  // key, 1
        map.put(key2, 2);  // key, 2
        System.out.println(key1.equals(key2));
        System.out.println(map);
    }


    private static void demo2(){
        String key1 = new String("key");
        String key2 = new String("key");
        // In memory , two object will be creating of String class because both are creating using the new keyword even though both objects have the same value.


        System.out.println(key1.hashCode());
        System.out.println(key2.hashCode());
        System.out.println(System.identityHashCode(key1));
        System.out.println(System.identityHashCode(key2));
        // Identity HashCode(Object hashCode which is associated with memory) and == to check reference
        Map<String, Integer> map = new IdentityHashMap<>();
        map.put(key1, 1);
        map.put(key2, 2);
        System.out.println(key1.equals(key2));
        System.out.println(map);
    }
}
