public class VedadKruhoHashTable {
    private static class Node { // Node class to represent entry in hash table
        String key; // Word
        int value; // Count of occurrences
        Node next; // Pointer to next key/node in chain

        Node(String key, int value) { // Constructor
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] table; // Array to store hash table
    private int size; // Number of elements in hash table

    public VedadKruhoHashTable(int capacity) { // Constructor to initialize hash table with capacity
        table = new Node[capacity];
        size = 0;
    }

    private int hash(String key) { // Hash function to determine index of key in hash table
        return Math.abs(key.hashCode()) % table.length;
    }

    public void select(String key, int value) { // Method to insert/update key/value pair in hash table
        int index = hash(key.toLowerCase()); // Determine index of key
        Node newNode = new Node(key.toLowerCase(), value); // Create new node with key/value pair
        if (table[index] == null) { // If no node at index, insert new node
            table[index] = newNode;
            size++;
        } else { // If there is collision
            Node current = table[index]; // Traverse chain to find key
            while (current != null) {
                if (current.key.equals(key.toLowerCase())) { // If key already exists, update value
                    current.value = value;
                    return;
                }
                if (current.next == null) { // If we reach end of the chain
                    current.next = newNode; // Insert new node at the end
                    size++;
                    break;
                }
                current = current.next; // Move to next node in chain
            }
        }
    }

    public int getString(String key) { // Method to get value associated with key in hash table
        int index = hash(key.toLowerCase()); // Compute index of key
        Node current = table[index]; // Traverse chain at index
        while (current != null) {
            if (current.key.equals(key.toLowerCase())) { // If key is found
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public boolean containsString(String key) { // Method to check if key is in hash table
        int index = hash(key.toLowerCase()); // Compute iondex for tje key
        Node current = table[index]; // Traverse chain at index
        while (current != null) {
            if (current.key.equals(key.toLowerCase())) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void increment(String key) { // Method to incerement value associated with a key
        int index = hash(key.toLowerCase());
        Node current = table[index];
        while (current != null) {
            if (current.key.equals(key.toLowerCase())) {
                current.value++;
                return;
            }
            current = current.next;
        }
        select(key, 1); // If key is not found, insert key with value 1
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) { // Itterate over each index through table
            Node current = table[i]; // Node at current index
            while (current != null) {
                System.out.println(current.key + ": " + current.value);
                current = current.next;
            }
        }
    }

    public int size() { // Method to return number of elements in hash table
        return size;
    }
}