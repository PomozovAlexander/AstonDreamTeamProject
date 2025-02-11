package ru.aston.shellsorter.utils.fileloader;

import ru.aston.shellsorter.model.Book;
import ru.aston.shellsorter.model.Car;
import ru.aston.shellsorter.model.RootVegetable;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Fileloader {

    public static Object[] makeObjectsFromFile(int size, String path) {
        List<Object> newArr = new ArrayList<>();
        List<String> fromFile = loadFromFile(path);
        for (String string : fromFile) {
            if (newArr.size() == size) break;
            String[] words = string.trim().split("[,\\s]+");
            if (words.length < 3) {
                System.err.println("Ошибка: недостаточно данных в строке -> " + string);
                continue;
            }
            try {
                newArr.add(ObjectFactory.makeObject(words));
            } catch (Exception e) {
                System.err.println("Ошибка при создании объекта: " + e.getMessage());
            }
        }
        return newArr.toArray();
    }

    public static List<String> loadFromFile(String filePath) {
        List<String> arr = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(filePath))) {
            while (scanner.hasNextLine()) {
                String parts = scanner.nextLine();
                if (!parts.trim().isEmpty()) {
                    arr.add(parts);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return arr;
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.trim().isEmpty()) return false;
        try {
            Integer.parseInt(str.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
