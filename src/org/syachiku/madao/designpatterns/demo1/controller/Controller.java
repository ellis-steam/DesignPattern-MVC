package org.syachiku.madao.designpatterns.demo1.controller;

import java.sql.SQLException;

import org.syachiku.madao.designpatterns.demo1.model.Model;
import org.syachiku.madao.designpatterns.demo1.model.Person;
import org.syachiku.madao.designpatterns.demo1.model.PersonDAO;
import org.syachiku.madao.designpatterns.demo1.view.CreateUserEvent;
import org.syachiku.madao.designpatterns.demo1.view.CreateUserListener;
import org.syachiku.madao.designpatterns.demo1.view.View;

/**
 * The simplest implementation of the MVC controller.
 * 
 * @author Ellis
 * @since 2016-05-24
 */
public class Controller implements CreateUserListener{
	
	private View  view;
	private Model model;
	
	private PersonDAO personDAO = new PersonDAO();
	
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

	@Override
	public void userCreated(CreateUserEvent event) {
		System.out.println("Login event received. ");
		System.out.println(event.getName() + ": " + event.getPassword());

		
		try {
			personDAO.addPerson(new Person(event.getName(), event.getPassword()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
