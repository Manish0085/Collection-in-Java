package Map;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo2 {


    public static void main(String[] args) {
        WeakHashMap<String, Photo> imageCache = new WeakHashMap<>();
        imageCache.put(new String("img1"), new Photo("Photo 1"));
        imageCache.put(new String("img2"), new Photo("Photo 2"));
        imageCache.put(new String("img3"), new Photo("Photo 3"));
        System.out.println(imageCache);
        System.gc();
        simulateApplicationRunning();

        System.out.println("Image Cache after simulating(some entries may be cleared): "+imageCache);
        putDataInCache();
    }


    public static void putDataInCache(){
        WeakHashMap<String, Photo> photoCache = new WeakHashMap<>();

        loadCache(photoCache);
        System.out.println(photoCache);
        System.gc();
        simulateApplicationRunning();
        System.out.println("Photo cache after simulating the running application(Some entries may be cleared): "+photoCache);
    }


    // if we want to keep variable instead of passing the weakObjects as key
    private static void loadCache(Map<String, Photo> photoCache){
        String key1 = new String("pic1");
        String key2 = new String("pic2");
        String key3 = new String("pic3");
        photoCache.put(key1, new Photo("Photo 1"));
        photoCache.put(key2, new Photo("Photo 2"));
        photoCache.put(key3, new Photo("Photo 3"));
    }

    private static void simulateApplicationRunning(){
        try {
            System.out.println("Simulating the running application...");
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Photo {
    private String name;


    public Photo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "name='" + name + '\'' +
                '}';
    }
}
