package ru.aston.shellsorter.service;

import ru.aston.shellsorter.model.RootVegetable;
import ru.aston.shellsorter.utils.generator.RootVegetableRandomGenerator;

import java.util.Arrays;
import java.util.Random;

public class RootVegetableService implements Service {
    private RootVegetable[] array;

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
}
