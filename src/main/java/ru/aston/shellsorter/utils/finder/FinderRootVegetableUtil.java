package ru.aston.shellsorter.utils.finder;

import ru.aston.shellsorter.model.Book;
import ru.aston.shellsorter.model.RootVegetable;
import ru.aston.shellsorter.utils.sorter.*;

import java.util.Comparator;

public class FinderRootVegetableUtil {

    private static ShellSorter sorter = new ShellSorter();


    public static <T> RootVegetable findRootVegetableByType(RootVegetable[] vegetables, String type) {
        if (type.isEmpty()) {
            throw new IllegalArgumentException("You cannot pass empty type name");
        }
        Comparator comparator = new RootVegetableTypeComparator();
        sorter.sort(vegetables, comparator);
        int low = 0;
        int high = vegetables.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = vegetables[mid].getType().compareTo(type);
            if (result == 0) {
                System.out.println(vegetables[mid].toString());
                return vegetables[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("RootVegetable not found");
        return null;
    }
    public static <T> RootVegetable findRootVegetableByWeight(RootVegetable[] rootVegetables, int weight) {

        if (weight <= 0) {
            throw new IllegalArgumentException("You cannot pass a negative number or zero");
        }


        Comparator comparator = new RootVegetableWeightComparator();
        sorter.sort(rootVegetables, comparator);
        int low = 0;
        int high = rootVegetables.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = Integer.compare(rootVegetables[mid].getWeight(), weight);
            if (result == 0) {
                System.out.println(rootVegetables[mid].toString());
                return rootVegetables[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("RootVegetable not found");
        return null;
    }
    public static <T> RootVegetable findRootVegetableByColor(RootVegetable[] vegetables, String color) {
        if (color.isEmpty()) {
            throw new IllegalArgumentException("You cannot pass empty color");
        }
        Comparator comparator = new RootVegetableColorComparator();
        sorter.sort(vegetables, comparator);
        int low = 0;
        int high = vegetables.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = vegetables[mid].getColor().compareTo(color);
            if (result == 0) {
                System.out.println(vegetables[mid].toString());
                return vegetables[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("RootVegetable not found");
        return null;
    }
}
