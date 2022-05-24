package ua.com.javarash.bratashenko.сaesar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');
    public static final int ALPHABET_SIZE = ALPHABET.size();

    public static ArrayList<Character> shift(ArrayList<Character> list, int key) {
        ArrayList<Character> charListOut = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            charListOut.add(ALPHABET.get(ALPHABET.indexOf(list.get(i)) + key  % ALPHABET_SIZE));
        }
        return charListOut;
    }


    public static void main(String[] args) {
        ArrayList<Character> charListIn = new ArrayList<>();


        charListIn.add('a');
        charListIn.add('b');
        charListIn.add('b');
        charListIn.add('a');


        System.out.println(shift(charListIn, 3));


    }
}