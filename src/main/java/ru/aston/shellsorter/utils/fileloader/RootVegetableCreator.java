package ru.aston.shellsorter.utils.fileloader;

import ru.aston.shellsorter.model.RootVegetable;

import static ru.aston.shellsorter.utils.fileloader.Fileloader.isNumeric;

public class RootVegetableCreator implements CreateObject {

    @Override
    public boolean match(String[] words) {
        return words.length == 3 && !isNumeric(words[0]) && isNumeric(words[1]) && !isNumeric(words[2]);
    }

    @Override
    public Object create(String[] data) {
        return new RootVegetable.Builder()
                .setType(data[0])
                .setWeight(Integer.parseInt(data[1].trim()))
                .setColor(data[2])
                .build();
    }
}
