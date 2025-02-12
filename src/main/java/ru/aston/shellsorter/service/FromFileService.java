package ru.aston.shellsorter.service;

import java.util.Arrays;

import static ru.aston.shellsorter.utils.fileloader.Fileloader.makeObjectsFromFile;

public class FromFileService {
    private Object[] array;

    public void fromFileFill(int length) {
        array = makeObjectsFromFile(length);
        System.out.println(Arrays.toString(array));
    }
}
