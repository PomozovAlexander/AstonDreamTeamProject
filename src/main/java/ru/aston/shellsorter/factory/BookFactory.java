package ru.aston.shellsorter.factory;

import java.util.Random;

import ru.aston.shellsorter.model.Book;
import ru.aston.shellsorter.utils.generator.BookRandomGenerator;
import ru.aston.shellsorter.utils.generator.RandomGenerator;
import ru.aston.shellsorter.validator.BookValidator;
import ru.aston.shellsorter.validator.Validator;

public class BookFactory implements AbstractFactory<Book>{

    @Override
    public String givesFileTitle() {
        return "Book.txt";
    }

    @Override
    public RandomGenerator<Book> createGenerator(Random random) {
        return new BookRandomGenerator(random);
    }


    @Override
    public Validator<Book> createValidator() {
        return new BookValidator();
    }
}