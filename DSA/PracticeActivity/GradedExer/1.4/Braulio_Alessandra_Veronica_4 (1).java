package SinglyLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Braulio_Alessandra_Veronica_4 {
    public static void main(String[] args) {
        IntSLList list = new IntSLList();

        try {
            // Reading from the numbers.txt file
            Scanner in = new Scanner(new File("src/SinglyLinkedList/numbers"));
            int numToAddHead, numToAddTail, delValue;

            while (in.hasNextLine()) {
                String line = in.nextLine();

                switch (line) {
                    case "a": // Add to head
                        if (in.hasNextLine()) {
                            numToAddHead = Integer.parseInt(in.nextLine());
                            list.addToHead(numToAddHead);
                        }
                        break;
                    case "b": // Add to tail
                        if (in.hasNextLine()) {
                            numToAddTail = Integer.parseInt(in.nextLine());
                            list.addToTail(numToAddTail);
                        }
                        break;
                    case "c": // Delete from head
                        if (!list.isEmpty()){
                            delValue = list.deleteFromHead();
                            System.out.println(delValue + " was deleted from the head");
                        } else{
                            System.out.println("Linked list is empty");
                        }
                        break;
                    case "d": // Delete from tail
                        if (!list.isEmpty()){
                            delValue = list.deleteFromTail();
                            System.out.println(delValue + " was deleted from the tail");
                        } else {
                            System.out.println("Linked list is empty");
                        }
                        break;
                    case "e": // Delete a specific number
                        if (in.hasNextLine()) {
                            delValue = Integer.parseInt(in.nextLine());
                            if (!list.isEmpty()){
                                if (list.isInList(delValue)) {
                                    list.delete(delValue);
                                    System.out.println(delValue + " was deleted");
                                } else {
                                    System.out.println("Value not found");
                                }
                            } else {
                                System.out.println("Linked list is empty");
                            }

                        }
                        break;
                    default:
                        System.out.println("Invalid command");
                        break;
                }
            }

            System.out.println("Final linked list:");
            list.printAll();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
