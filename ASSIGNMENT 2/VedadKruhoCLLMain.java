import java.util.Scanner; // For user input

public class VedadKruhoCLLMain { // Main class for running the program
    public static void main(String[] args) {
        VedadKruhoClock clock = new VedadKruhoClock(); // Create a new clock object
        Scanner scanner = new Scanner(System.in); // Create a new scanner object for user input

        while (true) { // Infinite loop for user interaction
            System.out.println("Select clock type: 1 for 12-hour, 2 for 24-hour, 0 to exit");
            int choice = scanner.nextInt(); // Read user choice
            scanner.nextLine(); // Newline
            if (choice == 0) break; // Exit

            switch (choice) { // Switch based on user choice
                case 1: // If user selects 12-hour clock
                    while (true) { // Loop for setting alarm
                        System.out.println("Do you want to set an alarm? (yes/no)");
                        String setAlarm = scanner.nextLine();
                        if (setAlarm.equalsIgnoreCase("yes")) { // If user wants to set alarm
                            System.out.println("Set alarm hour (1-12):");
                            int twelveHourAlarm = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            clock.setTwelveHourAlarm(twelveHourAlarm); // Set alarm for hour user entered
                            break; // Exit loop
                        } else if (setAlarm.equalsIgnoreCase("no")) { // If user does not want to set alarm
                            break; // Exit
                        } else {
                            System.out.println("Invalid input. Please enter 'yes' or 'no'."); // Invalid input
                        }
                    }
                    while (true) { // Loop for setting shift
                        System.out.println("Do you want to set a shift? (yes/no)");
                        String setShift = scanner.nextLine();
                        if (setShift.equalsIgnoreCase("yes")) {
                            int twelveHourShift;
                            while (true) {
                                System.out.println("Set shift hour (1-12):");
                                twelveHourShift = scanner.nextInt();
                                scanner.nextLine(); // consume newline
                                if (twelveHourShift >= 1 && twelveHourShift <= 12) { // Validate shift hour
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please enter a valid hour (1-12).");
                                }
                            }
                            boolean forward;
                            while (true) { // Loop for shift direction
                                System.out.println("Shift forward or backward? (forward/backward)");
                                String shiftDirection = scanner.nextLine();
                                if (shiftDirection.equalsIgnoreCase("forward")) {
                                    forward = true; // Shift forward
                                    break;
                                } else if (shiftDirection.equalsIgnoreCase("backward")) {
                                    forward = false; // Backward shift
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please enter 'forward' or 'backward'.");
                                }
                            }
                            clock.setTwelveHourShift(twelveHourShift, forward);
                            break;
                        } else if (setShift.equalsIgnoreCase("no")) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                        }
                    }
                    clock.goTraverseTwelveHourClock();
                    break;
                case 2:
                    while (true) {
                        System.out.println("Do you want to set an alarm? (yes/no)");
                        String setAlarm24 = scanner.nextLine();
                        if (setAlarm24.equalsIgnoreCase("yes")) {
                            System.out.println("Set alarm hour (1-24):");
                            int twentyFourHourAlarm = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            clock.setTwentyFourHourAlarm(twentyFourHourAlarm);
                            break;
                        } else if (setAlarm24.equalsIgnoreCase("no")) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                        }
                    }
                    while (true) {
                        System.out.println("Do you want to set a shift? (yes/no)");
                        String setShift24 = scanner.nextLine();
                        if (setShift24.equalsIgnoreCase("yes")) {
                            int twentyFourHourShift;
                            while (true) {
                                System.out.println("Set shift hour (1-24):");
                                twentyFourHourShift = scanner.nextInt();
                                scanner.nextLine(); // consume newline
                                if (twentyFourHourShift >= 1 && twentyFourHourShift <= 24) {
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please enter a valid hour (1-24).");
                                }
                            }
                            boolean forward24;
                            while (true) {
                                System.out.println("Shift forward or backward? (forward/backward)");
                                String shiftDirection24 = scanner.nextLine();
                                if (shiftDirection24.equalsIgnoreCase("forward")) {
                                    forward24 = true;
                                    break;
                                } else if (shiftDirection24.equalsIgnoreCase("backward")) {
                                    forward24 = false;
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please enter 'forward' or 'backward'.");
                                }
                            }
                            clock.setTwentyFourHourShift(twentyFourHourShift, forward24);
                            break;
                        } else if (setShift24.equalsIgnoreCase("no")) {
                            break;
                        } else {
                            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                        }
                    }
                    clock.goTraverseTwentyFourHourClock();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

// Do not need to comment case 2 as it is quite the same as case 1