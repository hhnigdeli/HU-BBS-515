package bbs515.fall2020.quiz1;

/**
 *  
 * @author Hasan Hüseyin Niğdeli
 */ 
 
public class Book 
{
    String title;
    boolean borrowed = false;
    boolean returned;
    String Library;

    // Creates a new Book
    public Book(String title) 
    {
        // Burayı tamamlayacaksınız
    	this.title = title;

    }
   
    // Marks the book as rented
    public void borrowed() 
    {
        // Burayı tamamlayacaksınız
    	borrowed = true;
    	
    }
   
    // Marks the book as not rented
    public void returned() 
    {
    	// Burayı tamamlayacaksınız
    	returned = true;
    	borrowed = false;
    }
   
    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() 
    {
        // Burayı tamamlayacaksınız
    	return borrowed;
    }
   
    // Returns the title of the book
    public String getTitle() 
    {
        // Burayı tamamlayacaksınız
    	return title;
    }
    

    public static void main(String[] arguments) 
    {
        // Small test of the Book class
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.borrowed();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }
} 