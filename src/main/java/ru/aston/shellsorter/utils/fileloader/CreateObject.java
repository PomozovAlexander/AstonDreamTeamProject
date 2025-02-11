package ru.aston.shellsorter.utils.fileloader;

public interface CreateObject {
    boolean match(String[] words);
    Object create(String[] data);
}
