import java.util.Objects;

public final class User1 {

    /*
        Problem:
        --------

        To Create an Immutable class, which is required as simply data transfer
        (like a pojo) we need to write below code
     */

    private final String name;
    private final int age;

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User1 user = (User1) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /*
        One thing is that there is lot of boiler plate code just for basic Immutable pojo class
        But We have lombok
            - automatic generation of getters and setters via @Getter and @Setter
            - automatic generation of equals and hashcode method via @EqualsAndHashCode
            - automatic generation of constructors via @AllArgsConstructor
            - automatic generation of toString method via @ToString
            - automatic generation of Immutable class via @Value
        Then why Record?
        ----------------

            - It helps us to create immutable class in the short way.
            - it mostly designed to reduce boiler code for data caring classes (Like POJO).

     */
}
