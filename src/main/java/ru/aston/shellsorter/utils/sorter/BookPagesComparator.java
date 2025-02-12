package ru.aston.shellsorter.utils.sorter;

import ru.aston.shellsorter.model.Book;

import java.util.Comparator;

public class BookPagesComparator implements Comparator<Book> {


    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPages() - o2.getPages();
    }
}
