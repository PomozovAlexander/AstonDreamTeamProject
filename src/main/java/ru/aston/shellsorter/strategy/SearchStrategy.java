package ru.aston.shellsorter.strategy;

import ru.aston.shellsorter.service.Service;
import ru.aston.shellsorter.service.ServiceFactory;
import ru.aston.shellsorter.utils.cli.InputUtil;

import java.util.Scanner;

/**
 * Strategy for performing a search in the sorted data.
 */
public class SearchStrategy implements Strategy {
    private final Scanner scanner;

    public SearchStrategy(Scanner scanner) {
        this.scanner = scanner;
    }


    public String getStrategyTitle() {
        return "Search";
    }

    /**
     * Run the search process.
     */
    @Override
    public void execute() {
        //get the service that manages the data.
        Service service = ServiceFactory.getActualService();

        //check if data is initialized
        if (service == null) {
            System.out.println("Data is not initialised");
            return;
        }

        //check if data is sorted
        if (!service.isSorted()) {
            System.out.println("Data must be sorted before searching");
            return;
        }

        //get value to search from user
        String searchingRequest = InputUtil.promptForNonEmptyString("Enter value for binary search: ", scanner);

        //perform the search
        service.search(searchingRequest);
        System.out.printf("Search completed for value: %s%n", searchingRequest);
    }
}
