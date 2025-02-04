public class VedadKruhoMainPQueue {
    public static void main(String[] args) {
        VedadKruhoPQueue pq = new VedadKruhoPQueue(10);

        // Insert elements in the queue
        pq.insert('a');
        pq.insert('e');
        pq.insert('v');
        pq.insert('z');
        pq.insert('s');

        System.out.print("Our priority queue is defined in order: ");
        pq.display(); // Expected output: [z, v, s, e, a]

        // Remove the highest priority element/letter
        pq.remove();

        System.out.print("New queue after removing highest priority element/letter: ");
        pq.display(); // Expected output: [v, s, e, a]
    }
}
