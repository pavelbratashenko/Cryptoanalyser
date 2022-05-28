package ua.com.javarash.bratashenko.сaesar;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWork {

    public ArrayList<Character> fileToCollection(FileReader reader,
                                                 ArrayList<Character> list) throws IOException {
        int charaster;

        while ((charaster = reader.read()) != -1) {
            list.add((char)charaster);
        }
        return list;
    }

    public void collectionToFile(ArrayList<Character> list, FileWriter writer) throws IOException {
        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i));

        }
    }

}
