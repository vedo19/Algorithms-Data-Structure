public class VedadKruhoBinarySearch {
    private class Node { // Represent each node/value in a binary tree
        int value; // Value of node
        Node left, right; // Pointers to the nodes, left and right child nodes

        Node(int value) { // Constructor for node
            this.value = value;
            left = right = null;
        }
    }

    private Node root; // Root of binary search tree

    public void insert(int value) { // Method to insert value into binary search tree
        root = insertRecursive(root, value); // Call recursive method to insert value
    }

    private Node insertRecursive(Node root, int value) { // Recursive method to insert value into binary search tree
        if (root == null) { // If tree is empty, root is null
            root = new Node(value); // Create new node with value
            return root;
        }
        if (value < root.value) { // If value is less than root value
            root.left = insertRecursive(root.left, value); // Insert value into left subtree
        } else if (value > root.value) { // If value is greater than root value
            root.right = insertRecursive(root.right, value); // Insert value into right subtree
        }
        return root;
    }

    public void PathsToTarget(int target) { // Method to print all paths to target value
        printPathsRecursive(root, target, ""); // Call recursive method to print paths
    }

    private void printPathsRecursive(Node node, int target, String path) { // Recursive method to print paths to target value
        if (node == null) {
            return;
        }
        path += node.value + "-"; // Add current node value to path
        if (node.value == target) { // If current node value is target value
            printLeafPaths(node, path); // Print all paths to leaf nodes
        }
        printPathsRecursive(node.left, target, path); // Reursively call method for left subtree
        printPathsRecursive(node.right, target, path); // Recursively call method for right subtree
    }

    private void printLeafPaths(Node node, String path) { // Method to print paths from target to leaf nodes
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) { // If current node is leaf node
            System.out.println(path.substring(0, path.length() - 1)); // Remove last character from path and print
        }
        if (node.left != null) { // If left child node exists
            printLeafPaths(node.left, path + node.left.value + "-");
        }
        if (node.right != null) { // If right child node exists
            printLeafPaths(node.right, path + node.right.value + "-");
        }
    }

    public int findNextGreater(int target) { // Method to find next greater element of target value
        Node nextGreater = findNextGreaterRecursive(root, target, null); // Call recursive method to find next greater element
        return nextGreater != null ? nextGreater.value : -1; // Return next greater element if found, otherwise -1
    }

    private Node findNextGreaterRecursive(Node node, int target, Node successor) { // Recursive method to find next greater element
        if (node == null) { // If node is null
            return successor; // Return successor node
        }
        if (node.value > target) {
            successor = node;
            return findNextGreaterRecursive(node.left, target, successor);
        } else { // If node value is less than or equal to target value, recursively call method for right subtree
            return findNextGreaterRecursive(node.right, target, successor);
        }
    }

    public int[] preorderTraversal() { // Method to return preorder traversal of binary search tree, root-left-right
        int[] result = new int[countNodes(root)]; // Create array to store traversal
        preorderRecursive(root, result, new int[]{0}); // Call recursive method to traverse tree
        return result;
    }

    private void preorderRecursive(Node node, int[] result, int[] index) { // Recursive method to traverse tree in preorder
        if (node == null) {
            return;
        }
        result[index[0]++] = node.value; // Add current node value to result array
        preorderRecursive(node.left, result, index); // Recursively call method for left subtree
        preorderRecursive(node.right, result, index); // Recursively call method for right subtree
    }

    public int[] inorderTraversal() { // Method to return inorder traversal of binary search tree, left-root-right
        int[] result = new int[countNodes(root)]; // Create array to store traversal
        inorderRecursive(root, result, new int[]{0}); // Call recursive method to traverse tree
        return result;
    }

    private void inorderRecursive(Node node, int[] result, int[] index) { // Recursive method to traverse tree in inorder
        if (node == null) {
            return;
        }
        inorderRecursive(node.left, result, index); // Recursively call method for left subtree
        result[index[0]++] = node.value; // Add current node value to result array
        inorderRecursive(node.right, result, index); // Recursively call method for right subtree
    }

    public int[] postorderTraversal() { // Method to return postorder traversal of binary search tree, left-right-root
        int[] result = new int[countNodes(root)]; // Create array to store traversal
        postorderRecursive(root, result, new int[]{0}); // Call recursive method to traverse tree
        return result;
    }

    private void postorderRecursive(Node node, int[] result, int[] index) { // Recursive method to traverse tree in postorder
        if (node == null) {
            return;
        }
        postorderRecursive(node.left, result, index); // Recursively call method for left subtree
        postorderRecursive(node.right, result, index); // Recursively call method for right subtree
        result[index[0]++] = node.value; // Add current node value to result array
    }

    private int countNodes(Node node) { // Method to count number of nodes in binary search tree
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right); // Count nodes in left and right subtrees
    }
}