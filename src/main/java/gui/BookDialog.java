package gui;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Book;
import model.Library;


public class BookDialog extends JDialog {
	private static final long serialVersionUID = -6300506413117373568L;
	private Library library;
	
	public BookDialog(Library library) {
    	this.library = library;	
        initUI();
    }
	
	public final void initUI() {
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		add(Box.createRigidArea(new Dimension(0, 6)));
		
		
		JLabel author = new JLabel("Author:");
	    author.setFont(new Font("Serif", Font.BOLD, 12));
	    author.setAlignmentX(0.5f);
	    add(author);
	        
	    add(Box.createRigidArea(new Dimension(0, 6)));   
		
	    final JTextField authorTextField = new JTextField(20);
        add(authorTextField);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        JLabel title = new JLabel("Title:");
	    title.setFont(new Font("Serif", Font.BOLD, 12));
	    title.setAlignmentX(0.5f);
	    add(title);
	    
	    add(Box.createRigidArea(new Dimension(0, 6)));
	    
	    final JTextField titleTextField = new JTextField(20);
        add(titleTextField);
		
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        JLabel isbn = new JLabel("ISBN:");
	    isbn.setFont(new Font("Serif", Font.BOLD, 12));
	    isbn.setAlignmentX(0.5f);
	    add(isbn);
        
	    final JTextField isbnTextField = new JTextField(20);
        add(isbnTextField);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        JLabel egzemplarze = new JLabel("Number of Books:");
	    egzemplarze.setFont(new Font("Serif", Font.BOLD, 12));
	    egzemplarze.setAlignmentX(0.5f);
	    add(egzemplarze);
	    
	    final JTextField egzemplarzeTextField = new JTextField(20);
        add(egzemplarzeTextField);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	library.addBook(new Book(authorTextField.getText(), titleTextField.getText(), isbnTextField.getText(),Integer.parseInt(egzemplarzeTextField.getText()) ));
                dispose();
            }
        });
        
        
        addButton.setAlignmentX(0.5f);
        add(addButton);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        cancelButton.setAlignmentX(0.5f);
        add(cancelButton);
        
        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Book Adding");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 320);
        
	}
}

