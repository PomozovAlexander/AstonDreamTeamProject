package ru.aston.shellsorter.utils.fileloader;

import java.util.List;

public class ObjectFactory {
    private static final List<CreateObject> CREATORS = List.of(
            new BookCreator(),
            new CarCreator(),
            new RootVegetableCreator()
    );
    public static Object makeObject(String[] data) {
        return CREATORS.stream()
                .filter(creator -> creator.match(data)).findFirst()
                .map(creator -> creator.create(data)).orElseThrow(() -> new IllegalArgumentException(
                        "Не удалось определить тип объекта: " + String.join(", ", data)
                ));
    }
}
