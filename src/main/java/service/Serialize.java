package service;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Book;
import model.Lend;
import model.Library;
import model.Reader;

public class Serialize {
	private FileOutputStream fileOut;
	private ObjectOutputStream out;
	
	public void serialize(File file,ArrayList<Book> books, ArrayList<Reader> readers, ArrayList<Lend> lenders) throws IOException{
		try{
			Library library = new Library(books,readers,lenders);
			fileOut = new FileOutputStream(file.getPath());
			out = new ObjectOutputStream(fileOut);
			out.writeObject(library);
		}
		finally{
			out.close();
			fileOut.close();
		}
	}
}
