package javaclasses;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//Использовал паттерн Builder т.к. много входных параметров конструктора

public class Book {
    private int id;
    private String name;
    private Set<String> authors;
    private String publisher;
    private int releaseYear;
    private int pages;
    private double cost;
    private TypeOfBinding typeOfBinding;

    private Book(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.authors = builder.authors;
        this.publisher = builder.publisher;
        this.releaseYear = builder.releaseYear;
        this.pages = builder.pages;
        this.cost = builder.cost;
        this.typeOfBinding = builder.typeOfBinding;
    }

    public enum TypeOfBinding{
        SOLID, SOFT
    }
    public static class Builder {
        private int id;
        private String name;
        private Set<String> authors = new HashSet<>();
        private String publisher;
        private int releaseYear;
        private int pages;
        private double cost;
        private TypeOfBinding typeOfBinding;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder authors (String ... authors) {
            this.authors.addAll(Arrays.asList(authors));
            return this;
        }
        public Builder authors (Set<String> authors) {
            this.authors = authors;
            return this;
        }
        public Builder publisher(String publisher){
            this.publisher = publisher;
            return this;
        }
        public Builder release_year(int releaseYear){
            this.releaseYear = releaseYear;
            return this;
        }
        public Builder pages(int pages){
            this.pages = pages;
            return this;
        }
        public Builder cost(double cost){
            this.cost = cost;
            return this;
        }
        public Builder type(TypeOfBinding typeOfBinding){
            this.typeOfBinding = typeOfBinding;
            return this;
        }
        public Builder type(String type){
            this.typeOfBinding = TypeOfBinding.valueOf(type.toUpperCase());
            return this;
        }
        public Book build(){
            return new Book(this);
        }


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getAuthorsSet() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public TypeOfBinding getTypeOfBinding() {
        return typeOfBinding;
    }

    public void setTypeOfBinding(TypeOfBinding typeOfBinding) {
        this.typeOfBinding = typeOfBinding;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors=" + authors +
                ", publisher='" + publisher + '\'' +
                ", release_year=" + releaseYear +
                ", pages=" + pages +
                ", cost=" + cost +
                ", typeOfBinding=" + typeOfBinding +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                releaseYear == book.releaseYear &&
                pages == book.pages &&
                Double.compare(book.cost, cost) == 0 &&
                Objects.equals(name, book.name) &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(publisher, book.publisher) &&
                typeOfBinding == book.typeOfBinding;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, authors, publisher, releaseYear, pages, cost, typeOfBinding);
    }
}
