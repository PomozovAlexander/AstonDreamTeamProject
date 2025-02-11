package ru.aston.shellsorter.service;

import ru.aston.shellsorter.model.Book;
import ru.aston.shellsorter.utils.cli.BookArrayCLIBuilder;
import ru.aston.shellsorter.utils.generator.BookRandomGenerator;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

/**
 * Service implementation for operations on an array of {@link Book} objects.
 */
public class BookService implements Service {
    private Book[] array;
    private boolean sorted = false;
    private String sortedField = "Author"; //default field

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

        //todo реализовать сортировку без передачи компаратора

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

        //todo реализовать сортировку с передачей компаратора в зависимости от сортируемого поля или вызвать реализованную

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

        //todo вызвать поиск по полю <sortedField>

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
