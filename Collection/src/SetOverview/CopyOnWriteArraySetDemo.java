package SetOverview;

import java.beans.Introspector;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetDemo {

    static public void demo(){
        // thread safety
        // Copy-On-Write Mechanism
        // No duplicate Elements
        // Iterators Do not reflect the modification

        ConcurrentSkipListSet<Integer> conSkipListSet = new ConcurrentSkipListSet<>();
        CopyOnWriteArraySet<Integer> copySet = new CopyOnWriteArraySet<>();


        for (int i = 0; i <= 5; i++) {
            copySet.add(i);
            conSkipListSet.add(i);
        }

        System.out.println("Initial CopyOnWriteArraySet: "+copySet);
        System.out.println("Initial ConcurrentSkipListSet: "+conSkipListSet);

        System.out.println("\nIterating the CopyOnWriteArraySet: ");
        for (Integer num: copySet){
            System.out.println("Reading from CopyOnWriteArraySet: "+num);
            // Attempting to modify the set during iteration
            copySet.add(9);
            // as we are reading and modifying the set, but it won't set the modified content
            // because the CopyOnWriteArraySet first will create a copy of original set and make modification in the copied set(on a stable and separate photo of original set)
            // and then after completing the iteration, the modified set will become the original set
        }

        System.out.println(copySet);


        System.out.println("\nIterating the ConcurrentSkipListSet: ");
        for (Integer num: conSkipListSet){
            System.out.println("Reading from ConcurrentSkipListSet: "+num);
            // Attempting to modify the set during iteration
            conSkipListSet.add(9);
            // as we are reading and modifying the ConcurrentSkipListSet, it will also read the modified content
            // because the ConcurrentSkipListSet will make the changes in original set
            // this is why that we also call the ConcurrentSkipListSet as weakly consistent set
        }


    }


    public static void main(String[] args) {
        demo();
    }
}
