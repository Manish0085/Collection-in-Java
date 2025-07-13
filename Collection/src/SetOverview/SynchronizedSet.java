package SetOverview;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class SynchronizedSet {

    public static void main(String[] args) {

        // for thread safety
        // recommended way
        ConcurrentSkipListSet<Integer> conSkipListMap = new ConcurrentSkipListSet<>();

        // Not a recommended way
        Set<Integer> syncSet = Collections.synchronizedSet(new TreeSet<>());

        synchronized (syncSet){
            for (Integer i: syncSet){
                // safe Iteration
                System.out.println(i);
            }
        }

    }
    public void immutableSetDemo(){
        Set<Integer> set = Set.of(4, 8, 9, 25, 0, 32, 1);
        System.out.println(set);
        Set<Integer> objects = Collections.unmodifiableSet(set);
    }
}
