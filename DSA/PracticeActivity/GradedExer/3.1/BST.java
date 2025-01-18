import java.util.LinkedList;
import java.util.Queue;

public class BST {
    protected BSTNode root;

    public BST() {
        root = null;
    }

    public void insert(int el) {
        root = insertRec(root, el);
    }

    private BSTNode insertRec(BSTNode root, int el) {
        if (root == null) {
            root = new BSTNode(el);
            return root;
        }
        if (el < root.key)
            root.left = insertRec(root.left, el);
        else if (el > root.key)
            root.right = insertRec(root.right, el);
        return root;
    }

    public void breadthFirst() {
        if (root == null) return;

        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BSTNode node = queue.poll();
            System.out.print(node.key + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        System.out.println();
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(BSTNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(BSTNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(BSTNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.key + " ");
        }
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(BSTNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public int height() {
        return height(root);
    }

    private int height(BSTNode node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
