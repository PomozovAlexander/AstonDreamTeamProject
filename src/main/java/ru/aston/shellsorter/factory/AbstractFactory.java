package ru.aston.shellsorter.factory;

import java.util.Random;

import ru.aston.shellsorter.utils.generator.RandomGenerator;
import ru.aston.shellsorter.validator.Validator;

public interface AbstractFactory <T>{
    String givesFileTitle();
    
    RandomGenerator<T> createGenerator(Random random);

    Validator<T> createValidator();
}
