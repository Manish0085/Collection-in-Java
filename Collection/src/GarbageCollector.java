import java.lang.ref.WeakReference;

public class GarbageCollector {

    public static void main(String[] args) {
        Phone phone = new Phone("Apple", "16 Pro Max");  // Strong reference
        System.out.println(phone);
        phone = null; // it is not pointing to any memory location now
        // no object or reference var is point to "new Phone("Apple", "16 Pro Max");".
        // now JVM comes and see that there is no object corresponding to "new Phone("Apple", "16 Pro Max");" memory.
        // Hence JVM will destroy by calling the static gc() method of the System class.
        System.out.println(phone);
        demoOfWeakReference();
    }

    public static void demoOfWeakReference(){
        WeakReference<Phone> weakReference = new WeakReference<>(new Phone("Nokia", "105"));
        System.out.println(weakReference.get());
        System.gc();  // calling Garbage Collector explicitly
        try {
            Thread.sleep(10000);
        }
        catch (Exception ignored){
        }
        System.out.println(weakReference.get());
    }
}


class Phone{
    private String brand;

    private String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }


    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
