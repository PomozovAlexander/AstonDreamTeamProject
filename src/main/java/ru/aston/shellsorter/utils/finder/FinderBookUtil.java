package ru.aston.shellsorter.utils.finder;


import ru.aston.shellsorter.model.Book;
import ru.aston.shellsorter.utils.sorter.BookAuthorComparator;
import ru.aston.shellsorter.utils.sorter.BookPagesComparator;
import ru.aston.shellsorter.utils.sorter.BookTitleComparator;
import ru.aston.shellsorter.utils.sorter.ShellSorter;

import java.util.Comparator;

public class FinderBookUtil {
    private static ShellSorter sorter = new ShellSorter();


    public static <T> Book findBookByAuthor(Book[] books, String author) {
        if (author.isEmpty()) {
            throw new IllegalArgumentException("You cannot pass empty author name");
        }
        Comparator comparator = new BookAuthorComparator();
        sorter.sort(books, comparator);
        int low = 0;
        int high = books.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = books[mid].getAuthor().compareTo(author);
            if (result == 0) {
                System.out.println(books[mid].toString());
                return books[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Book not found");
        return null;
    }

    public static <T> Book findBookByTitle(Book[] books, String title) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("You cannot pass empty title");
        }

        Comparator comparator = new BookTitleComparator();
        sorter.sort(books, comparator);
        int low = 0;
        int high = books.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = books[mid].getTitle().compareTo(title);
            if (result == 0) {
                System.out.println(books[mid].toString());
                return books[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Book not found");
        return null;
    }

    public static <T> Book findBookByPages(Book[] books, int pages) {

        if (pages <= 0) {
            throw new IllegalArgumentException("You cannot pass a negative number or zero");
        }


        Comparator comparator = new BookPagesComparator();
        sorter.sort(books, comparator);
        int low = 0;
        int high = books.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = Integer.compare(books[mid].getPages(), pages);
            if (result == 0) {
                System.out.println(books[mid].toString());
                return books[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Book not found");
        return null;
    }
}

