package ru.aston.shellsorter.strategy;

import ru.aston.shellsorter.service.Service;
import ru.aston.shellsorter.service.ServiceFactory;
import ru.aston.shellsorter.utils.cli.InputUtil;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * Sorting strategy for different object types.
 */
public class SortingStrategy implements Strategy {
    private static final Map<Integer, String> CAR_FIELDS = Map.of(
            1, "Power", //default
            2, "Model",
            3, "Production Year"
    );
    private static final Map<Integer, String> BOOK_FIELDS = Map.of(
            1, "Author", //default
            2, "Title",
            3, "Pages"
    );
    private static final Map<Integer, String> ROOT_VEGETABLE_FIELDS = Map.of(
            1, "Type", //default
            2, "Weight",
            3, "Color"
    );
    private static final Map<String, Map<Integer, String>> FIELDS = Map.of(
            "Book", BOOK_FIELDS,
            "Car", CAR_FIELDS,
            "Root Vegetable", ROOT_VEGETABLE_FIELDS
    );
    private final Scanner scanner;

    public SortingStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getStrategyTitle() {
        return "ShellSort";
    }

    /**
     * Executes the sorting strategy.
     */
    @Override
    public void execute() {
        //get the processed type
        String processedType = ServiceFactory.getProcessedType();

        //check if data is initialized
        if (Objects.isNull(processedType)) {
            System.out.println("Data is not initialised");
            return; // return to main menu
        }

        //get fields for the processed type
        Map<Integer, String> processedFields = FIELDS.get(processedType);

        //get field from user
        int sortingFieldKey = InputUtil.promptForInt(scanner, "Select sort field:", processedFields, 1);
        String sortingField = processedFields.get(sortingFieldKey);
        System.out.printf("Selected sort field: %s%n", sortingField);

        Service service = ServiceFactory.getActualService();
        if (sortingFieldKey == 1) {
            service.sort();//sorting by default field
        } else {
            service.sortByField(sortingField);//sorting by chosen field
        }
    }
}
