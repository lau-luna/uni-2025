/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Insert your name here.)
 * @version (Insert today's date here.)
 */
class Book {
    // The fields.
    private String author;
    private String title;
    private int pages;
    private String refNumber;
    private int borrowed; // Number of times that the book has been borrowed
    private boolean courseText; // Indicates that the book is being used for a course text book

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String bookAuthor, String bookTitle, int bookPages, boolean isCourseText) {
        author = bookAuthor;
        title = bookTitle;
        this.pages = bookPages;
        this.refNumber = "";
        this.courseText = isCourseText;
    }

    // Add the methods here ...

    // Return the author
    public String getAuthor() {
        return this.author;
    }

    // Return the title
    public String getTitle() {
        return this.title;
    }

    // Return the pages
    public int getPages() {
        return this.pages;
    }

    // Print the author
    public void printAuthor() {
        System.out.println(this.author);
    }

    // Print the author
    public void printTitle() {
        System.out.println(this.title);
    }

    // Print all the book details
    public void printDetails() {
        System.out.println("_________________________");
        System.out.println("| Title: " + this.title);
        System.out.println("| Author: " + this.author);
        System.out.println("| Pages: " + this.pages);
        if (this.refNumber.length() > 0) {
            System.out.println("| Reference Number: " + this.refNumber);
        } else {
            System.out.println("| Reference Number: " + "ZZZ");
        }
        System.out.println("------------------------");
    }

    // Set a ref number
    public void setRefNumber(String ref) {
        if (ref.length() > 2) {
            this.refNumber = ref;
        } else {
            System.out.println("! Reference number is less than 3");
        }
    }

    // Get the ref number
    public String getRefNumber() {
        return this.refNumber;
    }

    // Borrow the book
    public void borrow() {
        this.borrowed++;
    }

    // Get the times borrowed number
    public int getBorrowed() {
        return this.borrowed;
    }

    // Get if it's a course text or not
    public boolean isCourseText() {
        return this.courseText;
    }
}
