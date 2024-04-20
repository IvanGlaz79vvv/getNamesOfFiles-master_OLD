package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Work {
    IntPair intPair;
    int resultWidht;
    double wDouble = 0;
    double hDouble = 0;
    String path;// = "C:\\Users\\newcomp\\Pictures\\";
    File[] arrayFiles;
    public List<String> listDimentions = new ArrayList<>();
    public List<IntPair> listPairDimentions = new ArrayList<>();
    public List<IntPair> listPairRealDimensions = new ArrayList<>();
    List<String> listName = new ArrayList<>();
    List<String> listPath = new ArrayList<>();

    public void runWork(String path) {
        File directory = new File(path);
        //Сохраняем пути в массив arrayFiles
        arrayFiles = directory.listFiles();

        for (File s : arrayFiles) {
            String name = s.getName().toString();

            Pattern patternRus = Pattern.compile("[0-9]+х[0-9]+");
            Pattern patternEng = Pattern.compile("[0-9]+x[0-9]+");

            Matcher matcherRus = patternRus.matcher(name);
            Matcher matcherEng = patternEng.matcher(name);

            if (matcherRus.find()) {
                int index = name.lastIndexOf(".");
                String nameSub = name.substring(0, index);
                String sizeRus = matcherRus.group(0);
                listDimentions.add(sizeRus);
                listName.add(name);
                String patFile = path + name;
                listPath.add(patFile);

            }
            if (matcherEng.find()) {
                int index = name.lastIndexOf(".");
                String nameSub = name.substring(0, index);
                String sizeEng = matcherEng.group(0);
                listDimentions.add(sizeEng);
                listName.add(name);
                String patFile = path + name;
                listPath.add(patFile);
            }
        }

        Processor processor = new Processor();

        for (int i = 0; i < listPath.size(); i++) {
//            System.out.println("\n<<<<<<<<<<<<<<>>>>>>>>>>>>");
//            System.out.println("listPath - " + i + ": " + listPath.get(i));
//            System.out.println("Resolution Info: " + processor.run(listPath.get(i)).get("Resolution Info"));
//            System.out.println("Resolution Unit: " + processor.run(listPath.get(i)).get("Resolution Unit"));
//            System.out.println("Image Width: " + processor.run(listPath.get(i)).get("Image Width"));
//            System.out.println("Image Height: " + processor.run(listPath.get(i)).get("Image Height"));

            //Ширина из метаданных
            String tempWidthPixel = processor.run(listPath.get(i)).get("Image Width").toString();
            Pattern patternWidth = Pattern.compile("[0-9]+");
            Matcher matcherWidth = patternWidth.matcher(tempWidthPixel);
            matcherWidth.find();
            String w = matcherWidth.group(0);
            double wDouble = Double.parseDouble(w);
//            System.out.println("wDouble:" + wDouble);

            //Высота из метаданных
            String tempHeightPixel = processor.run(listPath.get(i)).get("Image Height").toString();
            Pattern patternHeight = Pattern.compile("[0-9]+");
            Matcher matcherHeight = patternHeight.matcher(tempHeightPixel);
            matcherHeight.find();
            String h = matcherHeight.group(0);
            double hDouble = Double.parseDouble(h);
//            System.out.println("hDouble:" + hDouble);

            //Ширина из названия
            String tempWidht = listDimentions.get(i);
            int tempIndexW = tempWidht.indexOf("x");
            if (tempIndexW == -1) {
                tempIndexW = tempWidht.indexOf("х");
            }
            int tempWidthResult = (int) Math.round(Double.parseDouble(tempWidht.substring(0, tempIndexW)));
//            System.out.println("Ширина из названия:" + tempWidthResult);

            //Высота из названия
            String tempHeight = listDimentions.get(i);
            int tempIndexH = tempHeight.indexOf("x");
            if (tempIndexH == -1) {
                tempIndexH = tempHeight.indexOf("х");
            }
            int tempHeightResult = (int) Math.round(Double.parseDouble(tempWidht.substring(tempIndexH + 1)));
//            System.out.println("Высота из названия:" + tempHeightResult);

            IntPair intPair1 = new IntPair(tempWidthResult, tempHeightResult);
            listPairDimentions.add(intPair1);

            //Реальная высота
            String tempResolutionHeight = processor.run(listPath.get(i)).get("Resolution Info").toString();
            int tempIndexResolutionH = tempResolutionHeight.indexOf("x");
            if (tempIndexResolutionH == -1) {
                tempIndexResolutionH = tempResolutionHeight.indexOf("х");
            }
            double ResolutionHeightResultDouble = Double.parseDouble(tempResolutionHeight.substring(0, tempIndexResolutionH).replace(",", "."));
            int resultHeight = (int) Math.round(hDouble * 25.4 / ResolutionHeightResultDouble);
//            System.out.println("Реальная высота = " + resultHeight + " мм");

            //Реальная ширина
            String tempResolutionWidht = processor.run(listPath.get(i)).get("Resolution Info").toString().replace(" DPI", "");
            int tempIndexResolutionW = tempResolutionWidht.indexOf("x");
            if (tempIndexResolutionW == -1) {
                tempIndexResolutionW = tempResolutionWidht.indexOf("х");
            }
            double ResolutionWidhttResultDouble = Double.parseDouble(tempResolutionWidht.substring(tempIndexResolutionW + 1).replace(",", "."));
            int resultWidht = (int) Math.round(wDouble * 25.4 / ResolutionWidhttResultDouble);
//            System.out.println("Реальная ширина = " + resultWidht + " мм");

            IntPair intPairReal = new IntPair(resultWidht, resultHeight, wDouble, hDouble);
            listPairRealDimensions.add(intPairReal);
        }
    }
}