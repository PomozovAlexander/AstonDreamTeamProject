package ru.aston.shellsorter.strategy;

import java.util.Scanner;

public class ManualArraySelectionStrategy <T> implements ArrayStrategySelect <T>{
    private final int size;
    private final ManualInputProvider<T> inputProvider;

    public ManualArraySelectionStrategy(int size, ManualInputProvider <T> inputProvider) {
        this.size = size;
        this.inputProvider = inputProvider;
    }
    @Override
    public T[] selectArray() {
        T[] array = (T[]) new Object[size];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < size; i++) {
            System.out.println("Введите элемент #" + (i + 1) + ":");
            array[i] = inputProvider.getInput(scanner);
        }
        return array;
    }
}
