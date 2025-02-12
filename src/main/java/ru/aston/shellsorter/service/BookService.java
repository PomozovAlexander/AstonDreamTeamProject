package ru.aston.shellsorter.service;

import ru.aston.shellsorter.model.Book;
import ru.aston.shellsorter.utils.generator.BookRandomGenerator;
import ru.aston.shellsorter.utils.sorter.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class BookService implements Service {
    private Book[] array;
    private boolean sorted = false;
    private String sortedField = "Author"; //default field
    private static ShellSorter sorter= new ShellSorter();
    private static Comparator<Book> bookAuthorComparator = new BookAuthorComparator();
    private static Comparator<Book> bookTitleComparator = new BookTitleComparator();
    private static Comparator<Book> bookPagesComparator = new BookPagesComparator();


    @Override
    public void randomGeneratedFill(int length) {
        array = new BookRandomGenerator(new Random()).generateArray(length);
        System.out.println(Arrays.toString(array));
    }

    @Override
    public void fromFileFill(int length) {

    }

    @Override
    public void manualFill(int length) {

    }

    @Override
    public void sort() {
        Comparator<Book> bookComparator= new BookComparator();
        sorter.sort(array,bookComparator);

        System.out.println(Arrays.toString(array)); //sorting result for user
        sorted = true;
    }

    @Override
    public void sortByField(String field) {

        switch (field.toLowerCase()) {
            case "author":
                sorter.sort(array, bookAuthorComparator);
                break;
            case "title":
                sorter.sort(array, bookTitleComparator);
                break;
            case "pages":
                sorter.sort(array, bookPagesComparator);
                break;
            default:
                throw new IllegalArgumentException("unknown field");

        }

        System.out.println(Arrays.toString(array)); //sorting result for user
        sorted = true;
        sortedField = field;
    }

    @Override
    public String getSortedField() {
        return sortedField;
    }

    @Override
    public boolean isSorted() {
        return sorted;
    }
}
