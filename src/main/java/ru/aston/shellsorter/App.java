package ru.aston.shellsorter;

import ru.aston.shellsorter.strategy.*;
import ru.aston.shellsorter.utils.cli.InputUtil;

import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Strategy> strategies = Map.of(
                1, new DataInputStrategy(scanner),
                2, new SortingStrategy(scanner),
                3, new SearchStrategy(scanner),
                4, new OutputStrategy(scanner),
                5, new ExitStrategy()
        );

        while (true) {
            Strategy strategy = strategies.get(
                    InputUtil.promptForStrategy(scanner, "\n=== Main Menu ===", strategies)
            );
            strategy.execute();
        }
    }
}
