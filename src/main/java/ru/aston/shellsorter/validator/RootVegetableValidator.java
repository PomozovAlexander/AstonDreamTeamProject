package ru.aston.shellsorter.validator;

import ru.aston.shellsorter.model.RootVegetable;

public class RootVegetableValidator implements Validator<RootVegetable>{
    @Override
    public Boolean validate(RootVegetable rootVegetable) {
        if (rootVegetable.getWeight() <= 0) {   
            throw new IllegalArgumentException("Weight must be greater than 0");
        }       
        if (rootVegetable.getType().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        if (rootVegetable.getColor().isEmpty()) {
            throw new IllegalArgumentException("Color must not be empty");
        }
        return true;
    }
}