package ru.aston.shellsorter.utils.generator;

import ru.aston.shellsorter.model.Book;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Book generator
 *
 * <p>Generates a {@link Book} object with parameters:
 * <ul>
 *   <li>Author (John Smith, Emily Johnson, Robert Williams)</li>
 *   <li>Title(Silent Journey, Dark Enchanted, Lost World)</li>
 *   <li>Pages (from {@value MIN_PAGES} to {@value MAX_PAGES})</li>
 * </ul></p>
 *
 * <p>Example:</p>
 * <pre>{@code
 * Random random = new SecureRandom();
 * BookRandomGenerator generator = new BookRandomGenerator(random);
 * Book book = generator.generate();
 * }</pre>
 */
public class BookRandomGenerator implements RandomGenerator<Book> {

    private static final String[] FIRST_NAMES = {
            "John", "Emily", "Robert", "Sophia", "Michael", "Olivia",
            "David", "Isabella", "James", "Mia", "William", "Charlotte",
            "Alexander", "Amelia", "Daniel", "Harper"
    };
    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia",
            "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez", "Lopez",
            "Gonzalez", "Wilson", "Anderson"
    };
    private static final String[] ADJECTIVES = {
            "Silent", "Dark", "Lost", "Hidden", "Secret", "Mystic",
            "Ancient", "Enchanted", "Forbidden", "Legendary", "Eternal", "Infinite"
    };
    private static final String[] NOUNS = {
            "Journey", "Memory", "World", "Empire", "Dream", "Night",
            "Forest", "City", "Odyssey", "Chronicle", "Labyrinth", "Saga"
    };
    private static final int MIN_PAGES = 50;
    private static final int MAX_PAGES = 500;
    private final Random random;

    /**
     * Constructor for the BookRandomGenerator.
     *
     * @param random the random number generator; must not be null.
     * @throws NullPointerException if random is null.
     */
    public BookRandomGenerator(Random random) {
        this.random = Optional.ofNullable(random)
                .orElseThrow(() -> new IllegalArgumentException("random must not be null"));
    }

    /**
     * Generates a new {@link Book} object.
     *
     * @return a generated {@link Book} object.
     */
    @Override
    public Book generate() {
        String author = generateAuthor();
        String title = generateTitle();
        int pages = generatePageCount();

        return new Book.Builder()
                .setAuthor(author)
                .setTitle(title)
                .setPages(pages)
                .build();
    }

    /**
     * Generates a new {@link Book} array.
     *
     * @return a generated {@link Book} array.
     */
    @Override
    public Book[] generateArray(int length) {
        return Stream.generate(this::generate).limit(length).toArray(Book[]::new);
    }

    /**
     * Generates an author combining a randomly chosen name and family.
     *
     * @return a string representing the author's full name
     */
    private String generateAuthor() {
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }

    /**
     * Generates a book title by combining a randomly chosen adjective and noun.
     *
     * @return a string with the book title
     */
    private String generateTitle() {
        String adjective = ADJECTIVES[random.nextInt(ADJECTIVES.length)];
        String noun = NOUNS[random.nextInt(NOUNS.length)];
        return adjective + " " + noun;
    }

    /**
     * Generates a random number of book pages.
     *
     * @return an integer between {@value MIN_PAGES} and {@value MAX_PAGES}
     */
    private int generatePageCount() {
        return random.nextInt(MAX_PAGES - MIN_PAGES) + MIN_PAGES;
    }
}



