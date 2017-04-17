package gui;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveDataDialog {
	JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "Serialized Data", "ser");
    
    public File getFile() throws IOException{
    	File file = null;
    	chooser.setFileFilter(filter);
        int returnVal = chooser.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
          file= chooser.getSelectedFile();
        }
        if(!file.exists()){
        	file.createNewFile();
        }
        return file;
        
    }
}
