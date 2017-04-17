package gui;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import model.Library;
import model.Reader;


public class LendDialog extends JDialog {
	private static final long serialVersionUID = -4626991721261309951L;
	private Library library;
	
    public LendDialog(Library library) {
    	this.library = library;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Readers:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
        add(fname);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox readersComboBox = new JComboBox(library.getReaders().toArray());
        readersComboBox.setSelectedIndex(-1);
        readersComboBox.setPreferredSize(new Dimension(450, 22));
        readersComboBox.setMaximumSize(new Dimension(450, 22));
        add(readersComboBox);
        
        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel lname = new JLabel("Books:");
        lname.setFont(new Font("Serif", Font.BOLD, 12));
        lname.setAlignmentX(0.5f);
        add(lname);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox booksComboBox = new JComboBox(library.getBooks().toArray());
        booksComboBox.setSelectedIndex(-1);
        booksComboBox.setPreferredSize(new Dimension(450, 22));
        booksComboBox.setMaximumSize(new Dimension(450, 22));
        add(booksComboBox);

        add(Box.createRigidArea(new Dimension(0, 10)));

        JButton lendButton = new JButton("Lend");
        
       
        lendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	library.lendBook(library.getBooks().get(booksComboBox.getSelectedIndex()), library.getReaders().get(readersComboBox.getSelectedIndex()));
                dispose();
            }
        });

        lendButton.setAlignmentX(0.5f);
        add(lendButton);
        
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

        setTitle("Lend book");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
    }
}
