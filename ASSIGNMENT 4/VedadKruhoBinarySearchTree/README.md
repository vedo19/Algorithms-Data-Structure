# VedadKruhoBinarySearchTree

This project implements a binary search tree (BST) in Java. It provides functionalities to insert nodes, find paths to a target value, find the next greater element, and perform recursive traversals (inorder, preorder, postorder). Additionally, it compares the arrays generated from these traversals to identify matching elements at the same indices.

## Project Structure

```
VedadKruhoBinarySearchTree
├── src
│   ├── VedadKruhoBinarySearch.java  # Contains the BST implementation
│   └── VedadKruhoMain.java           # Entry point for the application
├── .gitignore                         # Specifies files to ignore in version control
└── README.md                          # Documentation for the project
```

## Features

- **Insert Nodes**: Add values to the binary search tree while maintaining the BST properties.
- **Find Paths**: Print all paths from the root to the nodes containing the target value.
- **Next Greater Element**: Find the next greater element of a specified target value in the BST.
- **Tree Traversals**: Perform recursive traversals (inorder, preorder, postorder) of the tree.
- **Array Comparison**: Compare the results of the traversals and identify matching elements at the same indices.

## Usage

1. Compile the Java files in the `src` directory.
2. Run the `VedadKruhoMain` class to start the application.
3. Input the list of numbers to create the binary search tree and specify the target value when prompted.

## Example

### Input
```
Enter numbers (space-separated): 5 3 7 2 4 6 8
Enter target value: 3
```

### Output
```
Paths to target value 3:
- 5-3-2
- 5-3-4
Next greater element of target value 3 is: 4
Preorder Traversal: 5, 3, 2, 4, 7, 6, 8
Postorder Traversal: 2, 4, 3, 6, 8, 7, 5
Inorder Traversal: 2, 3, 4, 5, 6, 7, 8
Matches between traversals:
- Preorder and Inorder: Match at indices 1 and 6 - elements 3 and 8
- Inorder and Postorder: Match at indices 0 and 5 - elements 2 and 7
```

## Requirements

- Java Development Kit (JDK) installed on your machine.
- No external libraries are required; the project uses standard Java collections and features.

## License

This project is open-source and available for modification and distribution under the MIT License.