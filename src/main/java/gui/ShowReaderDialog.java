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

import model.Lend;
import model.Library;



public class ShowReaderDialog extends JDialog {
	private static final long serialVersionUID = 2097302446842070316L;
	private Library library;
	
	public ShowReaderDialog(Library library) {
    	this.library = library;	
        initUI();
    }	
	
	public final void initUI() {
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));	
		
		add(Box.createRigidArea(new Dimension(0, 6)));
		
		final JTextArea textArea = new JTextArea("");
        textArea.setPreferredSize(new Dimension(200, 200));
        textArea.setEditable(false);
        
        add(textArea);
        
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
        
        JButton showButton = new JButton("Show books of the reader");
		
     
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	textArea.setText("");
            	for (Lend lend : library.getLends()){
            	 if((library.getReaders().get(readersComboBox.getSelectedIndex()))== lend.getReader()){
            		 
            		 textArea.append(lend.toString() +"\n");
            		 
            	 };
                
            }
            }});
        
        showButton.setAlignmentX(0.5f);
		add(showButton);
	
		JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });
        
        add(Box.createRigidArea(new Dimension(0, 10)));
        
        cancelButton.setAlignmentX(0.5f);
        add(cancelButton);


        setModalityType(ModalityType.APPLICATION_MODAL);

        setTitle("Show books of the reader");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 220);
     }
}
