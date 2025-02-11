package ru.aston.shellsorter.service;

public interface Service {
    void randomGeneratedFill(int length);

    void fromFileFill(int length);

    void manualFill(int length);

    void sort();

    void sortByField(String field);

    String getSortedField();

    boolean isSorted();
}
