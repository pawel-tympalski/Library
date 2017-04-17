package gui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import model.Book;
import model.Lend;
import model.Library;
import model.Reader;
import service.Serialize;



public class MainFrame extends JFrame implements Serializable {
	private static final long serialVersionUID = 3167090132551198602L;
	
	
	public final void initUI(final Library library) {
		
		
		JPanel panel = new JPanel();
		final JTextArea textArea = new JTextArea("");
        textArea.setPreferredSize(new Dimension(620, 700));
        textArea.setEditable(false);
        
        
        panel.add(textArea);
        
        add(panel);
        pack();
       
        JMenuBar menubar = new JMenuBar();
       
        JMenu menuLibrary = new JMenu("Library");
        menuLibrary.setMnemonic(KeyEvent.VK_L);
        
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit program");
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to save data before leaving program?","Warning",JOptionPane.YES_NO_OPTION);
        		if(dialogResult == JOptionPane.YES_OPTION){
        			SaveDataDialog saveDataDialog = new SaveDataDialog();
        			while(true){
        				try{
        					File file = saveDataDialog.getFile();
        					Serialize serialize = new Serialize();
        					serialize.serialize(file,library.getBooks(),library.getReaders(),library.getLends());
        					break;
        				}
        				catch(FileNotFoundException e1){
        					JOptionPane.showMessageDialog(null, "File Not found, Try wite again");
        					e1.printStackTrace();
        				}
        				catch(IOException e2){
        					JOptionPane.showMessageDialog(null, "Output Error, Try write again");
        					e2.printStackTrace();
        				}
        			}
        		}
            	
            	
            	
        		System.exit(0);
            }
        });

        
        JMenuItem usersMenuItem = new JMenuItem("Show Readers");
        usersMenuItem.setMnemonic(KeyEvent.VK_R);
        usersMenuItem.setToolTipText("List of Readers");
        usersMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Reader c: library.getReaders()) {  
            		textArea.append(c+"\n");
            	}		
            }		  
        });
        
        
        JMenuItem booksMenuItem = new JMenuItem("Show Books");
        booksMenuItem.setMnemonic(KeyEvent.VK_B);
        booksMenuItem.setToolTipText("List Of Books");
        booksMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Book k: library.getBooks()) {  
            		textArea.append(k+"\n");
            	}		
            }		  
        });

       
        JMenuItem lendsMenuItem = new JMenuItem("Show Lends");
        lendsMenuItem.setMnemonic(KeyEvent.VK_L);
        lendsMenuItem.setToolTipText("List Of Lends");
        lendsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Lend k: library.getLends()) {  
            		textArea.append(k+"\n");
            	}		
            }		  
        });
        
        
        JMenuItem newReaderMenuItem = new JMenuItem("Add new Reader");
        newReaderMenuItem.setMnemonic(KeyEvent.VK_A);
        newReaderMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ReaderDialog ad = new ReaderDialog(library);
                ad.setVisible(true);
            }
        });
        
        
        
        
        
        
        JMenuItem lendBookMenuItem = new JMenuItem("Lend Book");
        lendBookMenuItem.setMnemonic(KeyEvent.VK_O);
        lendBookMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                LendDialog ad = new LendDialog(library);
                ad.setVisible(true);
            }
        });
        
        
        
        JMenuItem addBookMenuItem = new JMenuItem("Add Book");
        addBookMenuItem.setMnemonic(KeyEvent.VK_D);
        addBookMenuItem.addActionListener( new ActionListener(){
        	public void actionPerformed(ActionEvent event){
        		BookDialog bk = new BookDialog(library);
        		bk.setVisible(true);
        	}
        });
        
        		
        JMenuItem deleteReaderMenuItem = new JMenuItem("Delete Reader");		
        deleteReaderMenuItem.setMnemonic(KeyEvent.VK_A);
        deleteReaderMenuItem.addActionListener( new ActionListener(){
        	public void actionPerformed(ActionEvent event){
        		DeleteReaderDialog drd = new DeleteReaderDialog(library);
        		drd.setVisible(true);
        	}
        });
        
       
        JMenuItem showReaderMenuItem = new JMenuItem("Books borrowed by Reader");		
        showReaderMenuItem.addActionListener( new ActionListener(){
        	public void actionPerformed(ActionEvent event){
        		ShowReaderDialog srd = new ShowReaderDialog(library);
        		srd.setVisible(true);
        		
        	}
        });
        
       
        menuLibrary.add(lendBookMenuItem);
        menuLibrary.addSeparator();
        menuLibrary.add(newReaderMenuItem);
        menuLibrary.add(addBookMenuItem);
        menuLibrary.add(deleteReaderMenuItem);
        menuLibrary.addSeparator();
        menuLibrary.add(showReaderMenuItem);
        menuLibrary.add(usersMenuItem);        
        menuLibrary.add(booksMenuItem);
        menuLibrary.add(lendsMenuItem);
        menuLibrary.addSeparator();
        menuLibrary.add(exitMenuItem);

       
        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        
       
        JMenuItem about = new JMenuItem("About program");
        about.setMnemonic(KeyEvent.VK_P);
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                AboutDialog ad = new AboutDialog();
                ad.setVisible(true);
            }
        });

       
        help.add(about);
        
        
        menubar.add(menuLibrary);
        menubar.add(help);

        setJMenuBar(menubar);
        
        setTitle("Library");
        setSize(650, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        addWindowListener(new WindowAdapter(){
        	public void windowClosing(WindowEvent e){
        		int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to save data before leaving program?","Warning",JOptionPane.YES_NO_OPTION);
        		if(dialogResult == JOptionPane.YES_OPTION){
        			SaveDataDialog saveDataDialog = new SaveDataDialog();
        			while(true){
        				try{
        					File file = saveDataDialog.getFile();
        					Serialize serialize = new Serialize();
        					serialize.serialize(file,library.getBooks(),library.getReaders(),library.getLends());
        					break;
        				}
        				catch(FileNotFoundException e1){
        					JOptionPane.showMessageDialog(null, "File Not found, Try wite again");
        					e1.printStackTrace();
        				}
        				catch(IOException e2){
        					JOptionPane.showMessageDialog(null, "Output Error, Try write again");
        					e2.printStackTrace();
        				}
        			}
        		}
        		
        	}
        });
    }
}
