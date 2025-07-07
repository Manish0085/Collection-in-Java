package ArrayList;

import java.util.*;


class StringLengthComparator implements Comparator<String>{


    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}

class MyComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }

    // -ve returned then o1 must come first
    // +ve returned then o2 must come first
    // 0 returned then o1 and o2 are equal in ordering
}
public class SortAnArrayList {

    public static void sort(){

        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(1);
        list1.add(4);
        list1.add(8);
        list1.add(6);

//        Collections.sort(list1);
//        list1.sort(new MyComparator());
        list1.sort((a, b) -> b-a);


        List<String> words = Arrays.asList("Orange", "Banana", "Apple", "Date", "Fig");
//        words.sort(new StringLengthComparator());
        words.sort((a, b) -> b.length() - a.length());

        System.out.println(words);
        System.out.println(list1);
    }

    public static void main(String[] args) {
        sort();
    }
}
