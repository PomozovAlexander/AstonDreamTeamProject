package ru.aston.shellsorter.utils.fileloader;

import ru.aston.shellsorter.model.Car;

import static ru.aston.shellsorter.utils.fileloader.Fileloader.isNumeric;

public class CarCreator implements CreateObject {
    @Override
    public boolean match(String[] words) {
        return words.length == 3 && isNumeric(words[0]) && !isNumeric(words[1]) && isNumeric(words[2]);
    }

    @Override
    public Object create(String[] data) {
        return new Car.Builder()
                .setPower(Integer.parseInt(data[0].trim()))
                .setModel(data[1])
                .setProductionYear(Integer.parseInt(data[2].trim()))
                .build();
    }
}
