import java.lang.reflect.Field;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        ArrayList<Integer> list = new ArrayList<>();
        list.add(40);
        list.add(7);
        list.add(8);
        list.add(45);
        list.add(99);
        list.add(62);

        System.out.println(list.get(5));
        System.out.println(list.size());

        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData= (Object[]) field.get(list);

        System.out.println("ArrayList Initial Capacity :- "+ elementData.length);

    }
}