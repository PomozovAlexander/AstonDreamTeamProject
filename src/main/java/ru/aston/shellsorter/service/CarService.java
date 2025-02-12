package ru.aston.shellsorter.service;

import ru.aston.shellsorter.model.Car;
import ru.aston.shellsorter.utils.generator.CarRandomGenerator;
import ru.aston.shellsorter.utils.sorter.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class CarService implements Service {
    private Car[] array;
    private boolean sorted = false;
    private String sortedField = "Power"; //default field
    private static Comparator<Car> carPowerComparator = new CarPowerComparator();
    private static Comparator<Car> carModelComparator = new CarModelComparator();
    private static Comparator<Car> carProductionYearComparator = new CarProductionYearComparator();

    private static ShellSorter sorter = new ShellSorter();

    @Override
    public String getSortedField() {
        return sortedField;
    }

    @Override
    public void randomGeneratedFill(int length) {
        array = new CarRandomGenerator(new Random()).generateArray(length);
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

        Comparator<Car> comparator = new CarComparator();
        sorter.sort(array, comparator);

        System.out.println(Arrays.toString(array)); //sorting result for user
        sorted = true;
    }

    @Override
    public void sortByField(String field) {
        switch (field.toLowerCase()) {
            case "power":
                sorter.sort(array, carPowerComparator);
                break;
            case "model":
                sorter.sort(array, carModelComparator);
                break;
            case "productionYear":
                sorter.sort(array, carProductionYearComparator);
                break;
            default:
                throw new IllegalArgumentException("unknown field");
        }

        System.out.println(Arrays.toString(array)); //sorting result for user
        sorted = true;
        sortedField = field;
    }

    @Override
    public boolean isSorted() {
        return sorted;
    }
}
