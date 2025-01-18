import java.io.*;
import java.util.*;

public class BSTMain {
    
    public static void main(String[] args) throws IOException {

        BST bst = new BST();
        Scanner i = new Scanner(new File("bst.txt"));
        while (i.hasNextLine()) {
            String line = i.nextLine().trim();
            bst.insert(Integer.parseInt(line));
        }
        
        i.close();

        Scanner is = new Scanner(new File("search.txt"));
        
        while (is.hasNextLine()) {
            String line = is.nextLine().trim();
            int searchValue = Integer.parseInt(line);
            BSTNode node = bst.search(searchValue);
            
            if (node != null) {
                bst.moveToRoot(searchValue);
            }
        }
        
        is.close();

        
        double averagePathLength = bst.averagePathLength();
        System.out.println("MOVE-TO-ROOT");
        System.out.println("-------------------------------------------");
        System.out.println("Average Path Length: " + averagePathLength);
        System.out.println("-------------------------------------------");

        // Rebuild BST for splaying
        bst = new BST();
        
        i = new Scanner(new File("bst.txt"));
        while (i.hasNextLine()) {
            String line = i.nextLine().trim();
            bst.insert(Integer.parseInt(line));
        }
        
        i.close();

        
        is = new Scanner(new File("search.txt"));
        while (is.hasNextLine()) {
            
            String line = is.nextLine().trim();
            int searchValue = Integer.parseInt(line);
            BSTNode node = bst.search(searchValue);
            
            if (node != null) {
                bst.splay(searchValue);
            }
            
        }
        
        is.close();

        
        averagePathLength = bst.averagePathLength();
        System.out.println("SPLAYING");
        System.out.println("-------------------------------------------");
        System.out.println("Average Path Length: " + averagePathLength);
        System.out.println("-------------------------------------------");
    }
}
