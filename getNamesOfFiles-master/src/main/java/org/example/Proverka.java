package org.example;

import java.util.HashMap;
import java.util.Map;


public class Proverka {
    public String name = null;
    public boolean resultProverka = false;
    public Map<String, Boolean> mapResultProberka = new HashMap<>();
    //"C:\\Users\\newcomp\\Pictures\\1\\";
    public void runProverka() {
        InputClass inputClass = new InputClass();
        String path = inputClass.getAdress();
        Work work = new Work();
        work.runWork(path);

        for (int i = 0; i < work.listName.size(); i++) {
            int wName = work.listPairDimentions.get(i).w;
            int hName = work.listPairDimentions.get(i).h;
            int wReal = work.listPairRealDimensions.get(i).w;
            int hReal = work.listPairRealDimensions.get(i).h;

            if ((wName == wReal && hName == hReal) || (wName == hReal && hName == wReal)) {
                name = work.listName.get(i).toString();
                resultProverka = true;
                mapResultProberka.put(name, resultProverka);
            } else {
                name = work.listName.get(i).toString();
                resultProverka = false;
                mapResultProberka.put(name, resultProverka);
            }
        }
    }
}
