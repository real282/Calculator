package com.company;

public class MathAction {

    public static void action(String[] array) throws Exception {
        int a = 0;
        int b = 0;
        int result = 0;
        boolean romeNumber = false;
        try {
            a = Integer.parseInt(array[0]);
            b = Integer.parseInt(array[2]);
        }
        catch (Exception e) {
            romeNumber = true;
            a = RomanNumbers.romeToArab(array[0]);
            b = RomanNumbers.romeToArab(array[2]);
        }
        if (a <= 0 || a > 10 || b <= 0 || b > 10) throw new InvalidInputDataExeption("Incorrect entry of argument values");
        switch (array[1]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;;
                break;
            case "*":
                result = a * b;;
                break;
            case "/":
                result = a / b;;
                break;
        }

        if(romeNumber && result == 0) throw new InvalidInputDataExeption("Zero is missing in Roman numbers");
        if(romeNumber) System.out.println(RomanNumbers.arabToRome(result));
        else System.out.println(result);
    }
}
