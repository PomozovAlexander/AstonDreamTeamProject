package ru.aston.shellsorter.utils.generator;

import ru.aston.shellsorter.model.Car;

import java.time.Year;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Car generator
 *
 * <p>Generates {@link Car} object with parameters:
 * <ul>
 *   <li>Power (from {@value MIN_POWER} to {@value MAX_POWER})</li>
 *   <li>Model (Artemis Motors Falcon, Nova Automotive Voyager, Vanguard Cars Pulsar)</li>
 *   <li>Production Year (between {@value MIN_PRODUCTION_YEAR} and current year)</li>
 * </ul>
 *
 * <p>Example:</p>
 * <pre>{@code
 * Random random = new SecureRandom();
 * CarRandomGenerator generator = new CarRandomGenerator(random);
 * Car car = generator.generate();
 * }</pre>
 */
public class CarRandomGenerator implements RandomGenerator<Car> {

    private static final String[] MANUFACTURERS = {
            "Artemis Motors", "Nova Automotive", "Vanguard Cars", "Apex Vehicles", "Zenith Motors"
    };
    private static final String[] MODELS = {
            "Falcon", "Spectra", "Voyager", "Pulsar", "Eclipse", "Vertex", "Mirage", "Fusion"
    };
    private static final int MIN_POWER = 100;
    private static final int MAX_POWER = 500;
    private static final int MIN_PRODUCTION_YEAR = 1886;
    private static final int MAX_PRODUCTION_YEAR = Year.now().getValue();
    private final Random random;

    /**
     * Constructor for the {@link CarRandomGenerator}.
     *
     * @param random the random number generator; must not be {@code null}.
     * @throws NullPointerException if {@code random} is {@code null}.
     */
    public CarRandomGenerator(Random random) {
        this.random = Optional.ofNullable(random)
                .orElseThrow(() -> new IllegalArgumentException("random must not be null"));
    }

    /**
     * Generates a new {@link Car} object.
     *
     * @return a generated {@link Car} object.
     */
    @Override
    public Car generate() {
        int power = generatePower();
        String model = generateModel();
        int productionYear = generateProductionYear();

        return new Car.Builder()
                .setPower(power)
                .setModel(model)
                .setProductionYear(productionYear)
                .build();
    }

    /**
     * Generates a new {@link Car} array.
     *
     * @return a generated {@link Car} array.
     */
    @Override
    public Car[] generateArray(int length) {
        return Stream.generate(this::generate).limit(length).toArray(Car[]::new);
    }

    /**
     * Generates a random power value.
     *
     * @return an integer between {@value MIN_POWER} and {@value MAX_POWER}.
     */
    private int generatePower() {
        return random.nextInt(MAX_POWER - MIN_POWER) + MIN_POWER;
    }

    /**
     * Generates a car model name by combining a randomly selected manufacturer and model.
     *
     * @return a string representing the car model name
     */
    private String generateModel() {
        String manufacturer = MANUFACTURERS[random.nextInt(MANUFACTURERS.length)];
        String modelName = MODELS[random.nextInt(MODELS.length)];
        return manufacturer + " " + modelName;
    }

    /**
     * Generates the production year.
     *
     * @return an integer between {@value MIN_PRODUCTION_YEAR} and current year.
     */
    private int generateProductionYear() {
        return MIN_PRODUCTION_YEAR + random.nextInt(MAX_PRODUCTION_YEAR - MIN_PRODUCTION_YEAR);
    }
}
