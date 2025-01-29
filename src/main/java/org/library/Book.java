package org.library;

public class Book implements LibraryManage{
    public String name;
    public int numberOfPages;

    public Book(String name, int numberOfPages) {
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }


    @Override
    public void addBook(Book book) {

    }

    @Override
    public void deleteBook(int index) {

    }

    @Override
    public void listBooks() {
        System.out.println(" Books " + name + " Pages: " + numberOfPages);

    }
}
