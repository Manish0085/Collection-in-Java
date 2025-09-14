# Immutable Class in Java – Example

## Problem
When we want to create an **immutable class** (used as simple data transfer objects like POJOs),  
we usually end up writing a lot of **boilerplate code** such as:

- `final` fields
- Constructor
- Getters
- `equals()` and `hashCode()`
- `toString()`

Example:

```java
import java.util.Objects;

public final class User1 {

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
}
```

# Record in Java

## ✅ Syntax of a Record:

```
   accessSpecifier record RecordName(Type1 field1, Type2 field2, ...) {
   }
```

### 📝 Key Points about Records:

1. The `record` keyword is similar to declaring a `final class`.
    - Records cannot be extended (implicitly final).

2. All records extend `java.lang.Record` implicitly.
    - This allows the Java framework to identify whether a class is a record using:
   ```
      getSuperClass() == java.lang.Record.class
   ```

3. Since Java does not support multiple inheritance,
   extending any other class is not allowed for records.

### 🎯 Record Components:

- The fields declared in the record header are called *record components*.- These components are implicitly:
- `private final`
- Initialized via the canonical constructor.
- We cannot define additional instance fields outside the record header.
- However, static fields are allowed (since they don’t belong to instances).
```
    public record User2(String name, int age) {

    // String lastname; // not allowed

    public static String lastname;
```

### ⚙️ Constructors in Records:

- A **canonical constructor** (one that takes all record components as parameters)
  is generated automatically.
- You may override the canonical constructor if needed.
- You can also define additional constructors with different parameters,
  but they must call the canonical constructor (directly or indirectly).
  Why? → To ensure all record components are properly initialized.

### ✅ Benefit:

- Records are designed as **transparent, immutable data carriers**.
- They reduce boilerplate code (no need to write getters, equals, hashCode, toString).


### Nested Record:

- So in records, we can also create nested records, which can be private/protected, public
  like nested classes.
- Only difference is, in record static nested record are possible and non-static nested records
  are not possible.
     
```
    public record NestedRecordUser(String name, int age) {

        // by default iit is static
        record NestedAddressRecord(){

            public void display(){
                System.out.println("Hello inside  nested static record");
            }
        }
    }

```
