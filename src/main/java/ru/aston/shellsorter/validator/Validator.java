package ru.aston.shellsorter.validator;

public interface Validator<T> {
    Boolean validate(T t);
}
