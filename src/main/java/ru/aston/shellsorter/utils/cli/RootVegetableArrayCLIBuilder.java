package ru.aston.shellsorter.utils.cli;

import ru.aston.shellsorter.model.RootVegetable;

import java.util.Scanner;

/**
 * Utility class for creating an array of {@link RootVegetable} from CLI.
 */
public final class RootVegetableArrayCLIBuilder {

    private RootVegetableArrayCLIBuilder() {
        throw new UnsupportedOperationException("Utility class.");
    }

    /**
     * Builds an array of {@link RootVegetable}.
     *
     * @param length the length of array.
     * @return an array of RootVegetables.
     * @throws IllegalArgumentException if length is negative.
     */
    public static RootVegetable[] buildRootVegetableArrayFromCLI(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Array length must not be negative.");
        }

        RootVegetable[] vegetables = new RootVegetable[length];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < length; i++) {
            System.out.printf("Enter details for RootVegetable #%d:%n", i + 1);

            String type = InputUtil.promptForNonEmptyString("Type: ", scanner);
            int weight = InputUtil.promptForPositiveInt("Weight (in grams): ", scanner);
            String color = InputUtil.promptForNonEmptyString("Color: ", scanner);

            vegetables[i] = new RootVegetable.Builder()
                    .setType(type)
                    .setWeight(weight)
                    .setColor(color)
                    .build();

            System.out.println("RootVegetable created successfully!\n");
        }
        return vegetables;
    }
}
