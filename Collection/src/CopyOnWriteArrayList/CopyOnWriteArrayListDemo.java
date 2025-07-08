package CopyOnWriteArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void demoWithArrayList(){



        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Bread");
        System.out.println("Initial Shopping List:- "+ shoppingList);

        for (String item: shoppingList){
            System.out.println(item);
            // try to modify while reading
            if (item.equals("Eggs")){
                shoppingList.add("Butter"); // Throws an exception while updating because Java expect a stable photo
                System.out.println("Added butter while reading");
            }
        }

        System.out.println("Updated Shopping list:- "+shoppingList);
     }


    public static void demoWithCopyOnWriteArrayList(){

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        // "Copy on Write" means whenever a write operation
        // like adding or removing an element
        // instead of directly modifying the existing list
        // a new copy of the list is created, and the modification is applied to that copy
        // this ensures that other threads reading the list while it is being modified are unaffected

        // Read Operation:- Fast and direct, Since they happen on a stable list without interference from modification.
        // Write Operation:- A new copy of the list is created for every modification.
        //                   The reference to the list is then updated so that subsequent reads use this new list


        list.add("Milk");
        list.add("Eggs");
        list.add("Bread");
        list.add("Sugar");
        list.add("Tea");

        for (String item: list){
            System.out.println(item);
            if (item.equals("Bread")){
                list.add("Butter");
                System.out.println("Added butter while reading");
            }
        }
        //  old = new
        System.out.println("Updated list :- "+list);
    }


    public static void main(String[] args) {
        demoWithCopyOnWriteArrayList();
        demoWithArrayList();
    }
}
