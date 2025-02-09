package ru.aston.shellsorter;

import ru.aston.shellsorter.model.Book;
import ru.aston.shellsorter.model.Car;
import ru.aston.shellsorter.utils.sorter.BookComparator;
import ru.aston.shellsorter.utils.sorter.CarComparator;
import ru.aston.shellsorter.utils.sorter.ShellSorter;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Car car1 = new Car.Builder()
                .setPower(100)
                .setModel("Lada")
                .setProductionYear(1985)
                .build();
        Car car2 = new Car.Builder()
                .setPower(80)
                .setModel("Skoda")
                .setProductionYear(2001)
                .build();
        Car car3 = new Car.Builder()
                .setPower(200)
                .setModel("BMW")
                .setProductionYear(2015)
                .build();
        Car car4 = new Car.Builder()
                .setPower(200)
                .setModel("Citroen")
                .setProductionYear(2019)
                .build();
        Car car5 = new Car.Builder()
                .setPower(120)
                .setModel("BYD")
                .setProductionYear(2021)
                .build();

        Book book1 = new Book.Builder()
                .setAuthor("Jack London")
                .setTitle("The Son of the Wolf")
                .setPages(357)
                .build();

        Book book2 = new Book.Builder()
                .setAuthor("Mark Twain")
                .setTitle("The American Claimant")
                .setPages(296)
                .build();


        Book book3 = new Book.Builder()
                .setAuthor("Gabriel Garcia Marquez")
                .setTitle("One Hundred Years of Solitude")
                .setPages(291)
                .build();

        Book book4 = new Book.Builder()
                .setAuthor("F. Scott Fitzgerald")
                .setTitle("The Great Gatsby")
                .setPages(426)
                .build();

        Book book5 = new Book.Builder()
                .setAuthor("Marcel Proust")
                .setTitle("In Search of Lost Time")
                .setPages(638)
                .build();



        Car[] cars = {car1, car2, car3, car4, car5};
        Book[] books = {book1, book2, book3, book4, book5};


        ShellSorter sorter = new ShellSorter();

        CarComparator carComparator = new CarComparator();
        BookComparator bookComparator= new BookComparator();


        Arrays.stream(cars).forEach(car -> System.out.println(car));


        // Сортировка Shell универсальная для T [] array
        sorter.sort(cars, carComparator);
        System.out.println("after universal shell sort ");
        Arrays.stream(cars).forEach(car -> System.out.println(car));

        sorter.sort(books, bookComparator);
        System.out.println("after universal shell sort ");
        Arrays.stream(books).forEach(book -> System.out.println(book));
    }
}
