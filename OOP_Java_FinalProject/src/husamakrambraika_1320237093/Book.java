// Husam Akram Hamad Braika - 1320237093
package husamakrambraika_1320237093;

import java.io.Serializable;

public class Book implements Serializable {

    private String bookId;
    private String bookName;
    private String bookCategory;
    private Author bookAuthor;
    private String bookPublisher;
    private int bookEditionYear;
    private double bookPrice;
    private int bookQuantity;

    public Book() {
    }

    public Book(String bookId, String bookName, String bookCategory, Author bookAuthor, String bookPublisher, int bookEditionYear, double bookPrice, int bookQuantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookCategory = bookCategory;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookEditionYear = bookEditionYear;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public Author getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(Author bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public int getBookEditionYear() {
        return bookEditionYear;
    }

    public void setBookEditionYear(int bookEditionYear) {
        this.bookEditionYear = bookEditionYear;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    @Override
    public String toString() {
        return Process.YELLOW + "[" + bookId + "] " + Process.CYAN + bookName + Process.RESET
                + " | Category: " + bookCategory + " | Publisher: " + bookPublisher + " | Year: " + bookEditionYear
                + " | Price: $" + bookPrice + " | Quantity: " + bookQuantity
                + "\n    " + Process.CYAN + "Author --> " + Process.RESET + bookAuthor.toString()
                + "\n------------------------------------------------------------------------------------------------";
    }
}
// Husam Akram Hamad Braika - 1320237093
