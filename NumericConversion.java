import java.util.Scanner;

// an extra comment

public class NumericConversion {

    // Method names and descriptions taken from Lab Assignment page.

    public static long hexStringDecode(String hex) {  // Decodes an entire hexadecimal string and returns its value.
        long conversionResult = 0;

        for (int i = hex.length() - 1; i >= 0; i--) { // For loop runs through each character in the string

            int digit = hexCharDecode(hex.charAt(i));

            conversionResult = (long) (conversionResult + (digit * Math.pow(16, (hex.length() - 1) - i)));
                                                          // Same as earlier expression, instead using digit obtained from letter
        }
        return conversionResult;
    }

    public static short hexCharDecode(char digit) {  // Decodes a single hexadecimal digit and returns its value.
        short conversionResult = 0;

        // If the character is a digit, the following branch evaluates:
        if (Character.isDigit(digit)) {
            conversionResult = (short) Character.getNumericValue(digit);
        }

        // If the character is a digit, the following branch evaluates:
        else if (Character.isLetter(digit)) {
            digit = Character.toLowerCase(digit);
            switch (digit) {                      // The letter determines the value of the digit
                case 'a':
                    digit = 10;
                    break;
                case 'b':
                    digit = 11;
                    break;
                case 'c':
                    digit = 12;
                    break;
                case 'd':
                    digit = 13;
                    break;
                case 'e':
                    digit = 14;
                    break;
                case 'f':
                    digit = 15;
                    break;
                default:
                    digit = 0;
                    break;
            }
            conversionResult = (short) digit;  // The digit is then converted to the correct data type and returned
        }

        return conversionResult;
    }

   public static short binaryStringDecode(String binary) {  // Decodes a binary string and returns its value.
        short conversionResult = 0;

        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                conversionResult = (short) (conversionResult + Math.pow(2, (binary.length() - 1) - i));
            }
        }

        return conversionResult;
   }

   public static String binaryToHex (String binary) {
        // Decodes a binary string, re-encodes it as hexadecimal, and returns the hexadecimal string.

       int decimalNum = binaryStringDecode(binary);
       // At this point, the binary number has ben converted into base ten.

       // It will now be broken own into hexadecimal:
       String conversionResult = "";
       int temp = decimalNum;
       while (temp != 0) {
           temp = temp % 16;
           conversionResult = conversionResult + temp;
       }
       return conversionResult;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int menuChoice = 1;
        String stringToConvert;

        while (menuChoice != 4) {

            System.out.println("Decoding Menu");
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit" + "\n");

            System.out.print("Please enter an option: ");
            menuChoice = scnr.nextInt();

            if (menuChoice == 4) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.print("Please enter the numeric string to convert: ");
            stringToConvert = scnr.next();

            if (menuChoice == 1) {
                if (stringToConvert.length() > 1) {
                    System.out.println("Result: " + hexStringDecode(stringToConvert));
                }
                else {
                    char charToConvert = stringToConvert.charAt(0);
                    System.out.println("Result: " + hexCharDecode(charToConvert));
                }
            }

            else if (menuChoice == 2) {
                System.out.println("Result: " + binaryStringDecode(stringToConvert));
            }

           else if (menuChoice == 3) {
                String conversionResult = binaryToHex(stringToConvert);
                System.out.println("Result: " + conversionResult);
            }
        }
    }
}
