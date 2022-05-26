package ua.com.javarash.bratashenko.сaesar;

import javax.crypto.Cipher;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<Character> charListIn = new ArrayList<>();
        ArrayList<Character> charListOut = new ArrayList<>();


        try (FileReader reader = new FileReader("in.txt");
             FileWriter writer = new FileWriter("out.txt");) {
        } catch (IOException e) {
            System.err.println("Некорректное имя файла или путь" + e);
        }








    }
}

