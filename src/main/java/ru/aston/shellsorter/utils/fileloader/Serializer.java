package ru.aston.shellsorter.utils.fileloader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static ru.aston.shellsorter.utils.fileloader.Fileloader.FILE_PATH;

public class Serializer  {
    public static void serializeObjects(Object[] objects) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(objects);
            System.out.println("Массив объектов успешно сохранен в файл: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении объектов: " + e.getMessage());
        }
    }
}
