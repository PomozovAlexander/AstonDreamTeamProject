package ru.aston.shellsorter.utils.fileloader;

import java.util.Scanner;

public class Fileloader {
    protected static final String FILE_PATH = "src/main/java/ru/aston/shellsorter/Objects.data";
    public static Object[] makeObjectsFromFile(int size) {
//         Если делать красиво, то часть интерфейса конечно же можно вынести в main, если нет времени,
//         то можно всё оставить так. В любом случае, этот код работает. Единственный случай, когд возникает ошибка -
//         это когда мы пытаемся сделать десериализацию из файла, которого не существует(он удалён)

        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите действие: " +
                "\n1 - Сериализация данных " +
                "\n2 - Десериализация данных " +
                "\nВвод: ");


        int number = scanner.nextInt();
        Object[] newObjects;


        if (number == 1) {
            newObjects = RandomObjectGenerator.generateAndSaveObjects(size);
            Serializer.serializeObjects(newObjects);
        } else if (number == 2) {
            newObjects = Deserializer.deserializeObjects(size);
        } else {
            System.out.println("Некорректный ввод! Используется сериализация по умолчанию.");
            newObjects = RandomObjectGenerator.generateAndSaveObjects(size);
            Serializer.serializeObjects(newObjects);
        }
        return newObjects;
    }
}
