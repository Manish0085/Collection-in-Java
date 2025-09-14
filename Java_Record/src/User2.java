/*
        Syntax of record:
        -----------------

        accessSpecifier record yourRecordClassName(Type1 var1, Type2 var2, ...){
        }

        - record keyword is equivalent to "final class".
        - record access specifier rules are similar to normal class.
        - All record class by-default extends "java.lang.Record" class implicitly
            why?  because Java framework can only Identify "User2" is a record or not via superclass
            internally framework code does like this

                    getSuperClass() == java.lang.Record.class


        - That's why, extends are not allowed on Record (as in Java, we know that we cannot extend from more than 1 class )
        multiple inheritance is not supported by java.

        Record Components:
        ------------------

            - generally it generates "private final" field, generally called "record component
            - we cannot add more instance field.
            - All Instance fields must be defined in record header only called "Transparent Data carrier"
            - But you define static fields, as they don't belong to the individual instance. So each USer is Still immutable
            - Automatically generates "canonical constructor", means constructor that takes all record component.
            - We can override the canonical constructor if needed.
            - We can have more constructors with different parameters  list, but directly or in-directly they must invoke canonical constructor.
            - Why? Because canonical constructor gives guarantees that all fields (record components) will get initialized.
            - if  this is not mandatory then there is a chance that some field might get uninitialized

 */

public record User2(String name, int age) {

    // String lastname;

    public static String lastname;
}
