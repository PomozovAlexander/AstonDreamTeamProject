package ru.aston.shellsorter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.aston.shellsorter.model.Car;
import ru.aston.shellsorter.utils.cli.CarArrayCLIBuilder;
import ru.aston.shellsorter.utils.fileloader.FillingArrayWithCar;
import ru.aston.shellsorter.utils.finder.FinderCarUtil;
import ru.aston.shellsorter.utils.generator.CarRandomGenerator;
import ru.aston.shellsorter.utils.sorter.*;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Service implementation for operations on an array of {@link Car} objects.
 */
public class CarService implements Service {
    private static final Comparator<Car> carPowerComparator = new CarPowerComparator();
    private static final Comparator<Car> carModelComparator = new CarModelComparator();
    private static final Comparator<Car> carProductionYearComparator = new CarProductionYearComparator();
    private static final ShellSorter sorter = new ShellSorter();
    private Car[] array;
    private boolean sorted = false;
    private String sortedField = "Power"; //default field

    /**
     * Fills the array with randomly generated Car objects.
     *
     * @param length the number of Cars to generate.
     */
    @Override
    public void randomGeneratedFill(int length) {
        array = new CarRandomGenerator(new Random()).generateArray(length);
        Stream.of(array).forEach(System.out::println);
    }

    /**
     * Fills the array with Cars from a file.
     *
     * @param length the number of Cars to fill.
     */
    @Override
    public void fromFileFill(int length) {
        array = FillingArrayWithCar.buildCarArrayFromJson(length);
        Stream.of(array).forEach(System.out::println);
    }

    /**
     * Fills the array via CLI.
     *
     * @param length the number of Cars to fill.
     */
    @Override
    public void manualFill(int length) {
        array = CarArrayCLIBuilder.buildCarArrayFromCLI(length);
        Stream.of(array).forEach(System.out::println);
    }

    /**
     * Sorting the array by default comparator.
     */
    @Override
    public void sort() {

        Comparator<Car> comparator = new CarComparator();
        sorter.sort(array, comparator);

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
            case "power":
                sorter.sort(array, carPowerComparator);
                break;
            case "model":
                sorter.sort(array, carModelComparator);
                break;
            case "production year":
                sorter.sort(array, carProductionYearComparator);
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


        Optional<Car> searchingResult;

        switch (sortedField.toLowerCase()) {
            case "power":
                int power = 0;
                try {
                    power = Integer.parseInt(request);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Please, input power");
                }
                searchingResult = Optional.ofNullable(FinderCarUtil.findCarByPower(array, power));
                break;

            case "model":

                searchingResult = Optional.ofNullable(FinderCarUtil.findCarByModel(array, request));
                break;

            case "production year":
                int year = 0;
                try {
                    year = Integer.parseInt(request);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Please, input year");
                }
                searchingResult = Optional.ofNullable(FinderCarUtil.findCarByPower(array, year));
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
        File file = new File(resultsDir, "car.json");


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
    public boolean isSorted() {
        return sorted;
    }

    /**
     * Checks whether the collection or data structure is sorted.
     *
     * @return {@code true} if the data is sorted, otherwise {@code false}.
     */
    @Override
    public String getSortedField() {
        return sortedField;
    }
}
