import java.io.BufferedReader; // File reading
import java.io.FileReader; // File reading
import java.io.IOException; // Handling file errors

public class VedadKruhoHashTableMain {
    public static void main(String[] args) {
        VedadKruhoHashTable hashTable = new VedadKruhoHashTable(100); // Max capacity of hash table

        try (BufferedReader br = new BufferedReader(new FileReader("hashtable.txt"))) { // Try to read file
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split line into words
                for (String word : words) {
                    if (hashTable.containsString(word)) { // If word is already in hash table
                        hashTable.increment(word); // Increment value
                    } else {
                        hashTable.select(word, 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print error message
        }

        hashTable.printTable();
    }
}