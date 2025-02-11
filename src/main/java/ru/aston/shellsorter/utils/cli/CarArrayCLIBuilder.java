package ru.aston.shellsorter.utils.cli;

import ru.aston.shellsorter.model.Car;

import java.util.Scanner;

/**
 * Utility class for creating an array of {@link Car} from CLI.
 */
public final class CarArrayCLIBuilder {

    private CarArrayCLIBuilder() {
        throw new UnsupportedOperationException("Utility class.");
    }

    /**
     * Builds an array of {@link Car}.
     *
     * @param length the length of array.
     * @return an array of Cars.
     * @throws IllegalArgumentException if length is negative.
     */
    public static Car[] buildCarArrayFromCLI(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Array length must be non-negative.");
        }

        Car[] cars = new Car[length];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < length; i++) {
            System.out.printf("Enter details for Car #%d:%n", i + 1);

            int power = InputUtil.promptForPositiveInt("Power: ", scanner);
            String model = InputUtil.promptForNonEmptyString("Model: ", scanner);
            int productionYear = InputUtil.promptForYear("Production Year: ", scanner);

            cars[i] = new Car.Builder()
                    .setPower(power)
                    .setModel(model)
                    .setProductionYear(productionYear)
                    .build();

            System.out.println("Car created successfully!\n");
        }
        return cars;
    }
}

