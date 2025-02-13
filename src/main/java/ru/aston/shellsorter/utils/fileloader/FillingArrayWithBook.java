package ru.aston.shellsorter.utils.fileloader;

import java.io.File;
import java.io.IOException;

import ru.aston.shellsorter.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FillingArrayWithBook {
    private FillingArrayWithBook() {
        throw new UnsupportedOperationException("Utility class.");
    }
    
    public static Book[] buildBookArrayFromJson(int length) {
        try {
            if (length < 0) {
                throw new IllegalArgumentException("Array length must be non-negative.");
            }

            ObjectMapper objectMapper = new ObjectMapper();
            
            String fileName = FillingArrayWithBook.class.getClassLoader().getResource("inputdata/book.json").getPath();
            
            Book[] booksInJson = objectMapper.readValue(new File(fileName), Book[].class);

            if (length > booksInJson.length) {
                throw new IllegalArgumentException("Requested length exceeds available data.");
            }

            Book[] booksInArray = new Book[length];

            for (int i = 0; i < length; i++) {
                String author = booksInJson[i].getAuthor();  
                String title = booksInJson[i].getTitle();   
                int pages = booksInJson[i].getPages();     

                booksInArray[i] = new Book.Builder()
                        .setAuthor(author)
                        .setTitle(title)
                        .setPages(pages)
                        .build();
            }
            
            return booksInArray;
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return new Book[0];  
        }
    }
}