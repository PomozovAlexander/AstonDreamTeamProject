package ru.aston.shellsorter.service;

import ru.aston.shellsorter.model.RootVegetable;
import ru.aston.shellsorter.utils.cli.RootVegetableArrayCLIBuilder;
import ru.aston.shellsorter.utils.finder.FinderBookUtil;
import ru.aston.shellsorter.utils.finder.FinderRootVegetableUtil;
import ru.aston.shellsorter.utils.generator.RootVegetableRandomGenerator;
import ru.aston.shellsorter.utils.sorter.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Random;

/**
 * Service implementation for operations on an array of {@link RootVegetable} objects.
 */
public class RootVegetableService implements Service {
    private RootVegetable[] array;
    private boolean sorted = false;
    private String sortedField = "Weight"; //default field
    private static ShellSorter sorter = new ShellSorter();
    private static Comparator<RootVegetable> rootVegetableTypeComparator = new RootVegetableTypeComparator();
    private static Comparator<RootVegetable> rootVegetableWeightComparator = new RootVegetableWeightComparator();
    private static Comparator<RootVegetable> rootVegetableColorComparator = new RootVegetableColorComparator();


    /**
     * Fills the array with randomly generated RootVegetable objects.
     *
     * @param length the number of RootVegetables to generate.
     */
    @Override
    public void randomGeneratedFill(int length) {
        array = new RootVegetableRandomGenerator(new Random()).generateArray(length);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Fills the array with RootVegetables from a file.
     *
     * @param length the number of RootVegetables to fill.
     */
    @Override
    public void fromFileFill(int length) {

    }

    /**
     * Fills the array via CLI.
     *
     * @param length the number of RootVegetables to fill.
     */
    @Override
    public void manualFill(int length) {
        array = RootVegetableArrayCLIBuilder.buildRootVegetableArrayFromCLI(length);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Sorting the array by default comparator.
     */
    @Override
    public void sort() {

        Comparator<RootVegetable> comparator = new RootVegetableColorComparator();
        sorter.sort(array, comparator);

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
            case "type":
                sorter.sort(array, rootVegetableTypeComparator);
                break;
            case "weight":
                sorter.sort(array, rootVegetableWeightComparator);
                System.out.println(Arrays.toString(array));
                break;
            case "color":
                sorter.sort(array, rootVegetableColorComparator);
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
        Optional<RootVegetable> searchingResult = Optional.empty(); //внести результат поиска

        switch (sortedField.toLowerCase()) {
            case "type":
                searchingResult = Optional.ofNullable(FinderRootVegetableUtil.findRootVegetableByType(array, request));
                break;

            case "color":
                searchingResult = Optional.ofNullable(FinderRootVegetableUtil.findRootVegetableByColor(array, request));
                break;

            case "weight":
                int weight = 0;
                try {
                    weight = Integer.parseInt(request);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Please, input weight");
                }
                searchingResult = Optional.ofNullable(FinderRootVegetableUtil.findRootVegetableByWeight(array, weight));
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
