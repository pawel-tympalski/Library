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

import model.Library;
import model.Reader;
import service.IDGenerator;


public class ReaderDialog extends JDialog {
	private static final long serialVersionUID = 9092551044456132035L;
	private Library library;
	
    public ReaderDialog(Library library) {
    	this.library = library;	
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel fname = new JLabel("Name:");
        fname.setFont(new Font("Serif", Font.BOLD, 12));
        fname.setAlignmentX(0.5f);
        add(fname);

        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField fnameTextField = new JTextField(20);
        add(fnameTextField);
        
        add(Box.createRigidArea(new Dimension(0, 6)));

        JLabel lname = new JLabel("Surname:");
        lname.setFont(new Font("Serif", Font.BOLD, 12));
        lname.setAlignmentX(0.5f);
        add(lname);
        
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JTextField lnameTextField = new JTextField(20);
        add(lnameTextField);

        add(Box.createRigidArea(new Dimension(0, 10)));

        JButton addButton = new JButton("Add");
        
       
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	library.addReader(new Reader(fnameTextField.getText(), lnameTextField.getText(), IDGenerator.generateID()));
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

        setTitle("Add Reader");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 220);
    }
}
