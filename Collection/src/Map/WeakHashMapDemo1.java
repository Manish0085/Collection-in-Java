package Map;

import java.util.WeakHashMap;

public class WeakHashMapDemo1 {

    public static void main(String[] args) {
        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
        String key1 = new String("img1"); //strong reference
        String key2 = new String("img2"); // strong reference
        imageCache.put(key1, new Image("Image 1"));
        imageCache.put(key2, new Image("Image 2"));
        System.out.println(imageCache);
        simulateApplicationRunning();
        System.gc();
        System.out.println(imageCache);
        key1 = null; // because of being strong reference we have to do null key1 and key2 explicitly
        key2 = null;
        System.gc();
        simulateApplicationRunning();
        System.out.println("Cache after running (some entries may be cleared): " + imageCache);
    }

    private static void simulateApplicationRunning(){
        try {
            System.out.println("Simulating application running...");
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Image{
    private String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " Image { " +
                " name = '" + name + '\'' +
                '}';
    }
}
