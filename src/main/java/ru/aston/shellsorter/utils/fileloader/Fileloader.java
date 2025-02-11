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
        for (String string: fromFile) {
            String[] words = string.trim().split("[,\\s]+");
            if (newArr.size() == size) {
                break;
            }
            else {
                newArr.add(makeObject(words));
            }
        }
        return newArr.toArray();
    }

    public static Object makeObject(String[] strings) {
        if (isNumeric(strings[0]) && isNumeric(strings[2])) {
            return new Car.Builder().setPower(Integer.parseInt(strings[0])).
                    setModel(strings[1]).
                    setProductionYear(Integer.parseInt(strings[2])).
                    build();
        } else if (!isNumeric(strings[0]) && isNumeric(strings[1])) {
            return new RootVegetable.Builder().setType(strings[0]).
                    setWeight(Integer.parseInt(strings[1])).
                    setColor(strings[2]).
                    build();
        } else {
            return new Book.Builder().setAuthor(strings[0]).
                    setTitle(strings[1]).
                    setPages(Integer.parseInt(strings[2])).
                    build();
        }
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
        try {
            Integer.parseInt(str.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
