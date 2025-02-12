package ru.aston.shellsorter.strategy;

/**
 * Strategy to exit the application.
 */
public class ExitStrategy implements Strategy {

    public String getStrategyTitle() {
        return "Exit";
    }
    /**
     * Execute the exit process.
     */
    @Override
    public void execute() {
        System.out.println("Exiting the program.");
        System.exit(0);
    }
}