package ru.aston.shellsorter.utils.generator;

import ru.aston.shellsorter.model.RootVegetable;

import java.util.Optional;
import java.util.Random;

/**
 * RootVegetable generator
 *
 * <p>Generates a {@link RootVegetable} object with parameters:
 * <ul>
 *   <li>Type (Carrot, Beet, Turnip, Radish, Parsnip)</li>
 *   <li>Weight in grams (from {@value MIN_WEIGHT} to {@value MAX_WEIGHT})</li>
 *   <li>Color (Orange, Red, Purple, White, Yellow)</li>
 * </ul></p>
 *
 * <p>Example:</p>
 * <pre>{@code
 * Random random = new SecureRandom();
 * RootVegetableRandomGenerator generator = new RootVegetableRandomGenerator(random);
 * RootVegetable vegetable = generator.generate();
 * }</pre>
 */
public class RootVegetableRandomGenerator implements RandomGenerator<RootVegetable> {

    private static final String[] TYPES = {
            "Carrot", "Beet", "Turnip", "Radish", "Parsnip"
    };
    private static final String[] COLORS = {
            "Orange", "Red", "Purple", "White", "Yellow"
    };
    private static final int MIN_WEIGHT = 100;
    private static final int MAX_WEIGHT = 2100;
    private final Random random;

    /**
     * Constructor for the {@link RootVegetableRandomGenerator}.
     *
     * @param random the random number generator; must not be {@code null}.
     * @throws NullPointerException if {@code random} is {@code null}.
     */
    public RootVegetableRandomGenerator(Random random) {
        this.random = Optional.ofNullable(random)
                .orElseThrow(() -> new IllegalArgumentException("random must not be null"));
    }

    /**
     * Generates a new {@link RootVegetable} object.
     *
     * @return a generated {@link RootVegetable} object.
     */
    @Override
    public RootVegetable generate() {
        String type = generateType();
        int weight = generateWeight();
        String color = generateColor();

        return new RootVegetable.Builder()
                .setType(type)
                .setWeight(weight)
                .setColor(color)
                .build();
    }

    /**
     * Generates a random root vegetable type.
     *
     * @return the root vegetable type selected from the {@code TYPES} array.
     */
    private String generateType() {
        return TYPES[random.nextInt(TYPES.length)];
    }

    /**
     * Generates a random root vegetable weight in grams.
     *
     * @return root vegetable weight from {@value MIN_WEIGHT} to {@value MAX_WEIGHT} grams.
     */
    private int generateWeight() {
        return random.nextInt(MAX_WEIGHT - MIN_WEIGHT) + MIN_WEIGHT;
    }

    /**
     * Generates a random root color.
     *
     * @return the root color chosen from the {@code COLORS} array.
     */
    private String generateColor() {
        return COLORS[random.nextInt(COLORS.length)];
    }
}

