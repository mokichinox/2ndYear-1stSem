import java.util.Stack;

public class BST {
    private BSTNode root;

    public BST() {
        root = null;
    }

    // Insert a new value into the BST
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private BSTNode insertRec(BSTNode root, int data) {
        if (root == null) {
            root = new BSTNode(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // Search for a value in the BST
    public BSTNode search(int key) {
        return searchRec(root, key);
    }

    private BSTNode searchRec(BSTNode root, int key) {
        if (root == null || root.data == key) {
            return root;
        }
        if (key < root.data) {
            return searchRec(root.left, key);
        }
        return searchRec(root.right, key);
    }

    // Restructure the tree using the move-to-root strategy
    public void moveToRoot(int key) {
        root = moveToRootRec(root, key);
    }

    private BSTNode moveToRootRec(BSTNode root, int key) {
        if (root == null || root.data == key) {
            return root;
        }
        if (key < root.data) {
            root.left = moveToRootRec(root.left, key);
            root = rotateRight(root);
        } else {
            root.right = moveToRootRec(root.right, key);
            root = rotateLeft(root);
        }
        return root;
    }

    // Rotate the tree to the right
    private BSTNode rotateRight(BSTNode root) {
        BSTNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        return newRoot;
    }

    // Rotate the tree to the left
    private BSTNode rotateLeft(BSTNode root) {
        BSTNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        return newRoot;
    }

    // Splay the tree
    public void splay(int key) {
        root = splayRec(root, key);
    }

    private BSTNode splayRec(BSTNode root, int key) {
        if (root == null || root.data == key) {
            return root;
        }

        if (key < root.data) {
            if (root.left == null) return root;

            if (key < root.left.data) {
                root = rotateRight(root);
                root.right = splayRec(root.right, key);
            } else if (key > root.left.data) {
                root.left = rotateLeft(root.left);
                root = rotateRight(root);
                root.right = splayRec(root.right, key);
            }
        } else {
            if (root.right == null) return root;

            if (key > root.right.data) {
                root = rotateLeft(root);
                root.left = splayRec(root.left, key);
            } else if (key < root.right.data) {
                root.right = rotateRight(root.right);
                root = rotateLeft(root);
                root.left = splayRec(root.left, key);
            }
        }
        return root;
    }

    // Compute the average path length of the tree
    public double averagePathLength() {
        int totalNodes = countNodes(root);
        int totalPathLength = calculatePathLength(root, 0);
        return (totalNodes > 0) ? (double) totalPathLength / totalNodes : 0;
    }

    // Count the number of nodes in the tree
    private int countNodes(BSTNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Calculate the total path length of the tree
    private int calculatePathLength(BSTNode root, int depth) {
        if (root == null) return 0;
        return depth + calculatePathLength(root.left, depth + 1) + calculatePathLength(root.right, depth + 1);
    }

    // Print the tree (for debugging purposes)
    public void printTree() {
        printTreeRec(root, "", true);
    }

    private void printTreeRec(BSTNode node, String indent, boolean last) {
        if (node != null) {
            System.out.println(indent + "+- " + node.data);
            indent += last ? "   " : "|  ";
            printTreeRec(node.left, indent, false);
            printTreeRec(node.right, indent, true);
        }
    }
}
