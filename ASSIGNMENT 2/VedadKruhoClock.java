public class VedadKruhoClock { // Class for managing 12-hour and 24-hour clock
    private VedadKruhoCircularLinkedList twelveHourClock; // Circular linked list for 12-hour clock
    private VedadKruhoCircularLinkedList twentyFourHourClock; // Circular linked list for 24-hour clock

    public VedadKruhoClock() { // Constructor
        twelveHourClock = new VedadKruhoCircularLinkedList(); // Initialize 12-hour clock
        twentyFourHourClock = new VedadKruhoCircularLinkedList(); // Initialize 24-hour clock
        initializeClocks(); // Initialize hours for both clocks
    }

    private void initializeClocks() { // Method to initialize hours for both clocks
        for (int i = 1; i <= 12; i++) { // From 1 to 12 for 12-hour clock
            twelveHourClock.addHour(i);
        }
        for (int i = 1; i <= 24; i++) { // From 1 to 24 for 24-hour clock
            twentyFourHourClock.addHour(i);
        }
    }

    public void setTwelveHourAlarm(int hour) { // Method to set alarm for 12-hour clock
        twelveHourClock.setAlarm(hour);
    }

    public void setTwentyFourHourAlarm(int hour) { // Method to set alarm for 24-hour clock
        twentyFourHourClock.setAlarm(hour);
    }

    public void setTwelveHourShift(int hour, boolean forward) { // Method to set shift for 12-hour clock
        twelveHourClock.setShift(hour, forward);
    }

    public void setTwentyFourHourShift(int hour, boolean forward) { // Method to set shift for 24-hour clock
        twentyFourHourClock.setShift(hour, forward);
    }

    public void goTraverseTwelveHourClock() {  // Method to traverse 12-hour clock
        twelveHourClock.goTraverse(); 
    }

    public void goTraverseTwentyFourHourClock() {  // Method to traverse 24-hour clock
        twentyFourHourClock.goTraverse();
    }
}
