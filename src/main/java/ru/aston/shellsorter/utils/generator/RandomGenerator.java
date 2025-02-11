package ru.aston.shellsorter.utils.generator;

/**
 * Interface for random object generator.
 *
 * @param <T> type of generated object.
 */
public interface RandomGenerator<T> {

    /**
     * Generates a random object of type T.
     *
     * @return the generated object.
     */
    T generate();

    T[] generateArray(int length);
}
