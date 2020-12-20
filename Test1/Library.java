package bbs515.fall2020.quiz1;

/**
 *  
 * @author <Hasan Hüseyin Niğdeli>
 */ 

import java.util.*;

public class Library 
{
	

	// Burada eksik olan bölümleri tamamlayacaksınız
	
	private String adres;
	private static String oppenningHoursFrom = "9am" ;
	private static String oppenningHoursTo = "5pm" ;
	private Book Books[] = new Book[50];
	private int sayacB = 0;
	
	
    public Library(String adres) {
		// TODO Auto-generated constructor stub
    	this.adres = adres;
    	
    	
	}
    
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		if(sayacB < 50 ) {
			book.Library = this.toString();
			
			Books[sayacB] = book;
			sayacB ++;
			System.out.println("Kitap  rafa eklendi!");
		}else {
			System.out.println("yeterli raf yok kitap eklenemedi!");
		}
		System.out.println("");
		
	}
	
	public static void printOpeningHours() {
		// TODO Auto-generated method stu
		
		System.out.println("Libraries are open daily from "+oppenningHoursFrom+" to "+oppenningHoursTo);
		
	}
	
	public  void printAddress() {
		// TODO Auto-generated method stub
		
		System.out.println(adres);
		
	}
	
	private void borrowBook(String kitap) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<sayacB;i++) {
			if(Books[i].title == kitap ) {
				if (!Books[i].isBorrowed()) {
					
					Books[i].borrowed();
					
					
					
					System.out.println("You successfully borrowed "+kitap);
				}else {
					System.out.println("Sorry, this book is already borrowed.");
				}
			
				
			};
			
		}
		
	}
	
	public void printAvailableBooks() {
		// TODO Auto-generated method stub
		if(sayacB == 0) {
			System.out.println("No books in catalog.");
		}
		for(int i=0;i<50;i++) {
			if(Books[i]!=null && !Books[i].isBorrowed()) {
				System.out.println(Books[i].title);
				
			}
			
		}

		
	}
	
	private void returnBook(String kitap) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<sayacB;i++) {
			if(Books[i].title == kitap ) {
				if (Books[i].isBorrowed()) {
					
					Books[i].returned();
					
					
					
					System.out.println("You successfully returned "+kitap);
				}else {
					System.out.println("Sorry, this book is already returned.");
				}
			
				
			};
			
		}
		
	}

    
	

	public static void main(String[] args) 
    {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        //Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }

	

	
		
	}

	

	




