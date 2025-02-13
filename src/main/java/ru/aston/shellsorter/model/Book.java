package ru.aston.shellsorter.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class representing a Book.
 * <p>
 * Fields: author, title, pages.
 * Uses the Builder pattern for object construction.
 * Comparison (Comparable) is performed first by pages, then by author, and finally by title.
 * </p>
 */
public final class Book implements Comparable<Book> {
    private final String author;
    private final String title;
    private final int pages;

    private Book(Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.pages = builder.pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    /**
     * Compares this car to another based on author, title and pages.
     *
     * @param other the book to compare with
     * @return a negative integer, zero, or a positive integer as this book
     * is less than, equal to, or greater than the specified book
     */
    @Override
    public int compareTo(Book other) {
        int cmp = this.author.compareTo(other.author);
        if (cmp == 0) {
            cmp = this.title.compareTo(other.title);
            if (cmp == 0) {
                cmp = Integer.compare(this.pages, other.pages);
            }
        }
        return cmp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getPages() == book.getPages() &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getTitle(), book.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, pages);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }

    /**
     * Builder class for creating Book instances.
     */
    public static class Builder {
        private String author;
        private String title;
        private int pages;

        /**
         * Sets the author of the book.
         *
         * @param author the author's name, must not be null or empty
         * @return the builder instance
         * @throws NullPointerException     if the author is null
         * @throws IllegalArgumentException if the author is empty
         */
        public Builder setAuthor(String author) {
            this.author = Objects.requireNonNull(author, "Author must not be null").trim();
            if (this.author.isEmpty()) {
                throw new IllegalArgumentException("Author name must not be empty");
            }
            return this;
        }

        /**
         * Sets the title of the book.
         *
         * @param title the book title, must not be null or empty
         * @return the builder instance
         * @throws NullPointerException     if the title is null
         * @throws IllegalArgumentException if the title is empty
         */
        public Builder setTitle(String title) {
            this.title = Objects.requireNonNull(title, "Title must not be null").trim();
            if (this.title.isEmpty()) {
                throw new IllegalArgumentException("Title must not be empty");
            }
            return this;
        }

        /**
         * Sets the number of pages in the book.
         *
         * @param pages the number of pages, must be greater than 0
         * @return the builder instance
         * @throws IllegalArgumentException if pages is not positive
         */
        public Builder setPages(int pages) {
            if (pages <= 0) {
                throw new IllegalArgumentException("Number of pages must be greater than 0");
            }
            this.pages = pages;
            return this;
        }

        /**
         * Builds and returns a Book instance.
         *
         * @return a new Book instance
         */
        public Book build() {
            return new Book(this);
        }
    }

    @JsonCreator
    public Book(
            @JsonProperty("author") String author,
            @JsonProperty("title") String title,
            @JsonProperty("pages") int pages) {
        this.author = author;
        this.title = title;
        this.pages = pages;
    }
}
