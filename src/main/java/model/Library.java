package model;
import java.io.Serializable;
import java.util.ArrayList;

import service.IDGenerator;

public class Library implements Serializable {
	private static final long serialVersionUID = 3167090132551198602L;
	private ArrayList<Book> books;
	private ArrayList<Reader> readers;
	private ArrayList<Lend> lends;
	long numberIdentityOfReader;
	
	public Library() {
		this.books = new ArrayList<Book>();
		this.readers = new ArrayList<Reader>();
		this.lends = new ArrayList<Lend>();
		this.numberIdentityOfReader = 1;
		
	}
	
	public Library(ArrayList<Book> books, ArrayList<Reader> readers, ArrayList<Lend> lends){
		this.books = books;
		this.readers = readers;
		this.lends = lends;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(this == obj){
			return true;
		}
		if (getClass() != obj.getClass()){
			return false;
		}	
		Library library = (Library)obj;
		
		if(books.size() != library.getBooks().size()){
			return false;
		}
		int numberOfBooks = books.size();
		ArrayList<Book> listOfBooks = library.getBooks();
		for(Book book : books){
			
			for(Book book2 : listOfBooks){
				System.out.println(book2);
				if(book.equals(book2)){
					numberOfBooks--;
				}
			}
		}
		System.out.println(numberOfBooks);
		if(numberOfBooks != 0){
			return false;
		}
		
		if(readers.size() != library.getReaders().size()){
			return false;
		}
		int numberOfReaders = readers.size();
		ArrayList<Reader> listOfReaders = library.getReaders();
		for(Reader reader : readers){
			for(Reader reader2 : listOfReaders){
				if(reader.equals(reader2)){
					numberOfReaders--;
				}
			}
		}
		if(numberOfReaders != 0){
			return false;
		}
		
		if(lends.size() != library.getLends().size()){
			return false;
		}
		int numberOfLends = lends.size();
		ArrayList<Lend> listOfLends = library.getLends();
		for(Lend lend : lends){
			for(Lend lend2 : listOfLends){
				if(lend.equals(lend2)){
					numberOfLends--;
				}
			}
		}
		if(numberOfLends != 0){
			return false;
		}
		return true;
	}
	
	
	
	
	public ArrayList<Book> getBooks() {
		return books;
	}


	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	
	public ArrayList<Reader> getReaders() {
		return readers;
	}

	
	public void setReaders(ArrayList<Reader> readers) {
		this.readers = readers;
	}

	
	public ArrayList<Lend> getLends() {
		return lends;
	}

	
	public void setLends(ArrayList<Lend> lends) {
		this.lends = lends;
	}

	public long getNumberIdentityOfReader() {
		return numberIdentityOfReader;
	}

	public void setNumberIdentityOfReader(long numberIdentityOfReader) {
		this.numberIdentityOfReader = numberIdentityOfReader;
	}
	
	public long setNextNumberIdentityOfReader() {
		return numberIdentityOfReader++;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}

	public void addReader(Reader reader) {
		readers.add(reader);
	}

	public void addLend(Lend lend) {
		lends.add(lend);
	}

	public void removeBook(Book book) {
		books.remove(book);
	}

	public void removeReader(Reader reader) {
		readers.remove(reader);
		IDGenerator.getBackNumberID(reader);
	}

	public void removeLend(Lend lend) {
		lends.remove(lend);
	}
	
	public boolean lendBook(Book book, Reader reader) {
		if (book.lend()) {
			addLend(new Lend(book, reader));
			return true;
		}
		else 
			return false;
	}
	
}
