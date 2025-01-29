package org.library;

public interface LibraryManageable {
    void addBook(Book book);
    void deleteBook(int index);
    void listBooks();
}
