package ru.aston.shellsorter.strategy;

import ru.aston.shellsorter.service.Service;
import ru.aston.shellsorter.service.ServiceFactory;
import ru.aston.shellsorter.utils.cli.InputUtil;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Strategy for data input.
 */
public class DataInputStrategy implements Strategy {
    private static final Map<Integer, String> TYPE_OPTIONS = Map.of(
            1, "Car",
            2, "Book",
            3, "Root Vegetable"
    );
    private static final Map<Character, String> DATA_SOURCE_OPTIONS = Map.of(
            'F', "File",
            'R', "Random",
            'M', "Manual Input"
    );
    private final Scanner scanner;

    public DataInputStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {

        //get the type
        int objectTypeKey = InputUtil.promptForInt(scanner, "Select object type:", TYPE_OPTIONS);
        String objectType = TYPE_OPTIONS.get(objectTypeKey);
        System.out.printf("Selected object type: %s%n", objectType);

        //initialise service
        ServiceFactory.setActualService(objectType);

        //get the length of the array
        int length = InputUtil.promptForPositiveInt("Enter the length of the array (> 0):", scanner);

        //get the way to fill the array
        Service service = ServiceFactory.getActualService();
        Map<Character, Consumer<Integer>> dataSourceStrategy = Map.of(
                'F', service::fromFileFill,
                'R', service::randomGeneratedFill,
                'M', service::manualFill
        );

        //initialise the array
        char dataSource = InputUtil.promptForChar(scanner, "Select data source:", DATA_SOURCE_OPTIONS);
        dataSourceStrategy.get(dataSource).accept(length);
        System.out.printf("Data loaded. Source: %s, Length: %d%n", DATA_SOURCE_OPTIONS.get(dataSource), length);
    }

    public String getStrategyTitle() {
        return "Data Input";
    }
}
