package ru.aston.shellsorter.utils.fileloader;

import ru.aston.shellsorter.model.Book;

import static ru.aston.shellsorter.utils.fileloader.Fileloader.isNumeric;

public class BookCreator implements CreateObject {
    @Override
    public boolean match(String[] words) {
        return words.length == 3 && !isNumeric(words[0]) && !isNumeric(words[1]) && isNumeric(words[2]);
    }

    @Override
    public Object create(String[] data) {
        return new Book.Builder()
                .setAuthor(data[0])
                .setTitle(data[1])
                .setPages(Integer.parseInt(data[2].trim()))
                .build();
    }
}
