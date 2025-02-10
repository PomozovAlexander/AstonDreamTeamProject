package ru.aston.shellsorter.strategy;

/**
 * Функциональный интерфейс для обработки строк файла и преобразования в объекты.
 * @param <T> тип объекта
 */
@FunctionalInterface
public interface FileParser<T> {
    T parse(String line);
}
