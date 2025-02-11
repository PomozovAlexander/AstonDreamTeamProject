package ru.aston.shellsorter.factory;

import java.util.Random;

import ru.aston.shellsorter.model.RootVegetable;
import ru.aston.shellsorter.utils.generator.RootVegetableRandomGenerator;
import ru.aston.shellsorter.validator.RootVegetableValidator;
import ru.aston.shellsorter.validator.Validator;
import ru.aston.shellsorter.utils.generator.RandomGenerator;

public class RootVegetableFactory implements AbstractFactory<RootVegetable>{
    @Override
    public String givesFileTitle() {
        return "RootVegetable.txt";
    }

    @Override
    public RandomGenerator<RootVegetable> createGenerator(Random random) {
        return new RootVegetableRandomGenerator(random);
    }


    @Override
    public Validator<RootVegetable> createValidator() {
        return new RootVegetableValidator();
    }
}
