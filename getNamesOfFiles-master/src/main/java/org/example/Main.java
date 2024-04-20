package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        InputClass inputClass = new InputClass();
//        inputClass.setAdress();
        String path = inputClass.getAdress(); //"C:\\Users\\newcomp\\Pictures\\1\\";
        Work work = new Work();
        work.runWork(path);
        Proverka proverka = new Proverka();
        proverka.runProverka();
//        work.setPath("C:\\Users\\newcomp\\Pictures\\1\\");
//        String path = "C:\\Users\\newcomp\\Pictures\\1\\";
//        InputClass inputClass = new InputClass();
//        inputClass.runInputClass();
//        System.out.println(inputClass.list);

        for (int i = 0; i < work.listPath.size(); i++) {
            System.out.println(i + " " + work.listPath.get(i));
            System.out.println(" Из названия-" + ": " + work.listPairDimentions.get(i));
            System.out.println("    Реальный-" + ": " + work.listPairRealDimensions.get(i));
            System.out.println();
        }

        /*for (Map.Entry<String, Boolean> entry : proverka.mapResultProberka.entrySet()) {
            String key = entry.getKey();
            Boolean value = entry.getValue();
            if (value == true) {
                System.out.println(ANSI_GREEN + key + ": " + value);
            } else {
                System.out.println(ANSI_RED + key + ": " + value);
            }
        }*/


        try (FileWriter writer = new FileWriter("result.txt")) {
            for (Map.Entry<String, Boolean> entry : proverka.mapResultProberka.entrySet()) {
                String key = entry.getKey();
                Boolean value = entry.getValue();

                if (value == true) {
                    System.out.println(ANSI_GREEN + key + ": " + value);
                    writer.write(key + ": " + value + "\n");
                } else {
                    System.out.println(ANSI_RED + key + ": " + value);
                    writer.write(key + ": " + value.toString().toUpperCase() + " !!!\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
