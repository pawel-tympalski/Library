package model;
import java.io.Serializable;

import javax.swing.JOptionPane;


public class Book implements Serializable {
	private static final long serialVersionUID = 8250921949882699243L;
	private String author;
	private String title;
	private String isbn;
	private int numberOfTotalBooks;
	private int numberOfLentBooks;
	
	
	public Book(String author, String title, String isbn, int numberOfTotalBooks) {
		super();
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.numberOfTotalBooks = numberOfTotalBooks;
		this.numberOfLentBooks = 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + numberOfLentBooks;
		result = prime * result + numberOfTotalBooks;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}	
		Book other = (Book) obj;
		if (author == null) {
			if (other.getAuthor() != null){
				return false;
			}
		} else if (!author.equals(other.getAuthor())){
			return false;
		}
		if (isbn == null) {
			if (other.getIsbn() != null)
				return false;
		} else if (!isbn.equals(other.getIsbn())){
			return false;
		}
		if (numberOfLentBooks != other.getNumberOfLendedBooks()){
			return false;
		}
		if (numberOfTotalBooks != other.getNumberOfTotalBooks()){
			return false;
		}	
		if (title == null) {
			if (other.getTitle() != null)
				return false;
		} else if (!title.equals(other.getTitle())){
			return false;
		}
		
		return true;
	}
	
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String autor) {
		this.author = autor;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
		
	
	public int getNumberOfTotalBooks() {
		return numberOfTotalBooks;
	}

	
	public void setNumberOfTotalBooks(int ilosc_egzemplarzy) {
		this.numberOfTotalBooks = ilosc_egzemplarzy;
	}

	
	public int getNumberOfLendedBooks() {
		return numberOfLentBooks;
	}

	
	public void setnumberOfLendedBooks(int ilosc_wypozyczonych_egzemplarzy) {
		this.numberOfLentBooks = ilosc_wypozyczonych_egzemplarzy;
	}

	boolean lend() {
		if (numberOfTotalBooks - numberOfLentBooks > 0) {
			numberOfLentBooks += 1;
			return true;
		}
		else{
			JOptionPane.showMessageDialog(null, "No more available books");
		return false;
		}
	}

	
	@Override
	public String toString() {
		return author +", " + title + " (total: " + numberOfTotalBooks + ", lent:"
				+ numberOfLentBooks + ")";
	}
	
}
