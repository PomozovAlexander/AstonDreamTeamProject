package ru.aston.shellsorter.model;

import java.util.Objects;

/**
 * Class representing a RootVegetable
 * <p>
 * Fields: type, weight, and color.
 * Uses the Builder pattern for object construction.
 * Comparison (Comparable) is performed first by weight, then type, and finally color.
 * </p>
 */
public class RootVegetable implements Comparable<RootVegetable> {
    private final String type;
    private final int weight;
    private final String color;

    private RootVegetable(Builder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    /**
     * Compares this root vegetable with another based on weight, type, and color.
     *
     * @param other the root vegetable to compare to.
     * @return a negative integer, zero, or a positive integer as this object is less than,
     * equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(RootVegetable other) {
        int cmp =  this.type.compareTo(other.type);
        if (cmp == 0) {
            cmp = Integer.compare(this.weight, other.weight);
            if (cmp == 0) {
                cmp = this.color.compareTo(other.color);
            }
        }
        return cmp;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RootVegetable that = (RootVegetable) o;
        return getWeight() == that.getWeight() &&
                Objects.equals(getType(), that.getType()) &&
                Objects.equals(getColor(), that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight, color);
    }

    @Override
    public String toString() {
        return "RootVegetable{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    /**
     * Builder for creating instances of RootVegetable.
     */
    public static class Builder {
        private String type;
        private int weight;
        private String color;

        /**
         * Sets the type of the root vegetable.
         *
         * @param type the vegetable type; must not be null or empty.
         * @return the Builder instance.
         * @throws NullPointerException     if type is null.
         * @throws IllegalArgumentException if type is empty.
         */
        public Builder setType(String type) {
            this.type = Objects.requireNonNull(type, "Type must not be null").trim();
            if (this.type.isEmpty()) {
                throw new IllegalArgumentException("Type must not be empty");
            }
            return this;
        }

        /**
         * Sets the weight of the root vegetable.
         *
         * @param weight the weight in grams; must be positive.
         * @return the Builder instance.
         * @throws IllegalArgumentException if weight is not positive.
         */
        public Builder setWeight(int weight) {
            if (weight <= 0) {
                throw new IllegalArgumentException("Weight must be positive");
            }
            this.weight = weight;
            return this;
        }

        /**
         * Sets the color of the root vegetable.
         *
         * @param color the vegetable color; must not be null or empty.
         * @return the Builder instance.
         * @throws NullPointerException     if color is null.
         * @throws IllegalArgumentException if color is empty.
         */
        public Builder setColor(String color) {
            this.color = Objects.requireNonNull(color, "Color must not be null").trim();
            if (this.color.isEmpty()) {
                throw new IllegalArgumentException("Color must not be empty");
            }
            return this;
        }

        /**
         * Builds and returns a new RootVegetable instance.
         *
         * @return a new RootVegetable object.
         */
        public RootVegetable build() {
            return new RootVegetable(this);
        }
    }
}
