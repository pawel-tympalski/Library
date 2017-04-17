package model;
import java.io.Serializable;


public class Lend implements Serializable {
	private static final long serialVersionUID = -3047099880935306056L;
	private Book book;
	private Reader reader;
	
	public Lend(Book book, Reader reader) {
		super();
		this.book = book;
		this.reader = reader;
	}
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public Reader getReader() {
		return reader;
	}
	
	public void setReader(Reader reader) {
		this.reader = reader;
	}
	
	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((reader == null) ? 0 : reader.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lend other = (Lend) obj;
		if (book == null) {
			if (other.getBook() != null)
				return false;
		} else if (!book.equals(other.getBook()))
			return false;
		if (reader == null) {
			if (other.getReader() != null)
				return false;
		} else if (!reader.equals(other.getReader()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return book + " -> " + reader;
	}

}
