package CopyOnWriteArrayList;

import javax.swing.plaf.TableHeaderUI;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadDemo {

    public static void threadDemoWithArrayList(){
        List<String> list = new ArrayList<>();
        list.add("Item1");
        list.add("Item2");
        list.add("Item3");
        list.add("Item4");
        list.add("Item5");

        Thread readerThread = new Thread(() -> {
            try {
                while (true){
                    // iterate throw list
                    for (String item: list){
                        System.out.println(item);
                        Thread.sleep(100);
                    }
                }
            }
            catch (Exception e){
                System.out.println("Exception is occurred while reading the thread by the readerThread"+e);
            }
        });

        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(500); // delay to allow reading to start
                list.add("item6");
                System.out.println("Added Item6 to the list.");

                Thread.sleep(500);
                list.remove("item1");
                System.out.println("Item1 is removed from the list.");
            } catch (Exception e){
                System.out.println("Exception is occurred while writing the thread by the writerThread"+e);
            }
        });

        readerThread.start();
        writerThread.start();
    }


    public static void threadDemoWithCopyOnWriteArrayList(){

        List<String> list = new CopyOnWriteArrayList<>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        list.add("item4");
        list.add("item5");

        Thread readerThread = new Thread(() -> {
            try {

                while (true){
                    for (String item: list){
                        Thread.sleep(100);
                        System.out.println(item);
                    }
                }
            }catch (Exception e){
                System.out.println("Exception while readerThread: "+e);
            }
        });

        Thread writerThread = new Thread(() -> {
            try {

                Thread.sleep(500);
                list.add("item6");
                System.out.println("Item6 is added to the list");

                Thread.sleep(500);
                list.remove("item4");
                System.out.println("item4 is removed from list");
            } catch (Exception e){
                System.out.println("Exception while writerThread: "+e);
            }
        });

        readerThread.start();
        writerThread.start();
    }


    public static void main(String[] args) {
        threadDemoWithCopyOnWriteArrayList();

        System.out.println("\n\n");
        threadDemoWithArrayList();
    }
}
