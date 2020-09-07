package javaclasses;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        Library library = new Library("Central library");
        library.addBook(new Book.Builder().id(1).name("Java").authors("Shildt", "Blinov", "Blinov").publisher("Oracle")
                .release_year(2005).pages(530).cost(100).type("soft").build());
        library.addBook(new Book.Builder().id(2).name("HeadFirst").authors("Eric Freeman").publisher("Book company")
                .release_year(2002).pages(200).cost(130).type("soft").build());
        library.addBook(new Book.Builder().id(3).name("Servlet Jsp").authors("O'Reily").publisher("Magazine company")
                .release_year(2001).pages(440).cost(140).type(Book.TypeOfBinding.SOLID).build());


        System.out.println(library.getBooksByAuthor("blinov"));
        System.out.println(library.getBooksByPublisher("book company"));
        System.out.println(library.getBooksAfterYear(2001));


    }
}
