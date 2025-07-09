package Map;

import java.util.HashMap;
import java.util.Objects;

public class HashCodeAndEqualsMethod2 {

    public static void main(String[] args) {
        HashMap<Student, String> map = new HashMap<>();

        Student s1 = new Student("Alice", 101);
        Student s2 = new Student("Bob", 102);
        Student s3 = new Student("Alice", 101);
        Student s4 = new Student("Charlie", 103);


        map.put(s1, "IT"); // hashCode1 --> index1
        map.put(s2, "ECE"); // hashCode2 --> index2
        map.put(s3, "EN"); // hashCode1 --> index1 --> equals() --> replace
        map.put(s4, "CSE"); // hashCode3 --> index3

        System.out.println("HashMap Size: "+map.size());
        System.out.println("Value for s1: "+map.get(s1));
        System.out.println("Value for s3: "+map.get(s3));
        System.out.println(s2);

        System.out.println(map);
    }
}


class Student {


    private String name;

    private int id;

    public Student(String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Student other = (Student) obj;
        return id == other.getId() && Objects.equals(name, other.getName());
    }

    @Override
    public String toString() {
        return "id: "+id+", name: "+ name;
    }

}