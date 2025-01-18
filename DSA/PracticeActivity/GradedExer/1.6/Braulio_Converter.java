package Converter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Braulio_Converter {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

       try{
           System.out.println("Enter a decimal number:");
           int userInput = in.nextInt();
           System.out.println("Enter a target base between 2-9:");
           int baseInput;
           // Loop until the user provides a valid base within the range [2, 9]
           while(true){
               baseInput = in.nextInt();

               if (baseInput < 10 && baseInput > 1) {
                   break; // Exit the loop if the input is valid
               } else {
                   System.out.print("Invalid input. Please enter a base between 2-9: ");
               }
           }

           if (userInput == 0)
               System.out.print("The binary equivalent of " + userInput + " is: 0");
           else
               convertDecimalToBase(userInput, baseInput, stack);

       } catch (InputMismatchException e) {
           System.out.print("Invalid input. Please enter a valid value: "); // Handle invalid input (e.g., non-integer values)
           in.next();   // Consume the invalid input to avoid an infinite loop
       }


    }

    private static void convertDecimalToBase(int userInput, int baseInput, Stack<Integer> stack) {
        int ogInput = userInput; // Store the original input for display purposes

        // Perform the conversion by repeatedly dividing the number by the base
        while (userInput != 0) {
            int remainder = userInput % baseInput;
            stack.push(remainder); // Push the remainder onto the stack
            userInput /= baseInput; // Update the number for the next iteration
        }


        System.out.print("The binary equivalent of " + ogInput+ " is: ");
        // Pop and print each remainder from the stack to get the correct order
        while (!stack.isEmpty()) {
            int absOutput = Math.abs(stack.pop());
            System.out.print(absOutput); // Print the top value from the stack
        }
        System.out.println();  // Move to the next line after printing the result
    }
}
