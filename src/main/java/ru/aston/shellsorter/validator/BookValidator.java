package ru.aston.shellsorter.validator;

import ru.aston.shellsorter.model.Book;

public class BookValidator implements Validator<Book>{
    @Override
    public Boolean validate(Book book) {
        if (book.getAuthor().isEmpty()) {   
            throw new IllegalArgumentException("Author name must not be empty");
        }       
        if (book.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        if (book.getPages() <= 0) {
            throw new IllegalArgumentException("Number of pages must be greater than 0");
        }
        return true;
    }
}
