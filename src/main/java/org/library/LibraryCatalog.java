package org.library;

import java.util.ArrayList;

public class LibraryCatalog {
    ArrayList<Book> catalog = new ArrayList<>();

    public void addBook(Book book) {
        if (!catalog.contains(book)) {
            catalog.add(book);
            System.out.println("The book " + book + " was added");
        } else {
            System.out.println("\nThe book already exists");
        }
    }

    public void removeBook(Book book) {
        if (catalog.remove(book)) {
            System.out.println("\nBook " + book.name + " was removed ");
        } else {
            System.out.println("\nBook not found");
        }
    }

    public void listBooks() {
        for (Book book : catalog) {
            System.out.println("\n Book: " + book.name + ", Pages: " + book.numberOfPages);
            if (book instanceof Novel) {
                System.out.println("\nType: " + ((Novel) book).getType());
            } else if (book instanceof ArtAlbum) {
                System.out.println("\nPaper quality: " + ((ArtAlbum) book).getPaperQuality());


            }
        }
    }

    @Override
    public String toString() {
        return "LibraryCatalog{" +
                "catalog=" + catalog +
                '}';
    }
}
