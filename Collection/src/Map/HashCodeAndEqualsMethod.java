package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class HashCodeAndEqualsMethod {


    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("Alice", 1);
        Person p2 = new Person("Bob", 2);
        Person p3 = new Person("Alice", 1);


        map.put(p1, "Engineer"); // hashCode1 --> index1
        map.put(p2, "Designer"); // hashCode2 --> index2
        map.put(p3, "Manager"); // hashCode3 --> index3


        System.out.println("HashMap size: "+map.size());
        System.out.println("Value for p1: "+ map.get(p1));
        System.out.println("Value for p3: "+ map.get(p3));
        System.out.println(p1);


        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Shubham", 90); // hashCode1 --> index1
        map1.put("Neha", 92); // hashCode2 --> index2
        map1.put("Shubham", 99); // hashCode1 --> index1 --> equals() --> replace
    }

}

class Person {


    private String name;

    private int id;

    public Person(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


}