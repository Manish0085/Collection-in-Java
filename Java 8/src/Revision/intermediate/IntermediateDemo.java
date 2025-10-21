package Revision.intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediateDemo {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        books.add(new Book("The Lord of the Rings", 1954, 15.99, "Fantasy"));
        books.add(new Book("1984", 1949, 10.50, "Dystopian Fiction"));
        books.add(new Book("Pride and Prejudice", 1813, 8.75, "Classic Romance"));
        books.add(new Book("Sapiens: A Brief History of Humankind", 2011, 20.00, "Non-Fiction History"));
        books.add(new Book("The Da Vinci Code", 2003, 12.95, "Thriller"));
        books.add(new Book("Cosmos", 1980, 18.50, "Science"));
        books.add(new Book("To Kill a Mockingbird", 1960, 9.99, "Southern Gothic"));
        books.add(new Book("A Game of Thrones", 1996, 14.50, "Epic Fantasy"));
        books.add(new Book("The Hitchhiker's Guide to the Galaxy", 1979, 11.25, "Sci-Fi Comedy"));
        books.add(new Book("Where the Crawdads Sing", 2018, 16.99, "Mystery Drama"));

        // 1. Filtering: Books cheaper then $15
        System.out.println("Books having price less than $15: ");
        Stream<Book> stream1 = books.stream();
        Stream<Book> stream2 = stream1.filter(book -> book.price < 15 );
        stream2.forEach(System.out::println);


        // 2. Mapping: Convert Book titles to Uppercase
        System.out.println("\nConverting book title into uppercase: ");
        books.stream()
                .map(book -> book.title.toUpperCase())
                .forEach(System.out::println);

        // 3. Sorting: Books by publication date
        System.out.println("\nBooks sorted: ");
        books.stream()
                .sorted((book1, book2) -> book1.publicationYear - book2.publicationYear)
                .forEach(System.out::println);

        // 4. Distinct: Remove duplicate titles
        System.out.println("\nDistinct Books: ");
        books.stream()
                .distinct()
                .forEach(System.out::println);

        // 5. Limit: Display only the first 3 books
        System.out.println("\nFirst three boooks from list: ");
        books.stream()
                .limit(3)
                .forEach(System.out::println);


        // 6. First three published books
        System.out.println("\nFirst three published books: ");
        books.stream()
                .sorted((book1, book2) -> book1.publicationYear - book2.publicationYear)
                .limit(3)
                .forEach(System.out::println);

        // 7. Skip: Skip the first 2 books
        System.out.println("\nAfter skipping first two books: ");
        books.stream()
                .skip(2)
                .forEach(System.out::println);

    }

    static Predicate<Book> predicate = (book) -> book.price < 15;
}
