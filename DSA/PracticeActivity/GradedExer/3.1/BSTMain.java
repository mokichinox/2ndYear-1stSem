import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BSTMain {
    public static void main(String[] args) {
        BST bst = new BST();

        try (Scanner i = new Scanner(new File("bst.txt"))) {
            while (i.hasNextInt()) {
                int data = i.nextInt();
                bst.insert(data);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: bst.txt");
            return;
        }
        
        System.out.println("---------------------------------------------------------");
        System.out.println("Breadth-First Traversal:");
        System.out.println("---------------------------------------------------------");
        bst.breadthFirst();
        System.out.println("---------------------------------------------------------");
        System.out.println("Pre-order Depth-First Traversal:");
        System.out.println("---------------------------------------------------------");
        bst.preorder();
        System.out.println("---------------------------------------------------------");

        System.out.println("In-order Depth-First Traversal:");
        System.out.println("---------------------------------------------------------");
        bst.inorder();
        System.out.println("---------------------------------------------------------");

        System.out.println("Post-order Depth-First Traversal: ");
        System.out.println("---------------------------------------------------------");
        bst.postorder();
        System.out.println("---------------------------------------------------------");

        System.out.println("Number of leaves: " + bst.countLeaves());
        System.out.println("---------------------------------------------------------");
        System.out.println("Height of the tree: " + bst.height());
        System.out.println("---------------------------------------------------------");
    }

     
}
