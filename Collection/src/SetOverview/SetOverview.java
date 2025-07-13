package SetOverview;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetOverview {

    public static void main(String[] args) {
         // Set is a Collection that cannot contain the duplicate elements
        // faster Operation O(1)
        // Map --> HashMap, LinkedHashMap, TreeMap, EnumMap
        // Set --> HashSet, LinkedHashSet, TreeSet, EnumSet

        // In case of HashSet the insertion order of element is not maintain
        Set<Integer> set1 = new HashSet<>();
        set1.add(12);
        set1.add(25);
        set1.add(5);
        set1.add(9);
        set1.add(5);

        System.out.println("Using HashSet: "+set1);

        // LinkedHashSe preserve the insertion order of the elements
        Set<Integer> set2 = new LinkedHashSet<>();
        set2.add(12);
        set2.add(25);
        set2.add(5);
        set2.add(9);
        set2.add(5);

        System.out.println("Using LinkedHashSet, the order of insertion will be preserve: "+set2);



        // TreeSet stores the data in sorted form
        Set<Integer> set3 = new TreeSet<>();
        set3.add(12);
        set3.add(25);
        set3.add(5);
        set3.add(9);
        set3.add(5);

        System.out.println("Using TreeSet, data is stored in sorted order: "+set3);
    }
}
