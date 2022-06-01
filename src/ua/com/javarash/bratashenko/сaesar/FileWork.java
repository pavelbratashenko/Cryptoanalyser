package ua.com.javarash.bratashenko.сaesar;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWork {

    public static ArrayList<Character> fileToCollection(FileReader reader,
                                                        ArrayList<Character> list) {

        try {
            int character;
            while ((character = reader.read()) != -1) {
                list.add((char) character);
            }
        } catch (IOException e) {
            System.out.println("Не правильно введен путь к файлу " + e);
            System.exit(1);
        }
        return list;
    }

    public static void collectionToFile(ArrayList<Character> list, FileWriter writer) {
        try {
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i));
            }
        } catch (IOException e) {
            System.out.println("Не правильно введен путь к файлу " + e);
            System.exit(1);
        }
    }
}
