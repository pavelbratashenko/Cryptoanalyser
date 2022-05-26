package ua.com.javarash.bratashenko.сaesar;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cipher {
    public final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');
    public final int ALPHABET_SIZE = ALPHABET.size();
    public ArrayList<Character> fileToCollection(FileReader reader,
                                                 ArrayList<Character> list) throws IOException {
        int charaster;

        while ((charaster = reader.read()) != -1) {
            list.add((char)charaster);
        }
        return list;
    }
    public ArrayList<Character> shift(ArrayList<Character> listI, int key, ArrayList<Character> listO) {
        for (int i = 0; i < listI.size(); i++) {
            listO.add(ALPHABET.get(ALPHABET.indexOf(listI.get(i)) + key % ALPHABET_SIZE));
        }
        return listO;
    }

    public void collectionToFile(ArrayList<Character> list, FileWriter writer) throws IOException {
        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i));
        }
    }
}
