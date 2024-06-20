package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputClass {
    List<String> list = new ArrayList<>();
    public void runInputClass() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = reader.readLine()) != null && line.length() != 0){
                list.add(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    String vvod = null;
    FileReader fileReader = null;
    String adress = null;

    public void setAdress() {
        try (FileWriter writer = new FileWriter("adress.txt")) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Введите путь к папке с файлами:");
                vvod = reader.readLine();
                StringBuilder stringBuilder = new StringBuilder(vvod);
                vvod = stringBuilder.append("\\").toString();
                writer.write(vvod);
                System.out.println(vvod);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
    public String getAdress(){
        try {
            fileReader = new FileReader("adress.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            adress = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adress;
    }
}


