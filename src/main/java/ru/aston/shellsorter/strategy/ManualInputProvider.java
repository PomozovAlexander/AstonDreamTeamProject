package ru.aston.shellsorter.strategy;

import java.util.Scanner;
/**
 * Функциональный интерфейс для обработки ввода объектов пользователем.
 * @param <T> тип объекта
 */
@FunctionalInterface
public interface ManualInputProvider <T> {
    T getInput(Scanner scanner);
}
