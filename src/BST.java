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
        // Initialize array of nodes
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        // Returns the final array in order
        return inOrderHelper(nodes, root);
    }

    public ArrayList<BSTNode> inOrderHelper(ArrayList<BSTNode> list, BSTNode root) {
        // If current root is null, return the list
        if (root == null) {
            return list;
        }
        // If root has no children, add the root to list
        if (root.getLeft() == null && root.getRight() == null) {
            list.add(root);
            return list;
        }
        // In order - left child, root, right child
        inOrderHelper(list, root.getLeft());
        list.add(root);
        inOrderHelper(list, root.getRight());
        return list;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // Initialize array of nodes
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        // Returns the final array in preOrder
        return preOrderHelper(nodes, root);
    }

    public ArrayList<BSTNode> preOrderHelper(ArrayList<BSTNode> list, BSTNode root) {
        // If root has no childre, add root
        if (root.getLeft() == null && root.getRight() == null) {
            list.add(root);
            return list;
        }
        // In preorder: root, left child, right child
        list.add(root);
        preOrderHelper(list, root.getLeft());
        preOrderHelper(list, root.getRight());
        return list;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // Initialize array of nodes
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        // Returns arraylist in postOrder
        return postOrderHelper(nodes, root);
    }

    public ArrayList<BSTNode> postOrderHelper(ArrayList<BSTNode> list, BSTNode root) {
        // If root has no childre, add to list
        if (root.getLeft() == null && root.getRight() == null) {
            list.add(root);
            return list;
        }
        // In postOrder - left, right, root
        postOrderHelper(list, root.getLeft());
        postOrderHelper(list, root.getRight());
        list.add(root);
        return list;
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
