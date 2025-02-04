import java.util.Scanner; // For user input

public class VedadKruhoCircularLinkedList { // Class for circular linked list
    private VedadKruhoLink head; // Reference to head node
    private VedadKruhoLink tail; // Reference to tail node
    private int alarmHour = -1; // No alarm is set
    private int shiftHour = -1; // No shift is set
    private boolean shiftForward = true; // True for forward, for backward false
    private boolean shiftDone = false; // Track if shift has been performed
    private Scanner scanner;

    public VedadKruhoCircularLinkedList() { // Constructor
        this.head = null; // Initialize head to null
        this.tail = null; // Initialize tail to null
        this.scanner = new Scanner(System.in); // Initialize scanner for user input
    }

    public void addHour(int hour) { // Method for adding new hour in circular linked list
        VedadKruhoLink newLink = new VedadKruhoLink(hour); // Create a new node with hour value
        if (head == null) { // If empty
            head = newLink; // Head will be the new node
            tail = newLink; // Tail will be the new node
            newLink.next = head; // To make circular linked list, node will point to itself
        } else {
            tail.next = newLink; // Add new node to the end
            tail = newLink; // Tail will be new node
            tail.next = head; // To make circular linked list, tail will point to head
        }
    }

    public void setAlarm(int hour) { // Method to set alarm for specific hour
        this.alarmHour = hour;
    }

    public void setShift(int hour, boolean forward) { // 
        this.shiftHour = hour; // Set the shift hour
        this.shiftForward = forward; // Shift direction
        this.shiftDone = false; // Reset shift 
    }

    public void goTraverse() {
        if (head == null) return; // If list is empty, do nothing
        VedadKruhoLink current = head; // Travesral starts from head
        while (true) { // Continue indefinitely until user stops
            System.out.println("Current hour: " + current.hour); // Print current hour, in loop
            if (current.hour == alarmHour) { // Condition if current hour is equal to alarm hour
                System.out.println("ALARM IS RINGING! ALARM IS RINGING! ALARM IS RINGING!");
                while (true) { // Wait for user input
                    System.out.println("Type 'I WOKE UP' to continue to next hour or 'STOP' to terminate:");
                    String input = scanner.nextLine(); // Read user input
                    if (input.equalsIgnoreCase("STOP")) { // If user types 'stop' or 'STOP'
                        return; // Terminate
                    } else if (input.equalsIgnoreCase("I WOKE UP")) { // If user types 'I WOKE UP' or 'i woke up'
                        break; // Continue travesal
                    } else {
                        System.out.println("Invalid input. Type 'I WOKE UP' to continue to next hour or 'STOP' to terminate.");
                    }
                }
            }
            if (current.hour == shiftHour && !shiftDone) { // If current hour is shift hour, and shift is not performed yet
                if (shiftForward) { // For forward shift
                    current = current.next; // Skip the next hour
                    shiftDone = true; // Shift is performed, only once
                } else {
                    System.out.println("Current hour: " + current.hour); // Print the hour twice for backward shift
                    shiftDone = true; // Shift is performed, only once
                }
            }
            System.out.println("Press Enter to continue, type STOP to terminate:");
            String input = scanner.nextLine(); // User input
            if (input.equalsIgnoreCase("STOP")) {
                break;
            }
            current = current.next; // Move to next hour
        }
    }
}
