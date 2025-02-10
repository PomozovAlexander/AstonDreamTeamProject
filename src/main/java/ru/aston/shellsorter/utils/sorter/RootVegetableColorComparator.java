package ru.aston.shellsorter.utils.sorter;

import ru.aston.shellsorter.model.RootVegetable;

import java.util.Comparator;

public class RootVegetableColorComparator implements Comparator<RootVegetable> {
    @Override
    public int compare(RootVegetable o1, RootVegetable o2) {
        return o1.getColor().compareTo(o2.getColor());
    }
}
