package javaclasses;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private String nameOfLibrary;
    private List<Book> booksList;

    public Library(String name) {
        this.nameOfLibrary = name;
        this.booksList = new ArrayList<>();
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    public boolean addBook(Book book) {
        return (booksList.stream().anyMatch(o -> o.getId() == book.getId()))? false : booksList.add(book);
    }

    public boolean removeBook(Book book){
        return booksList.contains(book) && booksList.remove(book);
    }


    public List<Book> getBooksByAuthor(String author) {
        List<Book> authorsBooks = new ArrayList<>();
        for(Book book : booksList){
            for(String stringFromSet : book.getAuthorsSet()) {
                if (stringFromSet.equalsIgnoreCase(author)) authorsBooks.add(book);
            }
        }
        return authorsBooks;
    }

    public List<Book> getBooksByPublisher(String publisher){
        return booksList.stream().filter(o -> o.getPublisher().equalsIgnoreCase(publisher))
                .collect(Collectors.toList());
    }

    public List<Book> getBooksAfterYear(int year){
        return booksList.stream().filter(o -> o.getReleaseYear() > year).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Library{" +
                "nameOfLibrary='" + nameOfLibrary + '\'' +
                ", books=" + booksList +
                '}';
    }
}
