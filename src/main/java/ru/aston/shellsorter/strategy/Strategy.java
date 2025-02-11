package ru.aston.shellsorter.strategy;

/**
 * Defines a common interface for all strategies.
 */
public interface Strategy {
    /**
     * @return a strategy title
     */
    String getStrategyTitle();

    /**
     * Execute a strategy
     */
    void execute();
}
