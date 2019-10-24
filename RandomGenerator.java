package com.comarch.mateusz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj zakres liczb oraz liczbe generowanych liczb wg formatu [zakres min;zakres max;liczba generowanych liczb]:");
        String inputStr = scan.nextLine();
        new InputData(inputStr);
    }

    private static class InputData {
        private float zakresMin;
        private float zakresMax;
        private int liczbaGenerowanycLiczb;

        public InputData(String inputStr) throws Exception {
            String[] input = inputStr.split(" ");

            if (input.length == 3) {
                try {
                    zakresMin = Float.parseFloat(input[0]);
                    zakresMax = Float.parseFloat(input[1]);
                    liczbaGenerowanycLiczb = Integer.parseInt(input[2]);
                } catch (Exception e) {
                    throw new Exception("Wrong input");
                }
            } else
                throw new Exception("Wrong input");
            System.out.println("Generowanie dla " + this.toString());
            System.out.println("Wygenerowane liczby:");
            System.out.println(generuj());
            System.out.println("------------------------------------------------");
        }

        private String generuj() throws Exception {
            List<Float> randomNumbers = new ArrayList<>();
            float dlugoscPrzedzialu = zakresMax - zakresMin;
            if(dlugoscPrzedzialu < 0) throw new Exception("Wrong input");

            Random rnd = new Random();

            for (int i = 0; i < liczbaGenerowanycLiczb; i++) {
                randomNumbers.add(rnd.nextFloat() * dlugoscPrzedzialu + zakresMin);
            }
            return randomNumbers.toString()
                    .replaceAll("[\\[\\]]", "")
                    .replaceAll(",","\n")
                    .replaceAll(" ", "");
        }

        @Override public String toString() {
            return "zakresMin= " + zakresMin + ", zakresMax= " + zakresMax + ", liczbaGenerowanycLiczb= "
                    + liczbaGenerowanycLiczb;
        }
    }
}
