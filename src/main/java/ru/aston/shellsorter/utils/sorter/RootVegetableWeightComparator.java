package ru.aston.shellsorter.utils.sorter;

import ru.aston.shellsorter.model.RootVegetable;

import java.util.Comparator;

public class RootVegetableWeightComparator implements Comparator<RootVegetable> {
    @Override
    public int compare(RootVegetable o1, RootVegetable o2) {
        return o1.getWeight()-o2.getWeight();
    }
}
