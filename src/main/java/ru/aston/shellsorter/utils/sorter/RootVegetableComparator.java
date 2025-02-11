package ru.aston.shellsorter.utils.sorter;

import ru.aston.shellsorter.model.RootVegetable;

import java.util.Comparator;

public class RootVegetableComparator implements Comparator <RootVegetable>{
    @Override
    public int compare(RootVegetable o1, RootVegetable o2) {
        return o1.compareTo(o2);
    }
}
