package ru.aston.shellsorter.service;

import ru.aston.shellsorter.model.Car;
import ru.aston.shellsorter.utils.generator.CarRandomGenerator;

import java.util.Arrays;
import java.util.Random;

public class CarService implements Service {
    private Car[] array;

    public void randomGeneratedFill(int length) {
        array = new CarRandomGenerator(new Random()).generateArray(length);
        System.out.println(Arrays.toString(array));
    }
}
