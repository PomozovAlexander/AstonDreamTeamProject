package ru.aston.shellsorter.utils.cli;

import ru.aston.shellsorter.strategy.Strategy;

import java.time.Year;
import java.util.Map;
import java.util.Scanner;

public final class InputUtil {
    private InputUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Displays a menu and asks the user to select a character.
     *
     * @param scanner the Scanner object.
     * @param header  the menu title.
     * @param options a map of options.
     * @return the selected character.
     */
    public static char promptForChar(Scanner scanner, String header, Map<Character, String> options) {
        while (true) {
            System.out.println(header);
            options.forEach((key, value) -> System.out.printf("[%s] %s%n", key, value));
            System.out.print("Your choice: ");
            String input = scanner.next().toUpperCase();
            if (!input.isEmpty() && options.containsKey(input.charAt(0))) {
                return input.charAt(0);
            }
            System.out.println("Invalid choice. Please try again.");
        }
    }

    /**
     * Displays a menu and asks the user for an integer choice.
     *
     * @param scanner the Scanner object.
     * @param header  the menu title.
     * @param options a map of options.
     * @return the selected number
     */
    public static int promptForInt(Scanner scanner, String header, Map<Integer, String> options) {
        while (true) {
            System.out.println(header);
            options.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry ->
                            System.out.printf("[%d] %s%n", entry.getKey(), entry.getValue())
                    );
            System.out.print("Your choice: ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (options.containsKey(choice)) {
                    return choice;
                }
                System.out.println("Invalid choice. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    /**
     * Displays a menu and asks the user for an integer choice.
     *
     * @param scanner the Scanner object.
     * @param header  the menu title.
     * @param options a map of strategies.
     * @return the selected number
     */
    public static int promptForStrategy(Scanner scanner, String header, Map<Integer, Strategy> options) {
        while (true) {
            System.out.println(header);
            options.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry ->
                            System.out.printf("[%d] %s%n", entry.getKey(), entry.getValue().getStrategyTitle()));
            System.out.print("Your choice: ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (options.containsKey(choice)) {
                    return choice;
                }
                System.out.println("Invalid choice. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    /**
     * Overloaded version of the method that allows you to set a default value.
     *
     * @return the selected number or default value.
     */
    public static int promptForInt(Scanner scanner, String header, Map<Integer, String> options, int defaultValue) {
        while (true) {
            System.out.println(header);
            options.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry ->
                            System.out.printf("[%d] %s%n", entry.getKey(), entry.getValue())
                    );
            System.out.printf("Your choice [default: %d]: ", defaultValue);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                return defaultValue;
            }
            try {
                int choice = Integer.parseInt(input);
                if (options.containsKey(choice)) {
                    return choice;
                }
                System.out.println("Invalid choice. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    /**
     * Prompts the user for a non-empty string.
     *
     * @param prompt  the message to display to the user.
     * @param scanner the Scanner object.
     * @return a non-empty, trimmed string.
     */
    public static String promptForNonEmptyString(String prompt, Scanner scanner) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input must not be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }

    /**
     * Prompts the user for a positive integer.
     *
     * @param prompt  the message to display to the user.
     * @param scanner the Scanner object.
     * @return a positive integer.
     */
    public static int promptForPositiveInt(String prompt, Scanner scanner) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("Input must be a positive integer. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid positive integer.");
            }
        }
    }

    /**
     * Prompts the user for a production year.
     * The input is validated to be an integer within the allowed range (1886 to current year).
     *
     * @param prompt  the message to display to the user.
     * @param scanner the Scanner object
     * @return a valid production year.
     */
    public static int promptForYear(String prompt, Scanner scanner) {
        int year = -1;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                year = Integer.parseInt(input);
                int currentYear = Year.now().getValue();
                if (year < 1886 || year > currentYear) {
                    throw new IllegalArgumentException("Year must be between 1886 and " + currentYear);
                }
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer for the year.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return year;
    }


}