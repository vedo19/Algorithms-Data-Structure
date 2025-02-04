public class VedadKruhoQuickSort {

    // Method for performing QuickSort
    public static void quickSort(char[] array, int low, int high) {
        if (low < high) { 
            int pivotIndex = partition(array, low, high); // Partitioning index
            System.out.println("Pivot element is: " + array[pivotIndex]); // Print pivot element and array
            printArray(array);
            quickSort(array, low, pivotIndex - 1); // Recursive call on the left of pivot
            quickSort(array, pivotIndex + 1, high); // Recursive call on the right of pivot
        }
    }

    // Method to partition the array and find the pivot index
    private static int partition(char[] array, int low, int high) {
        int pivotIndex = selectPivot(array, low, high); // Select pivot
        char pivotValue = array[pivotIndex];
        swap(array, pivotIndex, high); // Move pivot to end of subarray
        int storeIndexValue = low;

        for (int i = low; i < high; i++) { // Itterate through subarray and rearrange elements
            if (array[i] < pivotValue) {
                swap(array, i, storeIndexValue); // Swap elements so that elements less than pivot are on the left
                storeIndexValue++;
            }
        }
        swap(array, storeIndexValue, high); // Move pivot to its final place
        return storeIndexValue;
    }

    // Method to select the pivot element
    private static int selectPivot(char[] array, int low, int high) {
        int sum = 0;
        for (int i = low; i <= high; i++) { // Calculate the sum of ASCII values
            sum += (int) array[i];
        }
        int average = sum / (high - low + 1); // Calculate the average ASCII value
        int floorValue = (int) Math.floor(average); // Calculate the floor value
        int pivotIndex = floorValue % (high - low + 1) + low; // Calculate the pivot index using modulo

        // Print detailed pivot calculation
        System.out.println("Array size: " + (high - low + 1));
        System.out.print("ASCII values: ");
        for (int i = low; i <= high; i++) {
            System.out.print((int) array[i] + " ");
        }
        System.out.println("\nSum of ASCII values: " + sum);
        System.out.println("Average ASCII: " + average);
        System.out.println("Floor value: " + floorValue);
        System.out.println("Pivot index: " + pivotIndex);

        return pivotIndex;
    }

    // Method to swap two elements in the array
    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Method to print the array
    private static void printArray(char[] array) {
        for (char c : array) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}