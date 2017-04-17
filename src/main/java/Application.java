import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import gui.MainFrame;
import gui.OpenDataDialog;
import model.Book;
import service.Deserialize;
import service.IDGenerator;
import model.Library;
import model.Reader;

public class Application {

	public static void main(String[] args) {
		MainFrame mainFrame;
		Library library;
		File file;
    	do{
    		OpenDataDialog openDataDialog = new OpenDataDialog();
    		file = openDataDialog.getFile();
    		if(file == null){
    			break;
    		}
    		if(!file.exists()){
    			JOptionPane.showMessageDialog(null, "File does not exist, Try again");
    		}
    	}
    	while(!file.exists());
    	
		
    	if(file != null && file.exists()){ 
    		Deserialize deserialization = new Deserialize();
    		try{
    			Object obj = deserialization.deserialize(file);
    			library = (Library)obj;
    			mainFrame = new MainFrame();
    			mainFrame.initUI(library);
    			mainFrame.setVisible(true);
    		
    		}catch(ClassNotFoundException e){
    			JOptionPane.showMessageDialog(null, "Proper object not found, Run program again");
    			e.printStackTrace();
    		}
    		catch(IOException e){
    			JOptionPane.showMessageDialog(null, "Input Error, Run program again");
    			e.printStackTrace();
    		}
    	}
    		else {
    			mainFrame = new MainFrame();
    			library = new Library();
    			sampleData(library);
    			mainFrame.initUI(library);
    			mainFrame.setVisible(true);
    	}
				
	}
	public static void sampleData(Library library){
		library.addReader(new Reader("Jan", "Kowalski", IDGenerator.generateID()));
		library.addReader(new Reader("Dariusz", "Malinowski", IDGenerator.generateID()));
		library.addReader(new Reader("Wojciech", "Kaminski", IDGenerator.generateID()));
		library.addBook(new Book(" Cay S. Horstmann", "Core Java Volume I--Fundamentals", "11111111", 5));
		library.addBook(new Book("Bruce Eckel", "Thinking in Java (4th Edition)", "22222222", 2));
		library.addBook(new Book("Robert C. Martin", "Clean Code", "5555555", 1));
	}
}
