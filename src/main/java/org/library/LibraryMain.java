package org.library;

public class LibraryMain {
    public static void main( String[] args )
    {

        LibraryCatalog catalog= new LibraryCatalog();

        Book book1 = new Novel("Ion", 200, "Comedy");
        Book book2 = new ArtAlbum("Morometii", 190, "Recycling paper");
        Book book3 = new Novel("Acolo unde canta racii", 200, "Romance");
        Book book4 = new ArtAlbum("Iarna pe ulita", 20, "Card paper");

        System.out.println("\nView all added books in catalog");
        catalog.addBook(book1);
        catalog.addBook(book2);
        catalog.addBook(book3);
        catalog.addBook(book4);

        System.out.println("\nView the available books: ");
        catalog.listBooks();

        System.out.println("\nRemove Book: " + book1);
        catalog.removeBook(book1);

        System.out.println("The remainig books are");
        catalog.listBooks();

    }
}
