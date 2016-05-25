package org.syachiku.madao.designpatterns.demo1.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.syachiku.madao.designpatterns.demo1.model.Database;
import org.syachiku.madao.designpatterns.demo1.model.Model;

/**
 * The simplest implementation of the MVC View.
 * 
 * @author Ellis
 * @since 2016-05-24
 */
public class View extends JFrame implements ActionListener{
	
	private Model model;
	private JButton okButton;
	private JTextField nameField;
	private JPasswordField passField;
	private JPasswordField repeatPassField;
	
	private CreateUserListener loginListener;
	
	/**
	 * View constructor that takes model which to display or work with.
	 * 
	 * @param model the model to display to work with.
	 * @throws HeadlessException only be thrown when the running device a keyboard, display or mouse.
	 * @see Model
	 */
	public View(Model model) throws HeadlessException {
		super("MVC Demo");
		this.model = model;
		
		nameField = new JTextField(10);
		passField = new JPasswordField(10);
		repeatPassField = new JPasswordField(10);
		okButton = new JButton("Create user");
		
		setLayout(new GridBagLayout());
		
		//setting properties for the first button - helloButton
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(100, 0, 0, 10);
		gc.fill = GridBagConstraints.NONE;
		
		add(new JLabel("Name: "), gc);
		
		//setting properties for the second button - goodbyeButton
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx = 2;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(100, 0, 0, 0);
		gc.fill = GridBagConstraints.NONE;
		
		add(nameField, gc);
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 10);
		gc.fill = GridBagConstraints.NONE;
		
		add(new JLabel("Password: "), gc);
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 2;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.NONE;
		
		add(passField, gc);
		
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx = 1;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 10);
		gc.fill = GridBagConstraints.NONE;
		
		add(new JLabel("Repeat password: "), gc);
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 2;
		gc.gridy = 3;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill = GridBagConstraints.NONE;
		
		add(repeatPassField, gc);
		
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 2;
		gc.gridy = 4;
		gc.weightx = 1;
		gc.weighty = 100;
		gc.fill = GridBagConstraints.NONE;
		
		add(okButton, gc);
		
		//tying up the listener to the buttons
		okButton.addActionListener(this);
		
		//Database db = new Database();
		//Database db = Database.getInstance();
		
		addWindowListener(new WindowAdapter(){
			
			@Override
			public void windowOpened(WindowEvent e){
			try {
				Database.getInstance().connect();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
			
			@Override
			public void windowClosing(WindowEvent e){
			Database.getInstance().disconnect();
			}
			
		});
		
		//sets the window up
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String password = new String(passField.getPassword());
		String repeat = new String(repeatPassField.getPassword());
		
		if (password.equals(repeat)){
			String name = nameField.getText();
			
			fireLoginEvent(new CreateUserEvent(name, password));
		}
		else {
			JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void setLoginListener(CreateUserListener loginListener) {
		this.loginListener = loginListener;
	}
	
	public void fireLoginEvent(CreateUserEvent event){
		if (loginListener != null) {
			loginListener.userCreated(event);
		}
	}
	
//	//Showing the use of anonymous class.
//	goodbyeButton.addActionListener(new ActionListener(){
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			System.out.println("Sorry to see you go.");
//			
//		}
//		
//	});
}


