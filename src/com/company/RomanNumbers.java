package com.company;

import java.util.ArrayList;
import java.util.List;

public class RomanNumbers {
    static List<String> listNumbers = new ArrayList<>(100);
    static {
        listNumbers.add("0");
        try {
            for (int i = 1; i <= 100; i++) {
                if (i <= 10)
                    listNumbers.add(conv09(i));
                else if (10 < i && i < 40)
                    listNumbers.add(conv30(i) + conv09(i % 10));
                else if (40 <= i && i < 50)
                    listNumbers.add("XL" + conv09(i % 10));
                else if (i >= 50 && i < 90)
                    listNumbers.add("L" + conv30(i - 50) + conv09(i % 10));
                else if (i >= 90 && i < 100)
                    listNumbers.add("XC" + conv09(i % 10));
                else if (i == 100)
                    listNumbers.add("C");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean testCorrectRome(String x) {
        boolean errorRome = true;
        for(int i = 1; i <= 100; i++) {
            if (x.equals(listNumbers.get(i))) errorRome = false;
        }
        return errorRome;
    }

    public static int romeToArab(String str) {
        int x=-1;
        for (int i = 1; i <=100; i++) {
            if (str.equals(listNumbers.get(i)))
                x = i;
        }
        return x;
    }

    public static String arabToRome (int n) {
        return listNumbers.get(n);
    }

    private static String conv30(int d) throws Exception {
        String c="";
        for (int i = 1; i <= d/10; i++) {
            c = c + "X";
        }
        return c;
    }
    private static String conv09(int i) throws Exception{
        String c="";
        switch (i) {
            case 1:
                c = "I";
                break;
            case 2:
                c = "II";
                break;
            case 3:
                c = "III";
                break;
            case 4:
                c = "IV";
                break;
            case 5:
                c = "V";
                break;
            case 6:
                c = "VI";
                break;
            case 7:
                c = "VII";
                break;
            case 8:
                c = "VIII";
                break;
            case 9:
                c = "IX";
                break;
            case 10:
                c = "X";
                break;
        }
        return c;
    }
}

