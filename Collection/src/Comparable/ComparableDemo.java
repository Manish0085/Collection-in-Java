package Comparable;


import java.util.ArrayList;
import java.util.List;

public class ComparableDemo  {


    public static void withoutUsingComparable(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Arjun"));
        list.add(new Employee(85, "Perem"));
        list.add(new Employee(33, "Bhuj"));
        list.add(new Employee(93, "Vinod"));
        list.add(new Employee(43, "Akshit"));
        list.sort(null);  // throw exception because it needs custom sorting
        System.out.println(list);
    }



    public static void main(String[] args) {
//        withComparable();

        withoutUsingComparable();
    }
}


