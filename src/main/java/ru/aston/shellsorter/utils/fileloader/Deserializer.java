package ru.aston.shellsorter.utils.fileloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

import static ru.aston.shellsorter.utils.fileloader.Fileloader.FILE_PATH;

public class Deserializer {
    public static Object[] deserializeObjects(int size) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            Object[] allObjects = (Object[]) in.readObject();
            return Arrays.copyOf(allObjects, Math.min(size, allObjects.length));
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке объектов: " + e.getMessage());
            return new Object[0];
        }
    }
}
