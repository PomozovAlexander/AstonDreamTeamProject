package ru.aston.shellsorter.strategy;

import ru.aston.shellsorter.utils.generator.RandomGenerator;

public class RandomArraySelectionStrategy<T> implements ArrayStrategySelect<T> {
    private final RandomGenerator<T> generator;
    private final int size;
    public RandomArraySelectionStrategy(RandomGenerator<T> generator, int size) {
        this.generator = generator;
        this.size = size;
    }
    @Override
    public T[] selectArray() {
        T[] array = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = generator.generate();
        }
        return array;
    }
}
