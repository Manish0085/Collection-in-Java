package Revision.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BookStoreChallange {

    public static void main(String[] args) {
        /*
        - Discounted Books: The bookstore is planning a sale.
            Identify all books that are priced over $15. Display these books.
        - Classic Collection: The bookstore is launching a classics collection.
            Identify and display books that were published before the year 2000.
        - Upcoming Titles: Generate a list of future book titles for next year
            by adding the suffix "(Coming Soon)" to all the current titles.
        - Sort by Price: The bookstore wants to print price tags for all the books.
            Display the books sorted by their prices in ascending order.
        - Rare Books: The bookstore believes there might be rare books in the
            collection. A rare book in one where the title has more than 20
            characters. Identify and display these books.
        */


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

        // Challenge 1:
        System.out.println("Books having price over $15: ");
        books.stream()
                .filter(book -> book.price > 15)
                .forEach(System.out::println);


        // Challenge 2:
        System.out.println("\n\nBooks published before 2000 : ");
        books.stream()
                .filter(book -> book.publicationYear < 2000)
                .forEach(System.out::println);

        // Challenge 3:
        System.out.println("\n\nAdding tags at the end of book titles");
        books.stream()
                .map(book -> book.title + " (Coming Soon)")
                        .forEach(System.out::println);


        // Challenge 4:
        System.out.println("\n\nSorted books based on Price: ");
        books.stream()
                .sorted((book1, book2) -> (int) (book1.price - book2.price))
                .forEach(System.out::println);

        System.out.println();
        books.stream()
                .sorted(Comparator.comparingDouble(book -> book.price))
                        .forEach(System.out::println);

        // Challenge 5:
        System.out.println("\n\nBooks having title of more than 20 characters: ");
        books.stream()
                .filter(book -> book.title.length() > 20)
                .forEach(System.out::println);
    }
}
