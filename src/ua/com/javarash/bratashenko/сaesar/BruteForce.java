package ua.com.javarash.bratashenko.сaesar;

import static ua.com.javarash.bratashenko.сaesar.Cipher.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BruteForce {

    public void bruteForce(ArrayList<Character> list, FileWriter writer) throws IOException {

        for (int i = 0; i < ALPHABET.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                list.add(ALPHABET.get(ALPHABET.indexOf(list.get(j)) + i));
            }
            for (int k = 0; k < list.size(); k++) {
                writer.write(list.get(k));
            }
        }
        System.out.println("Все варианты записаны в файл " + writer + " выберите из предложенных вариантов");
    }
}
