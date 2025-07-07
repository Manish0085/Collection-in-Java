package Comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Bob", 5.5));
        students.add(new Student("Charlie", 8.1));
        students.add(new Student("Alice", 5.5));
        students.add(new Student("Rohan", 5.9));

        // this will sort in ascending order based on the gpa
//        Comparator<Student> comparing = Comparator.comparing(Student::getGpa);

        // this will sort in descending order based on gpa
        Comparator<Student> studentComparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
        students.sort(studentComparator);
        for (Student student: students)
            System.out.println(student.getName() +" "+ student.getGpa());


//        students.sort(null); // Exception
        students.sort((a, b) -> {
            if (b.getGpa() - a.getGpa() > 0)
                return 1;
            else if (b.getGpa() - a.getGpa() < 0)
                return -1;
            else
                return b.getName().compareTo(a.getName());
        });

        System.out.println(students);
    }
}
