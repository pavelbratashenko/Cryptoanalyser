package ua.com.javarash.bratashenko.сaesar;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static ua.com.javarash.bratashenko.сaesar.Cipher.*;
import static ua.com.javarash.bratashenko.сaesar.FileWork.*;


public class Talk {

    private static final String HELLO = "Добрый день. ";
    private static final String BAY = "Выполнено успешно, досвиданья. ";
    private static final String EXIT = "Для выхода из программы введите exit. ";
    private static final String YES_OR_NO = "введите yes или no ";
    private static final String PATH_IN = "Введите полный путь к файлу с содержанием на английском языке. ";
    private static final String PATH_OUT = "Введите полный путь к файлу в который будет произведена запись. ";

    private static ArrayList<Character> charListIn = new ArrayList<>();
    private static ArrayList<Character> charListOut = new ArrayList<>();
    private static ArrayList<Character> overWriting = new ArrayList<>();


    public static void start() throws IOException {
        hello();
        encrypt();
        if (questionYorN()) {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                enterKey();
                int keyIn = scanner.nextInt();

                if ("exit".equalsIgnoreCase(Integer.toString(keyIn))) {
                    System.out.println(BAY);
                    System.exit(0);
                    break;

                } else if (isNumeric(keyIn)) {
                    pathIn();
                    String pathIn = scanner.nextLine();

                    if ("exit".equalsIgnoreCase(pathIn)) {
                        System.out.println(BAY);
                        System.exit(0);

                    } else if (isPath(pathIn)) {
                        fileToCollection(new FileReader(pathIn), charListIn);
                        shift(charListIn, keyIn, charListOut);
                        pathOut();
                        String pathOut = scanner.nextLine();
                        if (isPath(pathOut)) {
                            collectionToFile(charListOut, new FileWriter(pathOut));
                            bay();
                        }
                    }
                }
            }
        } else {
            decrypt();
            if (questionYorN()) {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    enterKey();
                    int keyOut = scanner.nextInt();

                    if ("exit".equalsIgnoreCase(Integer.toString(keyOut))) {
                        System.out.println(BAY);
                        System.exit(0);
                        break;

                    } else if (isNumeric(keyOut)) {
                        pathOut();
                        String pathOut = scanner.nextLine();

                        if ("exit".equalsIgnoreCase(pathOut)) {
                            System.out.println(BAY);
                            System.exit(0);

                        } else if (isPath(pathOut)) {
                            collectionToFile(charListOut, new FileWriter(pathOut));
                            shiftBack(charListOut, keyOut, overWriting);
                            pathOut();
                            String pathForShiftBack = scanner.nextLine();
                            if (isPath(pathForShiftBack)) {
                                collectionToFile(overWriting, new FileWriter(pathForShiftBack));
                                bay();
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean questionYorN() {
        Scanner scanner = new Scanner(System.in);
        boolean yesNo = false;
        String reply = "";

        while (true) {
            reply = scanner.nextLine();
            if ("y".equalsIgnoreCase(reply)) {
                yesNo = true;
                break;
            } else if ("n".equalsIgnoreCase(reply)) {
                yesNo = false;
                break;
            } else if ("exit".equalsIgnoreCase(reply)) {
                System.out.println(BAY);
                System.exit(0);
                break;
            } else {
                System.out.println("Ввод некоррентный " + YES_OR_NO);
            }
        }
        return yesNo;
    }

    private static void hello() {
        System.out.println(HELLO + EXIT);
    }
    private static void encrypt() {
        System.out.println("Вы хотите зашифровать текст? " + YES_OR_NO + EXIT);
    }
    private static void decrypt() {
        System.out.println("Вы хотите расшифровать текст? " + YES_OR_NO + EXIT);
    }
    private static void select() {
        System.out.println("Хотите подобрать ключ к заштфрованному тексту? " + YES_OR_NO + EXIT);
    }
    private static void bay() {
        System.out.println(BAY);
        System.exit(0);
    }
    private static void enterKey() {
        System.out.println("Введите ключ в диапозоне от " + 0 + "до " + ALPHABET_SIZE + EXIT);
    }
    private static void keyErr() {
        System.out.println("Ключ введен неверно");
    }
    private static void pathIn() {
        System.out.println(PATH_IN + EXIT);
    }
    private static void pathOut() {
        System.out.println(PATH_OUT + EXIT);
    }
    private static void pathErr() {
        System.out.println("Неверный путь к файлу, повторно введите абсолюьный путь" + EXIT);
    }

    private static boolean isNumeric(int intValue) {
        if (intValue < 0 && intValue > ALPHABET_SIZE) {
            System.out.println("Число больше диапозона допустимых значений");
            return false;
        } else if (intValue % 1 != 0) {
            System.out.println("Число не является целым");
            return false;
        } else {
            return true;
        }
    }
    private static boolean isPath(String path) {
        File file = new File(path);
        if (file.isAbsolute()) {
            if (file.exists()) {
                return true;
            }
        }
        System.out.println("Путь не является абсолюьтным или строка не является путем");
        return false;
    }

}






