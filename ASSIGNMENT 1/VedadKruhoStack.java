public class VedadKruhoStack {
    private int[] array; // Array to store elements of all stacks
    private int sizeArray; // Total array size
    private int stackSize; // Size of each stack
    private int[] topIndex;  // Array to store top index of each stack

    public VedadKruhoStack(int size) { // Constructor to initialize array size and stack sizes
        this.sizeArray = size; 
        this.stackSize = size / 4; // All equal in size
        this.array = new int[size];
        this.topIndex = new int[]{-1, size / 2, size / 2 - 1, size};
        // Stack 1 - top at -1 (before the first element)
        // Stack 2 - top at size/2 (middle of array)
        // Stack 3 - top as size/2 - 1 (middle - 1)
        // Stack 4 - top starts at size (end of array)
    }

    // Push methods for each stack

    public void pushStack1(int value) {
        if (topIndex[0] < stackSize - 1) { // If stack 1 is not full
            array[++topIndex[0]] = value; // Increment index and add value to stack
        } else {
            System.out.println("Overflow in Stack 1");
        }
    }

    public void pushStack2(int value) {
        if (topIndex[1] > stackSize) { // If stack 2 is not full
            array[--topIndex[1]] = value; // Decrement top index and add value to stack
        } else {
            System.out.println("Overflow in Stack 2");
        }
    }

    public void pushStack3(int value) {
        if (topIndex[2] < sizeArray * 3 / 4 - 1) { // If stack 3 is not full
            array[++topIndex[2]] = value; // Same principle as stack 1
        } else {
            System.out.println("Overflow in Stack 3");
        }
    }

    public void pushStack4(int value) {
        if (topIndex[3] > sizeArray * 3 / 4) { // If stack 4 is not full
            array[--topIndex[3]] = value; // Same principle as stack 2
        } else {
            System.out.println("Overflow in Stack 4");
        }
    }

    // Pop methods for each stack
    
    public int popStack1() {
        if (topIndex[0] >= 0) { // Check if stack 1 is not empty
            return array[topIndex[0]--]; // Return top value and decrement top index
        } else {
            System.out.println("Underflow in Stack 1");
            return -1;
        }
    }

    public int popStack2() {
        if (topIndex[1] < sizeArray / 2) { // Check if Stack 2 is not empty
            return array[topIndex[1]++]; // Return top value and increment top index
        } else {
            System.out.println("Stack 2 Underflow");
            return -1;
        }
    }

    public int popStack3() {
        if (topIndex[2] >= sizeArray / 2) { // Check if stack 3 is not empty
            return array[topIndex[2]--]; // Same principle as stack 1
        } else {
            System.out.println("Stack 3 Underflow");
            return -1;
        }
    }

    public int popStack4() {
        if (topIndex[3] < sizeArray) { // Check if stack 4 is not empty
            return array[topIndex[3]++]; // Same principle as stack 2
        } else {
            System.out.println("Stack 4 Underflow");
            return -1;
        }
    }

    // Method for displaying content of entire array
    public void displayArray() {
        for (int i = 0; i < sizeArray; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}