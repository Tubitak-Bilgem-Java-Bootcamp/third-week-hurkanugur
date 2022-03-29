import java.util.TreeSet;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) 
    {
        Book book1 = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997, 320);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998, 251);
        Book book3 = new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", 1999, 317);
        Book book4 = new Book("Harry Potter and the Goblet of Fire     ", "J. K. Rowling", 2000, 636);
        Book book5 = new Book("Harry Potter and the Order of the Phoenix", "J. K. Rowling", 2003, 766);

        TreeSet<Book> myBooks = new TreeSet<>();

        myBooks.add(book1);
        myBooks.add(book2);
        myBooks.add(book3);
        myBooks.add(book4);
        myBooks.add(book5);

        for (Book currentBook : myBooks) 
        {
        	System.out.println("Book Name: " + currentBook.getBookName() + "\t|\tAuthor: " + currentBook.getBookAuthorName() + "\t|\tRelease Date: " + currentBook.getBookReleaseDate() + "\t|\tPage Number: " + currentBook.getBookPageNum());
        }

        System.out.println("__________________________________________________________________________________________________________________________\n");

        TreeSet<Book> mySortedBooks = new TreeSet<>(new Comparator<Book>() 
        {
            @Override
            public int compare(Book firstBook, Book secondBook) 
            {
                return firstBook.getBookPageNum() - secondBook.getBookPageNum();
            }
            
        }.reversed());

        mySortedBooks.add(book1);
        mySortedBooks.add(book2);
        mySortedBooks.add(book3);
        mySortedBooks.add(book4);
        mySortedBooks.add(book5);

        for (Book currentBook : mySortedBooks) 
        {
        	System.out.println("Book Name: " + currentBook.getBookName() + "\t|\tAuthor: " + currentBook.getBookAuthorName() + "\t|\tRelease Date: " + currentBook.getBookReleaseDate() + "\t|\tPage Number: " + currentBook.getBookPageNum());
        }
    }
}