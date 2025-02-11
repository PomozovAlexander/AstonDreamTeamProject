package ru.aston.shellsorter.factory;

import java.util.Random;

import ru.aston.shellsorter.model.Car;
import ru.aston.shellsorter.utils.generator.CarRandomGenerator;
import ru.aston.shellsorter.utils.generator.RandomGenerator;
import ru.aston.shellsorter.validator.Validator;
import ru.aston.shellsorter.validator.CarValidator;

public class CarFactory implements AbstractFactory<Car>{

    @Override
    public String givesFileTitle() {
        return "Car.txt";
    }

    @Override
    public RandomGenerator<Car> createGenerator(Random random) {
        return new CarRandomGenerator(random);
    }


    @Override
    public Validator<Car> createValidator() {
        return new CarValidator();
    }
}
