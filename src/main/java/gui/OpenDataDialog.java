package gui;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenDataDialog {
	
	JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "Serialized Data", "ser");
    
    public File getFile(){
    	File file = null;
    	chooser.setFileFilter(filter);
    	JOptionPane.showMessageDialog(null, "Choose serializable file to open, or create new Library");
    	
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
          file= chooser.getSelectedFile();
        }
       
       
        return file;
        
    }
     
}
