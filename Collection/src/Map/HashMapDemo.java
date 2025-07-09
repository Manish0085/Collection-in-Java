package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Akshit");
        map.put(2, "Neha");
        map.put(3, "Shubham");
        map.put(2, "Meghul");
//        map.put(null, "Vipul");
//        map.put(null, "Manish");

        System.out.println(map);

        String student1 = map.get(3);
        System.out.println(student1);

        String student2 = map.get(69); // null
        System.out.println(student2);

        System.out.println(map.containsKey(2));
        System.out.println(map.containsValue("Shubham")+"\n");


        // Iteration in map
//        Set<Integer> keys = map.keySet();
//        for (int key: keys){
//            System.out.println(map.get(key));
//        }


        for (int key: map.keySet()){
            System.out.println(map.get(key));
        }


        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry: entries){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        for (Map.Entry<Integer, String> entry: entries){
            entry.setValue(entry.getValue().toUpperCase());
        }
        System.out.println(map);


        for(Map.Entry<Integer, String> entry: entries){
            entry.setValue(entry.getValue().toLowerCase());
        }
        System.out.println(map);

        System.out.println(map.remove(3));
        System.out.println(map.remove(3, "shubham"));
        System.out.println(map.remove(1, "a kshit"));
    }
}
