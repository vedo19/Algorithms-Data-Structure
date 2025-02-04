public class VedadKruhoMain {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.println("Enter numbers for the binary search tree (comma-separated):");
        String input = scanner.nextLine();
        String[] inputNumbers = input.split(","); // Split with comma separator
        int[] numbers = new int[inputNumbers.length]; // Array to store numbers
        
        for (int i = 0; i < inputNumbers.length; i++) { // Convert string numbers to integers
            numbers[i] = Integer.parseInt(inputNumbers[i].trim()); // Trim whitespace and parse integer
        }
        
        VedadKruhoBinarySearch bst = new VedadKruhoBinarySearch(); // Create binary search tree
        
        for (int number : numbers) { // Insert numbers into binary search tree
            bst.insert(number);
        }
        
        System.out.println("Enter target value:");
        int target = scanner.nextInt();
        
        System.out.println("Path(s) to target value " + target + ":");
        bst.PathsToTarget(target);
        
        int nextGreater = bst.findNextGreater(target);
        System.out.println("Next greater element of target value is: " + nextGreater);
        
        System.out.println("Preorder traversal:");
        int[] preorder = bst.preorderTraversal();
        printArray(preorder);
        
        System.out.println("Inorder traversal:");
        int[] inorder = bst.inorderTraversal();
        printArray(inorder);
        
        System.out.println("Postorder traversal:");
        int[] postorder = bst.postorderTraversal();
        printArray(postorder);
        
        System.out.println("Comparing traversals for matching elements:");
        System.out.println("Preorder vs Inorder:");
        compareTraversals(preorder, inorder);
        System.out.println("Preorder vs Postorder:");
        compareTraversals(preorder, postorder);
        System.out.println("Inorder vs Postorder:");
        compareTraversals(inorder, postorder);
        
        scanner.close();
    }
    
    private static void printArray(int[] array) { // Method to print array elements
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    private static void compareTraversals(int[] array1, int[] array2) { // Method to compare two arrays
        System.out.print("Match between arrays: ");
        boolean foundMatch = false;
        for (int i = 0; i < Math.min(array1.length, array2.length); i++) { // Compare elements at same index
            if (array1[i] == array2[i]) {
                System.out.print("Index " + i + " - Element " + array1[i] + " ");
                foundMatch = true;
            }
        }
        if (!foundMatch) { // If no match is found
            System.out.println("No element match at the same index");
        } else {
            System.out.println();
        }
    }
}