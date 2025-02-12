package ru.aston.shellsorter.utils.finder;


import ru.aston.shellsorter.model.Car;

import ru.aston.shellsorter.utils.sorter.CarModelComparator;
import ru.aston.shellsorter.utils.sorter.CarPowerComparator;
import ru.aston.shellsorter.utils.sorter.CarProductionYearComparator;
import ru.aston.shellsorter.utils.sorter.ShellSorter;

import java.time.Year;
import java.util.Comparator;

public class FinderCarUtil {

    private static ShellSorter sorter = new ShellSorter();


    public static <T> Car findCarByModel(Car[] cars, String model) {
        if (model.isEmpty()) {
            throw new IllegalArgumentException("You cannot pass empty model name");
        }

//        Comparator comparator = new CarModelComparator();
//        sorter.sort(cars, comparator);

        int low = 0;
        int high = cars.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = cars[mid].getModel().compareToIgnoreCase(model);
            if (result == 0) {
               // System.out.println(cars[mid].toString());
                return cars[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Car not found");
        return null;
    }

    public static <T> Car findCarByPower(Car[] cars, int power) {
        if (power<=0) {
            throw new IllegalArgumentException("You cannot pass a negative number or zero");
        }
//        Comparator comparator = new CarPowerComparator();
//        sorter.sort(cars, comparator);

        int low = 0;
        int high = cars.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = Integer.compare(cars[mid].getPower(), power);
            if (result == 0) {
               // System.out.println(cars[mid].toString());
                return cars[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Car not found");
        return null;
    }
    public static <T> Car findCarByProductionYear(Car[] cars, int productionYear) {
        if ((productionYear<1885 ) || (productionYear> Year.now().getValue())) {
            throw new IllegalArgumentException("The car has not yet been invented or does not exist yet");
        }
//        Comparator comparator = new CarProductionYearComparator();
//        sorter.sort(cars, comparator);
        int low = 0;
        int high = cars.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = Integer.compare(cars[mid].getProductionYear(), productionYear);
            if (result == 0) {
              //  System.out.println(cars[mid].toString());
                return cars[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Car not found");
        return null;
    }


}
