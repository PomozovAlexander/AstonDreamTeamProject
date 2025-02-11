package ru.aston.shellsorter.strategy;

import ru.aston.shellsorter.service.Service;
import ru.aston.shellsorter.service.ServiceFactory;
import ru.aston.shellsorter.utils.cli.InputUtil;

import java.util.Map;
import java.util.Scanner;

/**
 * Strategy for output.
 */
public class OutputStrategy implements Strategy {
    private static final Map<Integer, String> OPTIONS = Map.of(
            1, "Console",
            2, "File"
    );
    private final Scanner scanner;

    public OutputStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getStrategyTitle() {
        return "Output";
    }

    /**
     * Run the output process.
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

        //get way to output the data
        String outputMethod = OPTIONS.get(InputUtil.promptForInt(scanner, "Select object type:", OPTIONS));

        //output methods
        Map<String, Runnable> dataSourceStrategy = Map.of(
                "Console", service::print,
                "File", service::save
        );

        //perform the selected output action.
        dataSourceStrategy.get(outputMethod).run();
        System.out.printf("Results saved. Selected output method: %s%n", outputMethod);
    }
}
