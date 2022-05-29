package ua.com.javarash.bratashenko.сaesar;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWork {

    public ArrayList<Character> fileToCollection(FileReader reader,
                                                 ArrayList<Character> list) throws IOException {
        int character;

        while ((character = reader.read()) != -1) {
            list.add((char)character);
        }
        System.out.println("Данные успешно считаны с файла " + reader + " и записаны в коллекцию " + list);
        return list;
    }

    public void collectionToFile(ArrayList<Character> list, FileWriter writer) throws IOException {
        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i));
        }
        System.out.println("Данные успешно считаны с коллекции " + list + "и записаны в файл " + writer);
    }
}
