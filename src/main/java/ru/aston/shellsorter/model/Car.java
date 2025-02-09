package ru.aston.shellsorter.model;

import java.util.Objects;
import java.time.Year;

/**
 * Class representing a Car.
 * <p>
 * Fields: power, model, productionYear.
 * Uses the Builder pattern for object construction.
 * Comparison (Comparable) is performed first by power, then by model, and finally by production year.
 * </p>
 */
public class Car implements Comparable<Car> {
    private final int power;
    private final String model;
    private final int productionYear;

    private Car(Builder builder) {
        this.power = builder.power;
        this.model = builder.model;
        this.productionYear = builder.productionYear;
    }

    public int getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    /**
     * Compares this car to another based on power, model, and production year.
     *
     * @param other the car to be compared.
     * @return a negative integer, zero, or a positive integer as this car
     *         is less than, equal to, or greater than the specified car.
     */
    @Override
    public int compareTo(Car other) {
        int cmp = Integer.compare(this.power, other.power);
        if (cmp == 0) {
            cmp = this.model.compareTo(other.model);
            if (cmp == 0) {
                cmp = Integer.compare(this.productionYear, other.productionYear);
            }
        }
        return cmp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getPower() == car.getPower() &&
                getProductionYear() == car.getProductionYear() &&
                Objects.equals(getModel(), car.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, model, productionYear);
    }

    @Override
    public String toString() {
        return "Car{" +
                "power=" + power +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                '}';
    }

    /**
     * Builder for creating instances of Car.
     */
    public static class Builder {
        private int power;
        private String model;
        private int productionYear;

        /**
         * Sets the power of the car.
         *
         * @param power the power value, must be positive.
         * @return the builder instance.
         * @throws IllegalArgumentException if power is not positive.
         */
        public Builder setPower(int power) {
            if (power <= 0) {
                throw new IllegalArgumentException("Power must be a positive value");
            }
            this.power = power;
            return this;
        }

        /**
         * Sets the model of the car.
         *
         * @param model the model string, must not be null or empty.
         * @return the builder instance.
         * @throws NullPointerException if model is null.
         * @throws IllegalArgumentException if model is empty.
         */
        public Builder setModel(String model) {
            this.model = Objects.requireNonNull(model, "Model must not be null").trim();
            if (this.model.isEmpty()) {
                throw new IllegalArgumentException("Model must not be empty");
            }
            return this;
        }

        /**
         * Sets the production year of the car.
         *
         * @param productionYear the year of production. Must be between 1886 and the current year.
         * @return the builder instance.
         * @throws IllegalArgumentException if productionYear is outside the allowed range.
         */
        public Builder setProductionYear(int productionYear) {
            int currentYear = Year.now().getValue();
            if (productionYear < 1886 || productionYear > currentYear) {
                throw new IllegalArgumentException(
                        "Production year must be between 1886 and " + currentYear);
            }
            this.productionYear = productionYear;
            return this;
        }

        /**
         * Builds and returns a Car instance.
         *
         * @return a new Car instance.
         */
        public Car build() {
            return new Car(this);
        }
    }
}
