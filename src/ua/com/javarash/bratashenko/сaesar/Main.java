package ua.com.javarash.bratashenko.сaesar;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static ua.com.javarash.bratashenko.сaesar.Cipher.*;
import static ua.com.javarash.bratashenko.сaesar.BruteForce.*;
import static ua.com.javarash.bratashenko.сaesar.FileWork.*;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Character> charListIn = new ArrayList<>();
        ArrayList<Character> charListOut = new ArrayList<>();
        ArrayList<Character> test = new ArrayList<>();


        FileReader reader = null;
        FileWriter writer = null;


        try {
            fileToCollection(reader = new FileReader("C:\\Users\\brata\\Desktop\\qq.txt"), charListIn);
        } catch (IOException e) {
            System.err.println("Некорректное имя файла или путь" + e);
        }finally {
            reader.close();
        }

        shift(charListIn, 3, charListOut);

        try {
            collectionToFile(charListOut, writer = new FileWriter("C:\\Users\\brata\\Desktop\\qq1.txt"));
        } catch (IOException e) {
            System.err.println("Некорректное имя файла или путь" + e);
        } finally {
            writer.close();
        }

        shiftBack(charListOut, 3, test);
    }
}

