package ru.aston.shellsorter.service;

import ru.aston.shellsorter.model.RootVegetable;
import ru.aston.shellsorter.utils.generator.RootVegetableRandomGenerator;
import ru.aston.shellsorter.utils.sorter.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class RootVegetableService implements Service {
    private RootVegetable[] array;
    private boolean sorted = false;
    private String sortedField = "Weight"; //default field
    private static ShellSorter sorter= new ShellSorter();
    private static Comparator<RootVegetable> rootVegetableTypeComparator = new RootVegetableTypeComparator();
    private static Comparator<RootVegetable> rootVegetableWeightComparator = new RootVegetableWeightComparator();
    private static Comparator<RootVegetable> rootVegetableColorComparator = new RootVegetableColorComparator();


    @Override
    public void randomGeneratedFill(int length) {
        array = new RootVegetableRandomGenerator(new Random()).generateArray(length);
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

        Comparator<RootVegetable>comparator= new RootVegetableColorComparator();
        sorter.sort(array, comparator);

        System.out.println(Arrays.toString(array)); //sorting result for user
        sorted = true;
    }

    @Override
    public void sortByField(String field) {
        switch (field.toLowerCase()) {
            case "type":
                sorter.sort(array, rootVegetableTypeComparator);
                break;
            case "weight":
                sorter.sort(array, rootVegetableWeightComparator);
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

    @Override
    public String getSortedField() {
        return sortedField;
    }

    @Override
    public boolean isSorted() {
        return sorted;
    }
}
