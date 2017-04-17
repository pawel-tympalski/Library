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
import javax.swing.JTextArea;

import model.Library;



public class DeleteReaderDialog extends JDialog {
	private static final long serialVersionUID = 5054279759040801754L;
	private Library library;
	
	public DeleteReaderDialog(Library library) {
    	this.library = library;	
        initUI();
    }
	
	public final void initUI() {
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		add(Box.createRigidArea(new Dimension(0, 6)));
		
		JLabel readers = new JLabel("Readers:");
        readers.setFont(new Font("Serif", Font.BOLD, 12));
        readers.setAlignmentX(0.5f);
        add(readers);
		
        add(Box.createRigidArea(new Dimension(0, 6)));
        
        final JComboBox readersComboBox = new JComboBox(library.getReaders().toArray());
        readersComboBox.setSelectedIndex(-1);
        readersComboBox.setPreferredSize(new Dimension(450, 22));
        readersComboBox.setMaximumSize(new Dimension(450, 22));
        add(readersComboBox);
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        JButton delButton = new JButton("Remove Reader");
        delButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	library.removeReader( library.getReaders().get(readersComboBox.getSelectedIndex()));
            	dispose();
            }
        });
	

		delButton.setAlignmentX(0.5f);
		add(delButton);
	
		JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        cancelButton.setAlignmentX(0.5f);
        add(cancelButton);

        final JTextArea textArea = new JTextArea("");
        textArea.setPreferredSize(new Dimension(550, 600));
        textArea.setEditable(false);
        
        add(textArea);
        
        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Delete Reader");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
	
	
	}

}
