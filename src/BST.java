import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Jared Saal
 * @version: Dec 11 2024
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // Returns true if number is in tree and false if number isn't
        return searchHelper(root, val);
    }

    public boolean searchHelper(BSTNode root, int val) {
        // If the end of the branch is reached, return false
        if (root == null) {
            return false;
        }
        // If the root is equal to the value, return true!
        else if (val == root.getVal()) {
            return true;
        }
        // Case 1: Value is less than root - go to left child
        else if (val < root.getVal()) {
            return searchHelper(root.getLeft(), val);
        }
        // Case 2: Value is more than root - go to right child
        else {
            return searchHelper(root.getRight(), val);
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // Initialize arraylist of nodes
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        // Inputs 2 for inorder traversal and returns final arraylist in order
        return traversalHelper(nodes, root, 2);
    }

    public ArrayList<BSTNode> traversalHelper(ArrayList<BSTNode> list, BSTNode root, int orderType) {
        // If the current root is null, exit back to the previous node
        if (root == null) {
            return list;
        }
        // In preorder case (when orderType is 1) add the root before the left and right
        if (orderType == 1) {
            list.add(root);
        }
        traversalHelper(list, root.getLeft(), orderType);
        // In inorder case (when orderType is 2) add the root between the left and right
        if (orderType == 2) {
            list.add(root);
        }
        traversalHelper(list, root.getRight(), orderType);
        // In postorder case (orderType a is 3) add the root after the left and right
        if (orderType == 3) {
            list.add(root);
        }
        return list;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // Initialize arraylist of nodes
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        // Inputs 1 for preorder traversal and returns final arraylist in preorder
        return traversalHelper(nodes, root, 1);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // Initialize array of nodes
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        // Inputs 3 for postorder traversal and returns final arraylist in postorder
        return traversalHelper(nodes, root, 3);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // if tree is empty, add node
        if (root == null) {
            root = new BSTNode(val);
        }
        // Otherwise, traverse and insert
        else {
            rootHelper(root, val);
        }
    }

    public void rootHelper(BSTNode root, int val) {
        if (val < root.getVal()) {
            // If val is less than root and no left child, add node with value val
            if (root.getLeft() == null) {
                root.setLeft(new BSTNode(val));
            }
            // If val is less than root and has a child, go down and left
            else {
                rootHelper(root.getLeft(), val);
            }
        }
        if (val > root.getVal()) {
            // If val is greater than root and no right child, add node with value val
            if (root.getRight() == null) {
                root.setRight(new BSTNode(val));
            }
            // If val is greater than root and has a child, go down and right
            else {
                rootHelper(root.getRight(), val);
            }
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
