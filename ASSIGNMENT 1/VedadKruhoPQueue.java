public class VedadKruhoPQueue {
    private char[] queue; // Array for storing elements/letter in the queue
    private int n; // Current size of queue, number of elements in queue

    public VedadKruhoPQueue(int max) { // Max number od letter that can be added to queue
        queue = new char[max];
        n = 0;
    }

    // insert method to add letters/elements in queue
    public void insert(char letter) { // 
        if (n < queue.length) { // If queue is not full
            queue[n] = letter; // Letter added to queue
            n++;
            bubbleSort(); // bubbleSort method called to sort queue after adding new element, immediately after adding new element
        } else {
            System.out.println("Queue is full, insert failed");
        }
    }

    // remove method to remove highest priority elemet/letter from queue
    public char remove() {
        if (n > 0) { // Check if queue is not empty
            char highestPriorityLetter = queue[0]; // Set to index 0
            for (int i = 1; i < n; i++) { 
                queue[i - 1] = queue[i];
            } // In priority queue, highest priority element is in leftmost position, so we shift all elements to the left
            n--;
            return highestPriorityLetter;
        } else {
            System.out.println("Queue is empty, remove failed");
            return '\0';
        }
    }
    

    // display method to display the queue in descending order of priority
    public void display() {
        for (int i = 0; i < n; i++) { 
            System.out.print(queue[i] + " "); 
        }
        System.out.println();
    }

    // bubbleSort method to sort elements based on their priority
    private void bubbleSort() { // Private method, only in this class
        for (int i = 0; i < n - 1; i++) { // This loop ensures that sorting is repeated enough times to move/sort elements to their correct position
            for (int j = 0; j < n - 1 - i; j++) { // This loop compares adjacent elements and swaps them if they are in the wrong order
                if (queue[j] < queue[j + 1]) { // If current element has lower priority than next one
                    char temp = queue[j]; // Using temporary variable for swapping elements
                    queue[j] = queue[j + 1]; // Swap elements
                    queue[j + 1] = temp; // Store element in temporary variable
                }
            }
        }
    }
}

