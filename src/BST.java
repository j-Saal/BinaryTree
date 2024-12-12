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
        // TODO: Complete the search function
        return searchHelper(root, val);
    }

    public boolean searchHelper(BSTNode root, int val) {
        if (root == null) {
            return false;
        }
        if (val == root.getVal()) {
            return true;
        }
        if (val < root.getVal()) {
            return searchHelper(root.getLeft(), val);
        }
        else {
            return searchHelper(root.getRight(), val);
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        inOrderHelper(nodes, root);
        return nodes;
    }

    public ArrayList<BSTNode> inOrderHelper(ArrayList<BSTNode> list, BSTNode root) {
        if (root == null) {
            return list;
        }
        if (root.getLeft() == null && root.getRight() == null) {
            list.add(root);
            return list;
        }
        inOrderHelper(list, root.getLeft());
        list.add(root);
        inOrderHelper(list, root.getRight());
        return list;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        preOrderHelper(nodes, root);
        return nodes;
    }

    public ArrayList<BSTNode> preOrderHelper(ArrayList<BSTNode> list, BSTNode root) {
        if (root.getLeft() == null && root.getRight() == null) {
            list.add(root);
            return list;
        }
        list.add(root);
        preOrderHelper(list, root.getLeft());
        preOrderHelper(list, root.getRight());
        return list;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> nodes = new ArrayList<BSTNode>();
        postOrderHelper(nodes, root);
        return nodes;
    }

    public ArrayList<BSTNode> postOrderHelper(ArrayList<BSTNode> list, BSTNode root) {
        if (root.getLeft() == null && root.getRight() == null) {
            list.add(root);
            return list;
        }
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
        // TODO: Complete insert
        if (root == null) {
            root = new BSTNode(val);
        }
        else {
            rootHelper(root, val);
        }
    }

    public void rootHelper(BSTNode root, int val) {
        if (val < root.getVal()) {
            if (root.getLeft() == null) {
                root.setLeft(new BSTNode(val));
            }
            else {
                rootHelper(root.getLeft(), val);
            }
        }
        if (val > root.getVal()) {
            if (root.getRight() == null) {
                root.setRight(new BSTNode(val));
            }
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
