import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import model.Book;
import model.Lend;
import model.Library;
import model.Reader;
import service.Deserialize;
import service.Serialize;

public class TestLibrary {
	File file;
	
	@Test
	public void TestSerialization()  {
		file = new File("C:\\Users\\pawel\\workspace\\Library\\src\\test\\resources\\test.ser");
		try {
			file.createNewFile();
			Library library = new Library(new ArrayList<Book>(),new ArrayList<Reader>(),new ArrayList<Lend>());
			Reader reader = new Reader("Jan","Kowalski",50);
			library.addReader(reader);
			Book book = new Book("Robert C. Martin", "Clean Code", "5555555",10);
			library.addBook(book);
			Lend lend = new Lend(book,reader);
			library.addLend(lend);
		
			Serialize serialization = new Serialize();
			serialization.serialize(file, library.getBooks(), library.getReaders(), library.getLends());
			Deserialize deserialization= new Deserialize();
			Library libraryDeserialized;
			libraryDeserialized = (Library)deserialization.deserialize(file);
			
			assertTrue(library.equals(libraryDeserialized));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	@After
	public void deleteFile(){
		if(file.exists()){
			file.delete();
		}
	}
	
}
