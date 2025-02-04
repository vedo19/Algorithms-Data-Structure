import java.util.Scanner;

public class VedadKruhoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a string of lowercase characters (DO NOT PRESS SPACE --> HAS ASCII VALUE (32) AS WELL !!!):");
            String input = scanner.nextLine();
            char[] array = input.toCharArray();

            System.out.println("Original array:");
            printArray(array);

            VedadKruhoQuickSort.quickSort(array, 0, array.length - 1);

            System.out.println("Sorted array:");
            printArray(array);
        } finally {
            scanner.close();
        }
    }

    // Method to print the array
    private static void printArray(char[] array) {
        for (char c : array) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}