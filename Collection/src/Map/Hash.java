package Map;

public class Hash {

    public static void main(String[] args) {
        System.out.println(simapleHash("ok"));
        System.out.println(simapleHash("OK"));

        // String ABC and CBA will give the same output even though they are different
        // this is called collision
        // Finite no. of output
        System.out.println(simapleHash("ABC"));
        System.out.println(simapleHash("CBA"));
    }

    public static int simapleHash(String key){
        int sum = 0;
        for (char c: key.toCharArray()){
            sum += (int) c;
        }
        return sum % 10;
    }
}
