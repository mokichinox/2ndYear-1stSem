package SkipList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UseIntSkipList {

    private IntSkipList[] skipLists;

    public UseIntSkipList() {
        skipLists = new IntSkipList[4];
        // Initialize SkipLists with different max levels
        skipLists[0] = new IntSkipList(4);
        skipLists[1] = new IntSkipList(5);
        skipLists[2] = new IntSkipList(6);
        skipLists[3] = new IntSkipList(7);
    }

    // Load data from file and insert into the skip lists
    public void loadData() {
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\avdbraulio\\Documents\\DSA\\src\\SkipList\\data"));
            while (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                for (IntSkipList skipList : skipLists) {
                    skipList.skipListInsert(val);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found!");
        }
    }

    // Search for values from searchvalue.txt and display nodes traversed
    public void searchVal() {
        int searchVal, nodesTravs;

        // For each max level, perform the search and print the results
        for (int x = 0; x < skipLists.length; x++) {
            System.out.println("USING " + (x + 4) + " AS MAX LEVEL");
            System.out.println("--------------------");

            try {
                Scanner scanner = new Scanner(new File("C:\\Users\\avdbraulio\\Documents\\DSA\\src\\SkipList\\searchvalue"));
                while (scanner.hasNextInt()) {
                    searchVal = scanner.nextInt();
                    nodesTravs = skipLists[x].skipListSearch(searchVal);

                    if (nodesTravs > 0) {
                        System.out.println(searchVal + " found using " + nodesTravs + " comparisons");
                    } else {
                        System.out.println(searchVal + " not found using " + Math.abs(nodesTravs) + " comparisons");
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("file not found!");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        UseIntSkipList exer = new UseIntSkipList();

        // Load data into the skip lists
        exer.loadData();

        // Search for values and report nodes traversed
        exer.searchVal();
    }
}
