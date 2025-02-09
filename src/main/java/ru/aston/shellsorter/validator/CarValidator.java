package ru.aston.shellsorter.validator;

import ru.aston.shellsorter.model.Car;

public class CarValidator implements Validator<Car>{
    @Override
    public Boolean validate(Car car) {
        if (car.getPower() <= 0) {   
            throw new IllegalArgumentException("Power must be greater than 0");
        }       
        if (car.getModel().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        if (car.getProductionYear() <= 0) {
            throw new IllegalArgumentException("Number of pages must be greater than 0");
        }
        return true;
    }
}
