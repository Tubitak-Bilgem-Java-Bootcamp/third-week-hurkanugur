public class Book implements Comparable<Book> 
{

    private final String bookName;
    private final String bookAuthorName;
    
    private final int releaseDate;
    private final int bookPageNum;

    
    public Book(String bookName, String bookAuthorName, int releaseDate, int bookPageNum) 
    {
        this.bookName = bookName;
        this.bookPageNum = bookPageNum;
        this.bookAuthorName = bookAuthorName;
        this.releaseDate = releaseDate;
    }
    
    
    @Override
    public int compareTo(Book bookObjectToBeCompared) 
    {
        return (this.getBookName()).compareTo(bookObjectToBeCompared.getBookName());
    }


    public String getBookName() 
    {
        return this.bookName;
    }
    
    
    public String getBookAuthorName() 
    {
        return this.bookAuthorName;
    }
    
    
    public int getBookReleaseDate() 
    {
        return this.releaseDate;
    }
    
    
    public int getBookPageNum()
    {
        return this.bookPageNum;
    }
}