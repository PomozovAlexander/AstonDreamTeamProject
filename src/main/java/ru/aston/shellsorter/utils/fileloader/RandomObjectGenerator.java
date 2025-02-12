package ru.aston.shellsorter.utils.fileloader;

import ru.aston.shellsorter.utils.generator.BookRandomGenerator;
import ru.aston.shellsorter.utils.generator.CarRandomGenerator;
import ru.aston.shellsorter.utils.generator.RootVegetableRandomGenerator;

import java.util.Random;

public class RandomObjectGenerator {
    private static final Random random = new Random();
    public static Object[] generateAndSaveObjects(int size) {
        int type = random.nextInt(3);
        Object[] generatedObjects;
        switch (type) {
            case 0 -> {
                generatedObjects = new BookRandomGenerator(new Random()).generateArray(size);
            }
            case 1 -> {
                generatedObjects = new CarRandomGenerator(new Random()).generateArray(size);
            }
            case 2 -> {
                generatedObjects = new RootVegetableRandomGenerator(new Random()).generateArray(size);
            }
            default -> throw new IllegalStateException("Ошибка генерации объектов.");
        }
        return generatedObjects;
    }
}
