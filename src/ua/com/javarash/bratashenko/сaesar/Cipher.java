package ua.com.javarash.bratashenko.сaesar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cipher {
    public final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');
    public final int ALPHABET_SIZE = ALPHABET.size();

    public ArrayList<Character> shift(ArrayList<Character> listI, int key, ArrayList<Character> listO) {
        for (int i = 0; i < listI.size(); i++) {
            listO.add(ALPHABET.get(ALPHABET.indexOf(listI.get(i)) + key % ALPHABET_SIZE));
        }
        return listO;
    }

    public ArrayList<Character> shiftBack(ArrayList<Character> listI, int key,
                                          ArrayList<Character> listO) {

        for (int i = 0; i < listI.size(); i++) {
            if  ((ALPHABET.get(ALPHABET.indexOf(listI.get(i)) - key) < 0)) {
                int temp = ALPHABET.size() - (ALPHABET.get(ALPHABET.indexOf(listI.get(i)) - key));
                listO.add(ALPHABET.get(temp));
            }else {
                listO.add(ALPHABET.get(ALPHABET.indexOf(listI.get(i)) - key));
            }
        }
        return listO;
    }

}
