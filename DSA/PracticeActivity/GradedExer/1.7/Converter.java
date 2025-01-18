import java.util.Scanner;
import java.util.*;

public class Converter {
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int decimalVal, baseVal;
        
       while (true) {
            System.out.print("decimal value: ");
            decimalVal = in.nextInt();

            if (decimalVal < 1 || decimalVal > 999) {
                System.out.print("thank you for using the program. bye!");
                break;
            }

            System.out.print("target base: ");
            baseVal = in.nextInt();

            if (baseVal < 2 || baseVal > 16 || baseVal == 10) {
                System.out.println("Base must be between 2 and 16!");
                break;
            }

            String result = recursion(decimalVal, baseVal);

            
            System.out.println("value of " + decimalVal + " in base " + baseVal + " is " + result);
        }
        
        in.close();
    }
    
    public static String recursion(int decimalVal, int baseVal) {
        // Array containing symbols for values 0–15 (supports bases up to 16)
        String[] v = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
                      "A", "B", "C", "D", "E", "F"};

        int remainder = decimalVal % baseVal;  // Find the remainder
        int quotient = decimalVal / baseVal;  // Find the quotient

        // Recursively call with the quotient until it becomes 0
        if (quotient != 0) {
            return recursion(quotient, baseVal) + v[remainder];
        } else {
            return v[remainder];
        }
    }
    
}
