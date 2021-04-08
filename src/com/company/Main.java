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
            String[] arrayInputData = new String[3];
            while (true) {
                strLine = bufferedReader.readLine();
                strLine = strLine.replaceAll("\\s", "");
                Pattern pattern = Pattern.compile("[+\\-*/]");
                Matcher matcher = pattern.matcher(strLine);

                while (!(matcher.find())) {
                    throw new InvalidInputDataExeption("Invalid input math operation");
                }

                arrayInputData[0] = strLine.substring(0, matcher.end() - 1);
                arrayInputData[1] = strLine.substring(matcher.end() - 1, matcher.end());
                arrayInputData[2] = strLine.substring(matcher.end());

                if (RomanNumbers.testCorrectRome(arrayInputData[0]) ^ RomanNumbers.testCorrectRome(arrayInputData[2]))
                    throw new InvalidInputDataExeption("Invalid input");

                MathAction.action(arrayInputData);

            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
