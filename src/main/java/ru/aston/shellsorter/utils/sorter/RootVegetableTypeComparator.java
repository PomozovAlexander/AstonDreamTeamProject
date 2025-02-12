package ru.aston.shellsorter.utils.sorter;

import ru.aston.shellsorter.model.RootVegetable;

import java.util.Comparator;

public class RootVegetableTypeComparator implements Comparator<RootVegetable> {
    @Override
    public int compare(RootVegetable o1, RootVegetable o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
