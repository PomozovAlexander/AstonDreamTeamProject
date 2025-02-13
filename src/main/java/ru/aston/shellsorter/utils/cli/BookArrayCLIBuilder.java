package ru.aston.shellsorter.utils.cli;

import ru.aston.shellsorter.model.Book;

import java.util.Scanner;

/**
 * Utility class for creating an array of {@link Book} from CLI.
 */
public final class BookArrayCLIBuilder {

    private BookArrayCLIBuilder() {
        throw new UnsupportedOperationException("Utility class.");
    }

    /**
     * Builds an array of {@link Book}.
     *
     * @param length the length of array.
     * @return an array of Books.
     * @throws IllegalArgumentException if length is negative.
     */
    public static Book[] buildBookArrayFromCLI(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Array length must be non-negative.");
        }

        Book[] books = new Book[length];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < length; i++) {
            System.out.printf("Enter details for Book #%d:%n", i + 1);

            String author = InputUtil.promptForNonEmptyString("Author: ", scanner);
            String title = InputUtil.promptForNonEmptyString("Title: ", scanner);
            int pages = InputUtil.promptForPositiveInt("Pages: ", scanner);

            books[i] = new Book.Builder()
                    .setAuthor(author)
                    .setTitle(title)
                    .setPages(pages)
                    .build();

            System.out.println("Book created successfully!\n");
        }
        return books;
    }
}
