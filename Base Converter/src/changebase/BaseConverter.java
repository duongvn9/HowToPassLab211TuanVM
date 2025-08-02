/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package changebase;

import java.math.BigInteger;

/**
 *
 * @author pc
 */
class BaseConverter {

    static String changeBase(int baseInput, int baseOutput, String inputValue) {
        String output = "";
        // check if base input same base output
        if (baseInput == baseOutput) {
            return inputValue;
        }
        // check if base input is 1 and base output is 2
        if (baseInput == 1 && baseOutput == 2) {
            // function change base binary to decimal
            output = binaryToDecimal(inputValue);
        }
        // check if base input is 2 and base output is 1
        else if (baseInput == 2 && baseOutput == 1) {
            // function change base decimal to binary
            output = decimalToBinary(inputValue);
        }
        // check if base input is 3 and base output is 1
        else if (baseInput == 3 && baseOutput == 1) {
            // function change base hexa to binary
            output = hexaToBinary(inputValue);
        }
        // check if base input is 1 and base output is 3
        else if (baseInput == 1 && baseOutput == 3) {
            // function change base binary to hexa
            output = binaryToHexa(inputValue);
        }
        // check if base input is 2 and base output is 3
        else if (baseInput == 2 && baseOutput == 3) {
            // function change base decimal to hexa
            output = decimalToHexa(inputValue);
        }
        // check if base input is 3 and base output is 2
        else if (baseInput == 3 && baseOutput == 2) {
            // function change base hexa to decimal
            output = hexaToDecimal(inputValue);
        }
        return output;
    }

    static void printOutputValue(int baseInput, int baseOutput, String inputValue, String outputValue) {
        String[] format = {"(BIN)", "(DEC)", "(HEX)"};
        System.out.println(inputValue + format[baseInput - 1] + " = " + outputValue + format[baseOutput - 1]);
    }

    static boolean checkFormatByBaseNumber(String input, int baseInput) {
        String binaryFormat = "01";
        String decimalFormat = "0123456789";
        String hexaFormat = "0123456789ABCDEF";
        String numberFormat = "";
        boolean isValid = false;
        // check if base input is binary
        if (baseInput == 1) {
            numberFormat = binaryFormat;
        }
        // check if base input is decimal
        else if (baseInput == 2) {
            numberFormat = decimalFormat;
        }
        // check if base input is hexa
        else if (baseInput == 3) {
            numberFormat = hexaFormat;
        }

        // loop iterate index in string input
        for (int k = 0; k < input.length(); k++) {
            // loop iterate char in number format
            for (int x = 0; x < numberFormat.length(); x++) {
                // print string
                if (input.charAt(k) == numberFormat.charAt(x)) {
                    isValid = true;
                    break;
                } else {
                    isValid = false;
                }
            }
            if (!isValid) {
                System.out.println("Wrong format! Please enter again!");
                // loop iterate char in number format
                for (int k1 = 0; k1 < numberFormat.length(); k1++) {
                    // print string
                    System.out.print(numberFormat.charAt(k1) + ((k1 != numberFormat.length() - 1) ? ", " : "\n"));
                }
                return false;
            }
        }
        return isValid;
    }

    private static String binaryToDecimal(String inputValue) {
        BigInteger output = BigInteger.valueOf(0);
        // loop iterate char in input
        for (int i = 0; i < inputValue.length(); i++) {
            BigInteger char_value = new BigInteger(Character.toString(inputValue.charAt(i)));
            BigInteger index_value = BigInteger.TWO.pow(inputValue.length() - 1 - i);
            output = output.add(char_value.multiply(index_value));
        }
        return output.toString();
    }

    private static String decimalToBinary(String inputValue) {
        String reverseOutput = "";
        String output = "";
        BigInteger divisor = new BigInteger(inputValue);
        BigInteger remainder;
        // Loop until divisor greater than 0
        while (divisor.compareTo(BigInteger.ZERO) == 1) {
            remainder = divisor.divideAndRemainder(BigInteger.TWO)[1];
            divisor = divisor.divideAndRemainder(BigInteger.TWO)[0];
            reverseOutput += remainder.toString();
        }
        // loop iterate char in reverseOutput to reverse
        for (int i = reverseOutput.length() - 1; i >= 0; i--) {
            output += reverseOutput.charAt(i);
        }
        return output;
    }

    private static String decimalToHexa(String inputValue) {
        String reverseOutput = "";
        String output = "";
        BigInteger divisor = new BigInteger(inputValue);
        BigInteger remainder;
        // Loop until divisor greater than 0
        while (divisor.compareTo(BigInteger.ZERO) == 1) {
            remainder = divisor.divideAndRemainder(BigInteger.valueOf(16))[1];
            divisor = divisor.divideAndRemainder(BigInteger.valueOf(16))[0];
            // check if remainder is smaller than 10
            if (remainder.compareTo(BigInteger.TEN) == -1) {
                // get number
                reverseOutput += remainder.toString();
            } else {
                // reverseOutput += (char)(remainder.add(BigInteger.valueOf(55)).intValue());
                BigInteger temp = remainder.add(BigInteger.valueOf(55));
                int ascii = temp.intValue();
                char hexChar = (char) ascii;
                reverseOutput += hexChar;
            }
        }
        // loop iterate char in reverseOutput to reverse
        for (int i = reverseOutput.length() - 1; i >= 0; i--) {
            output += reverseOutput.charAt(i);
        }
        return output;
    }

    private static String hexaToDecimal(String inputValue) {
        BigInteger output = BigInteger.ZERO;
        // loop each char in input value
        for (int i = 0; i < inputValue.length(); i++) {
            // check if each char is digit or not
            BigInteger valueOfChar;
            if (Character.isDigit(inputValue.charAt(i))) {
                valueOfChar = new BigInteger(Character.toString(inputValue.charAt(i)));
            } else {
                // not digit – get ascii to get value 10 - 15
                valueOfChar = BigInteger.valueOf((int)(inputValue.charAt(i)) - 55);
            }
            int expo = inputValue.length() - 1 - i;
            BigInteger index = BigInteger.valueOf(16).pow(expo);
            BigInteger multi = valueOfChar.multiply(index);
            output = output.add(multi);
        }
        return output.toString();
    }

    private static String binaryToHexa(String inputValue) {
        // change binary to decimal
        String decimal = binaryToDecimal(inputValue);
        // change decimal to hexa
        String hexa = decimalToHexa(decimal);
        return hexa;
    }

    private static String hexaToBinary(String inputValue) {
        // to decimal
        String decimal = hexaToDecimal(inputValue);
        // decimal to binary
        String bin = decimalToBinary(decimal);
        return bin;
    }
}
