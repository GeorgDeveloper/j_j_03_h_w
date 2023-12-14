package org.example;

import java.io.*;
import java.util.UUID;


public class Homework {

     private static String fileName;

    public static String getFileName() {
        return fileName;
    }

    // Метод для сохранения объекта в файл
    public static void saveObjectToFile(Serializable object) {
        fileName = object.getClass().getName() + "_" + UUID.randomUUID().toString() + ".bin";

        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(object);
            System.out.println("Объект успешно сохранен в файл: " + fileName);

        } catch (IOException e) {
            System.out.println("Ошибка при сохранении объекта в файл: " + e.getMessage());
        }
    }

    // Метод для загрузки объекта из файла и его удаления
    public static Object loadObjectFromFileAndDelete(String fileName) {
        Object object = null;

        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            object = objectIn.readObject();
            System.out.println("Объект успешно загружен из файла: " + fileName);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Ошибка при загрузке объекта из файла: " + e.getMessage());
        }

        // Удаление файла после загрузки объекта
        if (object != null) {
            File fileToDelete = new File(fileName);
            if (fileToDelete.exists()) {
                if (fileToDelete.delete()) {
                    System.out.println("Файл успешно удален: " + fileName);
                } else {
                    System.out.println("Не удалось удалить файл: " + fileName);
                }
            }
        }
        return object;
    }

}
