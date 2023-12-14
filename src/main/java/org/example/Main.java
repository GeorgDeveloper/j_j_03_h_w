package org.example;

import static org.example.Homework.*;

public class Main {
    public static void main(String[] args) {
        saveObjectToFile(new Person("Georg", 30));
        String filePath = getFileName();
        Object loadedObject = loadObjectFromFileAndDelete(filePath);
        if (loadedObject != null) {
            System.out.println("Загруженный объект: " + loadedObject);
        }
    }

}