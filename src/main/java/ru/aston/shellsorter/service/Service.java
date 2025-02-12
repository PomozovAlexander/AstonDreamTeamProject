package ru.aston.shellsorter.service;

/**
 * The Service interface defines a set of operations for filling, sorting, and searching data in array.
 */
public interface Service {
    /**
     * Fills an array with randomly generated data.
     *
     * @param length the length of array.
     */
    void randomGeneratedFill(int length);

    /**
     * Fills an array with values obtained from a file.
     *
     * @param length the number of elements to fill.
     */
    void fromFileFill(int length);

    /**
     * Fills an array with values from user input.
     *
     * @param length the length of array.
     */
    void manualFill(int length);

    /**
     * Sorting the array by default comparator.
     */
    void sort();

    /**
     * Sorts the array based on the specified field.
     *
     * @param field the name of the field to sort by.
     */
    void sortByField(String field);

    /**
     * Searching in the array for the specified query.
     *
     * @param request the search query string.
     */
    void search(String request);

    /**
     * Printing an array to CLI.
     */
    void print();

    /**
     * Saving an array to file.
     */
    void save();

    /**
     * Returns the name of the field by which the array has been sorted.
     *
     * @return the name of the sorted field, or a default value.
     */
    String getSortedField();

    /**
     * Checks whether the collection or data structure is sorted.
     *
     * @return {@code true} if the data is sorted, otherwise {@code false}.
     */
    boolean isSorted();
}
