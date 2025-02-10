package ru.aston.shellsorter.strategy;
public interface ArrayStrategySelect<T> {
    /**
     * Метод для выбора и формирования массива данных.
     * @return массив объектов типа T
     */
    T[] selectArray();
}
