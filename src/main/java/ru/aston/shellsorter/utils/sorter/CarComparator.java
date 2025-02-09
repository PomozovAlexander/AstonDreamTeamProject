package ru.aston.shellsorter.utils.sorter;

import ru.aston.shellsorter.model.Car;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.compareTo(o2);
    }
}
