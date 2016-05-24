package org.syachiku.madao.designpatterns.demo1.controller;

import org.syachiku.madao.designpatterns.demo1.model.Model;
import org.syachiku.madao.designpatterns.demo1.view.View;

/**
 * The simplest implementation of the MVC controller.
 * 
 * @author Ellis
 * @since 2016-05-24
 */
public class Controller {
	
	private View  view;
	private Model model;
	
	/**
	 * Controller constructor that takes view and model as parameter. 
	 * 
	 * @param view the view to controller.
	 * @param model the model to work with.
	 * 
	 * @see View
	 * @see Model
	 */
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}
}
