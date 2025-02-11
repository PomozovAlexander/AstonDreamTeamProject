package ru.aston.shellsorter.service;

import ru.aston.shellsorter.model.Book;
import ru.aston.shellsorter.utils.generator.BookRandomGenerator;

import java.util.Arrays;
import java.util.Random;

public class BookService implements Service {
    private Book[] array;

    @Override
    public void randomGeneratedFill(int length) {
        array = new BookRandomGenerator(new Random()).generateArray(length);
        System.out.println(Arrays.toString(array));
    }

    @Override
    public void fromFileFill(int length) {

    }

    @Override
    public void manualFill(int length) {

    }
}
