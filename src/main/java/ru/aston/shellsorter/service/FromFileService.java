package ru.aston.shellsorter.service;

import java.util.Arrays;
import java.util.Objects;

import static ru.aston.shellsorter.utils.fileloader.Fileloader.makeObjectsFromFile;

public class FromFileService {
    private Object[] array;

    public void fromFileFill(int length, String path) {
        array = makeObjectsFromFile(length,path);
        System.out.println(Arrays.toString(array));
    }
}
