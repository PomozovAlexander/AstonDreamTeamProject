package ru.aston.shellsorter.service;

import ru.aston.shellsorter.model.Book;
import ru.aston.shellsorter.utils.cli.BookArrayCLIBuilder;
import ru.aston.shellsorter.utils.finder.FinderBookUtil;
import ru.aston.shellsorter.utils.finder.FinderCarUtil;
import ru.aston.shellsorter.utils.generator.BookRandomGenerator;
import ru.aston.shellsorter.utils.sorter.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Random;

/**
 * Service implementation for operations on an array of {@link Book} objects.
 */
public class BookService implements Service {
    private Book[] array;
    private boolean sorted = false;
    private String sortedField = "Author"; //default field
    private static ShellSorter sorter = new ShellSorter();
    private static Comparator<Book> bookAuthorComparator = new BookAuthorComparator();
    private static Comparator<Book> bookTitleComparator = new BookTitleComparator();
    private static Comparator<Book> bookPagesComparator = new BookPagesComparator();


    /**
     * Fills the array with randomly generated Book objects.
     *
     * @param length the number of Books to generate.
     */
    @Override
    public void randomGeneratedFill(int length) {
        array = new BookRandomGenerator(new Random()).generateArray(length);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Fills the array with Books from a file.
     *
     * @param length the number of Books to fill.
     */
    @Override
    public void fromFileFill(int length) {

    }

    /**
     * Fills the array via CLI.
     *
     * @param length the number of Books to fill.
     */
    @Override
    public void manualFill(int length) {
        array = BookArrayCLIBuilder.buildBookArrayFromCLI(length);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Sorting the array by default comparator.
     */
    @Override
    public void sort() {
        Comparator<Book> bookComparator = new BookComparator();
        sorter.sort(array, bookComparator);

        System.out.println(Arrays.toString(array)); //sorting result for user
        sorted = true;
    }

    /**
     * Sorts the array based on the specified field.
     *
     * @param field the name of the field to sort by.
     */
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

    /**
     * Searching in the array for the specified query.
     *
     * @param request the search query string.
     */
    @Override
    public void search(String request) {
        Optional<Book> searchingResult = Optional.empty(); //внести результат поиска

        switch (sortedField.toLowerCase()) {
            case "author":
                searchingResult = Optional.ofNullable(FinderBookUtil.findBookByAuthor(array, request));
                break;

            case "title":
                searchingResult = Optional.ofNullable(FinderBookUtil.findBookByTitle(array, request));
                break;

            case "pages":
                int pages = 0;
                try {
                    pages = Integer.parseInt(request);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Please, input number og pages");
                }
                searchingResult = Optional.ofNullable(FinderBookUtil.findBookByPages(array, pages));
                break;
            default:
                throw new IllegalArgumentException("unknown field");
        }

        searchingResult.ifPresentOrElse(
                System.out::println,
                () -> System.out.printf("Nothing found for your request %s%n.", request)
        );
    }

    /**
     * Printing an array to CLI.
     */
    @Override
    public void print() {
        System.out.println(Arrays.toString(array));
    }

    /**
     * Saving an array to file.
     */
    @Override
    public void save() {

        //TODO: Реализовать сохранение в файл

    }

    /**
     * Returns the name of the field by which the array has been sorted.
     *
     * @return the name of the sorted field, or a default value.
     */
    @Override
    public String getSortedField() {
        return sortedField;
    }

    /**
     * Checks whether the collection or data structure is sorted.
     *
     * @return {@code true} if the data is sorted, otherwise {@code false}.
     */
    @Override
    public boolean isSorted() {
        return sorted;
    }
}
