package ru.aston.shellsorter;

import ru.aston.shellsorter.model.Book;
import ru.aston.shellsorter.model.Car;
import ru.aston.shellsorter.model.RootVegetable;
import ru.aston.shellsorter.utils.finder.FinderBookUtil;
import ru.aston.shellsorter.utils.finder.FinderCarUtil;
import ru.aston.shellsorter.utils.finder.FinderRootVegetableUtil;
import ru.aston.shellsorter.utils.generator.RootVegetableRandomGenerator;
import ru.aston.shellsorter.utils.sorter.RootVegetableComparator;
import ru.aston.shellsorter.utils.sorter.ShellSorter;

import java.util.Arrays;
import java.util.Random;

public class LocalTestApp {
    public static void main(String[] args) {
        System.out.println("Hello world");
        RootVegetableRandomGenerator generator = new RootVegetableRandomGenerator(new Random());
        RootVegetable[] rootVegetables = new RootVegetable[10];
        for (int i = 0; i < rootVegetables.length; i++) {
            rootVegetables[i] = generator.generate();
        }


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
        RootVegetableComparator rootVegetableComparator = new RootVegetableComparator();
//
//        CarComparator carComparator = new CarComparator();
//        BookComparator bookComparator= new BookComparator();

//        BookAuthorComparator authorComparator = new BookAuthorComparator();
//        BookTitleComparator titleComparator= new BookTitleComparator();
//        BookPagesComparator pagesComparator= new BookPagesComparator();


        // Arrays.stream(cars).forEach(car -> System.out.println(car));


        // Сортировка Shell универсальная для T [] array
//        sorter.sort(cars, carComparator);
//        System.out.println("after universal shell sort ");
//        Arrays.stream(cars).forEach(car -> System.out.println(car));

//        sorter.sort(books, bookComparator);
//        System.out.println("after universal shell sort ");
//        Arrays.stream(books).forEach(book -> System.out.println(book));
//        System.out.println(" sort by author  ");
//        sorter.sort(books, authorComparator );
//        Arrays.stream(books).forEach(book -> System.out.println(book));
//        System.out.println(" sort by title  ");
//        sorter.sort(books, titleComparator );
//        Arrays.stream(books).forEach(book -> System.out.println(book));
//        System.out.println(" sort by pages  ");
//        sorter.sort(books, pagesComparator );
//        Arrays.stream(books).forEach(book -> System.out.println(book));
//        String author = "Marcel Proust";
//        FinderBookUtil.findBookByAuthor(books, author);
//        String author2 = "Proust";
//        FinderBookUtil.findBookByAuthor(books, author2);
//        String title = "Solitude";
//        FinderBookUtil.findBookByTitle(books, title);
//        int pages = 291;
//        FinderBookUtil.findBookByPages(books, pages);
//
//        String model = "BMW";
//        FinderCarUtil.findCarByModel(cars, model);
//
//        int power = 10;
//        FinderCarUtil.findCarByPower(cars, power);
//
//        int year = 2000;
//        FinderCarUtil.findCarByProductionYear(cars, year);

        //    Сортировка Shell универсальная для T [] array

        sorter.sort(rootVegetables, rootVegetableComparator);
        System.out.println("after universal shell sort ");
        Arrays.stream(rootVegetables).forEach(System.out::println);

        String type= "Turnip";
        int weight= 1884;
        String color= "White";
        FinderRootVegetableUtil.findRootVegetableByType(rootVegetables, type);
        FinderRootVegetableUtil.findRootVegetableByWeight(rootVegetables, weight);
        FinderRootVegetableUtil.findRootVegetableByColor(rootVegetables, color);



    }
}
