package org.syachiku.madao.designpatterns.demo1.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.syachiku.madao.designpatterns.demo1.model.Model;

/**
 * The simplest implementation of the MVC View.
 * 
 * @author Ellis
 * @since 2016-05-24
 */
public class View extends JFrame implements ActionListener{
	
	private Model model;
	private JButton helloButton;
	private JButton goodbyeButton;
	
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
		
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye!");
		
		setLayout(new GridBagLayout());
		
		//setting properties for the first button - helloButton
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		
		add(helloButton, gc);
		
		//setting properties for the second button - goodbyeButton
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		
		add(goodbyeButton, gc);
		
		//tying up the listener to the buttons
		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);
		
		
		//Showing the use of anonymous class.
		goodbyeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Sorry to see you go.");
				
			}
			
		});
		
		//sets the window up
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Prints "Hello there!" when the helloButton is pressed, otherwise "some other button."
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		
		if (source == helloButton) {
			System.out.println("Hello there!");
		}
		else {
			System.out.println("Some other button.");
		}
	}
	
	
}
