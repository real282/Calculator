package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String strLine = "";
            String[] arrayInpatData = new String[3];
            while (true) {
                strLine = bufferedReader.readLine();
                strLine = strLine.replaceAll("\\s", "");
                Pattern pattern = Pattern.compile("[+\\-*/]");
                Matcher matcher = pattern.matcher(strLine);

                while (!(matcher.find())) {
                    throw new InvalidInputDataExeption("Invalid input math operation");
                }

                arrayInpatData[0] = strLine.substring(0, matcher.end() - 1);
                arrayInpatData[1] = strLine.substring(matcher.end() - 1, matcher.end());
                arrayInpatData[2] = strLine.substring(matcher.end());

                if (RomanNumbers.testCorrectRome(arrayInpatData[0]) ^ RomanNumbers.testCorrectRome(arrayInpatData[2]))
                    throw new InvalidInputDataExeption("Invalid input");

                MathAction.action(arrayInpatData);

            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
