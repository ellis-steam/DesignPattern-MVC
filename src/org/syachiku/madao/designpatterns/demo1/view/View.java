package org.syachiku.madao.designpatterns.demo1.view;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import org.syachiku.madao.designpatterns.demo1.model.Model;

/**
 * The simplest implementation of the MVC View.
 * 
 * @author Ellis
 * @since 2016-05-24
 */
public class View extends JFrame{
	
	private Model model;
	
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
	}
	
	
}
