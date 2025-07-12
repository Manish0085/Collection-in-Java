package Map;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class EnumMapDemo {

    public static void main(String[] args) {
        // array of size same as enum
        // [_, _, _, _, _, _, _]
        // no hashing required
        // ordinal/index is used
        // Faster than HashMap because hashing is not required
        // it is also Memory efficient
        // also maintain the insertion order according to the enum types order
        Map<Day, String> map = new EnumMap<>(Day.class);

        map.put(Day.Tuesday, "Sunny");
        map.put(Day.Friday, "Rainy");
        map.put(Day.Saturday, "Wind");
        map.put(Day.Monday, "Forcast");
        System.out.println(map);
        map.put(Day.Tuesday, "Rainy");
        System.out.println(map);
        System.out.println("Ordinal/index of Wednesday: "+Day.Wednesday.ordinal());
    }
}

enum Day {
    Monday, Tuesday, Wednesday, Thrusday, Friday, Saturday, Sunday
}
