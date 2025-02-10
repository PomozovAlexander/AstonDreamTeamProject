package ru.aston.shellsorter.strategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileArraySelectionStrategy<T> implements ArrayStrategySelect<T>{
    private final String filePath;
    private final FileParser<T> fileParser;

    public FileArraySelectionStrategy(String filePath, FileParser<T> fileParser) {
        this.filePath = filePath;
        this.fileParser = fileParser;
    }
    @Override
    public T[] selectArray() {
        List<T> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                T item = fileParser.parse(line);
                if (item != null) {
                    list.add(item);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return list.toArray((T[]) new Object[0]);
    }
}
