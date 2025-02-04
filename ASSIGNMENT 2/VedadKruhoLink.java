public class VedadKruhoLink { // Class representing a node in a circular linked list
    int hour; // hour = node value
    VedadKruhoLink next; // next = reference to the next node in the list

    public VedadKruhoLink(int hour) { // Constructor
        this.hour = hour;
        this.next = null;
    }
}
// Implementation of singly linked list with circular behavior