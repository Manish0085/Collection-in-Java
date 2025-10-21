package Revision.TerminalOperation;

import Revision.intermediate.Book;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TerminallChallenge {

    public static void main(String[] args) {

        List<Book> books = Arrays.asList(
                new Book("The Silent Patient", 2019, 17.99, "Thriller"),
                new Book("Atomic Habits", 2018, 21.50, "Self-Help"),
                new Book("To Kill a Mockingbird", 1960, 12.99, "Classic"),
                new Book("1984", 1949, 14.75, "Classic"),
                new Book("The Great Gatsby", 1925, 10.99, "Classic"),
                new Book("The Alchemist", 1988, 15.49, "Fiction"),
                new Book("Clean Code", 2008, 32.99, "Programming"),
                new Book("The Pragmatic Programmer", 1999, 29.99, "Programming"),
                new Book("Pride and Prejudice", 1813, 9.99, "Classic"),
                new Book("The Hobbit", 1937, 18.75, "Fantasy"),
                new Book("The Subtle Art of Not Giving a F*ck", 2016, 22.50, "Self-Help"),
                new Book("Dune", 1965, 19.99, "Sci-Fi"),
                new Book("Becoming", 2018, 24.00, "Biography"),
                new Book("Deep Work", 2016, 16.75, "Self-Help"),
                new Book("Harry Potter and the Philosopher's Stone", 1997, 20.99, "Fantasy")
        );


        // Total cost of all books in the bookstore
//        double sum = books.stream()
//                .mapToDouble(book -> book.price)
//                .sum();
        double sum = books.stream()
                .mapToDouble(book -> book.price)
                .reduce(0, Double::sum);
        System.out.println("Total Sum: " + sum);

        // Collecting books into a list of titles
        System.out.println("\nList of book titles: ");
        books.stream()
                .map(book -> book.title)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // Grouping books by category

        System.out.println("\n\nGrouping Books by Category: ");
        Map<String, List<Book>> byCategory = books.stream()
                .collect(Collectors.groupingBy(bookStringFunction));
        byCategory.forEach((category, bookList) -> {
            bookList.forEach(System.out::println);
        });

    }

    static Function<Book, String> bookStringFunction = new Function<Book, String>() {
        @Override
        public String apply(Book book) {
            return book.getCategory();
        }
    };
}
