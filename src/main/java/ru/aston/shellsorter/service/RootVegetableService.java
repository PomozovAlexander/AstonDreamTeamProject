package ru.aston.shellsorter.service;

import ru.aston.shellsorter.model.RootVegetable;
import ru.aston.shellsorter.utils.generator.RootVegetableRandomGenerator;

import java.util.Arrays;
import java.util.Random;

public class RootVegetableService implements Service {
    private RootVegetable[] array;
    private boolean sorted = false;
    private String sortedField = "Weight"; //default field

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

        //todo реализовать сортировку без передачи компаратора

        System.out.println(Arrays.toString(array)); //sorting result for user
        sorted = true;
    }

    @Override
    public void sortByField(String field) {

        //todo реализовать сортировку с передачей компаратора в зависимости от сортируемого поля или вызвать реализованную

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
