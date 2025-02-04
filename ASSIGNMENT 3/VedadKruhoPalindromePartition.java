import java.util.ArrayList;
import java.util.List;

public class VedadKruhoPalindromePartition {

    // Method to find all palindromic partitions
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    // Helper method for backtracking to find all palindromic partitions
    private static void backtrack(String s, int start, List<String> currentList, List<List<String>> result) {
        if (start >= s.length()) { // If we reach the end of the string, add the current list to the result
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) { // If the substring is a palindrome, add it to the current list
                currentList.add(s.substring(start, end + 1));
                backtrack(s, end + 1, currentList, result); // Recursively call backtrack on the remaining string
                currentList.remove(currentList.size() - 1); // Remove the last element to backtrack
            }
        }
    }

    // Method to check if a substring is a palindrome
    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    // Method to find all palindromic partitions with each palindrome at least 3 characters long
    public static List<List<String>> partitionWithMinLength(String s, int minLength) {
        List<List<String>> result = new ArrayList<>();
        backtrackWithMinLength(s, 0, new ArrayList<>(), result, minLength);
        return result;
    }

    // Helper method for backtracking with minimum length constraint
    private static void backtrackWithMinLength(String s, int start, List<String> currentList, List<List<String>> result, int minLength) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int end = start; end < s.length(); end++) { // Try to partition the string from the current start position to the end
            if (isPalindrome(s, start, end) && (end - start + 1) >= minLength) { // If the substring is a palindrome and has at least minLength characters
                currentList.add(s.substring(start, end + 1));
                backtrackWithMinLength(s, end + 1, currentList, result, minLength); // Recursively call backtrack on the remaining string
                currentList.remove(currentList.size() - 1); // Remove the last element to backtrack
            }
        }
    }

    // Method to find all palindromic partitions with at most 2 partitions
    public static List<List<String>> partitionWithMaxPartitions(String s, int maxPartitions) {
        List<List<String>> result = new ArrayList<>();
        backtrackWithMaxPartitions(s, 0, new ArrayList<>(), result, maxPartitions);
        return result;
    }

    // Helper method for backtracking with maximum partitions constraint
    private static void backtrackWithMaxPartitions(String s, int start, List<String> currentList, List<List<String>> result, int maxPartitions) {
        if (start >= s.length() && currentList.size() <= maxPartitions) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                currentList.add(s.substring(start, end + 1));
                backtrackWithMaxPartitions(s, end + 1, currentList, result, maxPartitions);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}