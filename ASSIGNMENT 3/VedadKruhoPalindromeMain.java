import java.util.List;
import java.util.Scanner;

public class VedadKruhoPalindromeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter a string of lowercase characters:");
            String input = scanner.nextLine();

            // Case 1: Any string s that will list all palindrome partitions
            System.out.println("All palindromic partitions:");
            List<List<String>> partitions = VedadKruhoPalindromePartition.partition(input);
            printPartitions(partitions);

            // Case 2: Palindromic partitions with each palindrome at least 3 characters long
            System.out.println("Palindromic partitions with each palindrome at least 3 characters long:");
            List<List<String>> partitionsWithMinLength = VedadKruhoPalindromePartition.partitionWithMinLength(input, 3);
            printPartitions(partitionsWithMinLength);

            // Case 3: Palindromic partitions with at most 2 partitions
            System.out.println("Palindromic partitions with at most 2 partitions:");
            List<List<String>> partitionsWithMaxPartitions = VedadKruhoPalindromePartition.partitionWithMaxPartitions(input, 2);
            printPartitions(partitionsWithMaxPartitions);
        } finally {
            scanner.close();
        }
    }

    // Method to print the list of partitions
    private static void printPartitions(List<List<String>> partitions) {
        for (List<String> partition : partitions) {
            System.out.println(partition);
        }
    }
}
