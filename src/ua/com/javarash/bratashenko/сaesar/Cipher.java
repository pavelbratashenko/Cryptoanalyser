package ua.com.javarash.bratashenko.сaesar;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ua.com.javarash.bratashenko.сaesar.FileWork.*;

public class Cipher {
    public static final List<Character> ALPHABET = Arrays.asList('a', 'b', 'c',
            'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z', '.', ',', '«', '»', ':', '!', '?', ' ');
    public static final int ALPHABET_SIZE = ALPHABET.size();

    public static ArrayList<Character> shift(ArrayList<Character> listI, int key,
                                             ArrayList<Character> listO) {
        for (int i = 0; i < listI.size(); i++) {
            listO.add(ALPHABET.get((ALPHABET.indexOf(listI.get(i)) + key) % ALPHABET_SIZE));
        }
        return listO;
    }

    public static ArrayList<Character> shiftBack(ArrayList<Character> listI, int key,
                                                 ArrayList<Character> listO) {
        for (int i = 0; i < listI.size(); i++) {
            listO.add(ALPHABET.get((ALPHABET.indexOf(listI.get(i)) - key) % ALPHABET_SIZE));
        }
        return listO;
    }
    public static void bruteForce(ArrayList<Character> list, FileWriter writer) throws IOException {
        for (int i = 0; i < ALPHABET.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                list.add(ALPHABET.get(ALPHABET.indexOf(list.get(j)) + i));
            }
            collectionToFile(list, writer);
        }
    }
}
