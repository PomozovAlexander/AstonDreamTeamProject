package ru.aston.shellsorter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.aston.shellsorter.model.RootVegetable;
import ru.aston.shellsorter.utils.cli.RootVegetableArrayCLIBuilder;
import ru.aston.shellsorter.utils.fileloader.FillingArrayWithRootVegetable;
import ru.aston.shellsorter.utils.finder.FinderRootVegetableUtil;
import ru.aston.shellsorter.utils.generator.RootVegetableRandomGenerator;
import ru.aston.shellsorter.utils.sorter.RootVegetableColorComparator;
import ru.aston.shellsorter.utils.sorter.RootVegetableTypeComparator;
import ru.aston.shellsorter.utils.sorter.RootVegetableWeightComparator;
import ru.aston.shellsorter.utils.sorter.ShellSorter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Service implementation for operations on an array of {@link RootVegetable} objects.
 */
public class RootVegetableService implements Service {
    private static final ShellSorter sorter = new ShellSorter();
    private static final Comparator<RootVegetable> rootVegetableTypeComparator = new RootVegetableTypeComparator();
    private static final Comparator<RootVegetable> rootVegetableWeightComparator = new RootVegetableWeightComparator();
    private static final Comparator<RootVegetable> rootVegetableColorComparator = new RootVegetableColorComparator();
    private RootVegetable[] array;
    private boolean sorted = false;
    private String sortedField = "Type"; //default field

    /**
     * Fills the array with randomly generated RootVegetable objects.
     *
     * @param length the number of RootVegetables to generate.
     */
    @Override
    public void randomGeneratedFill(int length) {
        array = new RootVegetableRandomGenerator(new Random()).generateArray(length);
        Stream.of(array).forEach(System.out::println);
    }

    /**
     * Fills the array with RootVegetables from a file.
     *
     * @param length the number of RootVegetables to fill.
     */
    @Override
    public void fromFileFill(int length) {
        array = FillingArrayWithRootVegetable.buildRootVegetableArrayFromJson(length);
        Stream.of(array).forEach(System.out::println);
    }

    /**
     * Fills the array via CLI.
     *
     * @param length the number of RootVegetables to fill.
     */
    @Override
    public void manualFill(int length) {
        array = RootVegetableArrayCLIBuilder.buildRootVegetableArrayFromCLI(length);
        Stream.of(array).forEach(System.out::println);
    }

    /**
     * Sorting the array by default comparator.
     */
    @Override
    public void sort() {

        sorter.sort(array, rootVegetableTypeComparator);

        Stream.of(array).forEach(System.out::println); //sorting result for user
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

        Stream.of(array).forEach(System.out::println); //sorting result for user
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
        Optional<RootVegetable> searchingResult;

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
                () -> System.out.printf("Nothing found for your request %s%n", request)
        );
    }

    /**
     * Printing an array to CLI.
     */
    @Override
    public void print() {
        Stream.of(array).forEach(System.out::println);
    }

    /**
     * Saving an array to file.
     */
    @Override
    public void save() {

        ObjectMapper objectMapper = new ObjectMapper();

        File resultsDir = new File("src/main/resources/results");
        File file = new File(resultsDir, "rootvegetable.json");


        try {
            objectMapper.writeValue(file, array);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
