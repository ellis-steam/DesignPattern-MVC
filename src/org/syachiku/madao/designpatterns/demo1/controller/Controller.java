package org.syachiku.madao.designpatterns.demo1.controller;

import java.sql.SQLException;

import org.syachiku.madao.designpatterns.demo1.model.MySQLDAOFactory;
import org.syachiku.madao.designpatterns.demo1.model.DAOFactory;
import org.syachiku.madao.designpatterns.demo1.model.Database;
import org.syachiku.madao.designpatterns.demo1.model.Model;
import org.syachiku.madao.designpatterns.demo1.model.Person;
import org.syachiku.madao.designpatterns.demo1.model.PersonDAO;
import org.syachiku.madao.designpatterns.demo1.view.AppListener;
import org.syachiku.madao.designpatterns.demo1.view.CreateUserEvent;
import org.syachiku.madao.designpatterns.demo1.view.CreateUserListener;
import org.syachiku.madao.designpatterns.demo1.view.SaveListener;
import org.syachiku.madao.designpatterns.demo1.view.View;

/**
 * The simplest implementation of the MVC controller.
 * 
 * @author Ellis
 * @since 2016-05-24
 */
public class Controller implements CreateUserListener, SaveListener, AppListener{
	
	private View  view;
	private Model model;
	
	
	//replaced by DAOFactory
	//private PersonDAO personDAO = MySQLDAOFactory.getPersonDAO();
	
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
	public void onUserCreated(CreateUserEvent event) {
		model.addPerson(new Person(event.getName(), event.getPassword()));
		/*
		System.out.println("Login event received. ");
		System.out.println(event.getName() + ": " + event.getPassword());
		
		DAOFactory factory = DAOFactory .getFactory(DAOFactory.MYSQL);
		
		PersonDAO personDAO = factory.getPersonDAO();
		
		try {
			personDAO.addPerson(new Person(event.getName(), event.getPassword()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/	
	}
	@Override
	public void onSave() {
		try {
			model.save();
		} catch (Exception e) {
			view.showError("Error saving to database.");
		}
	}

	@Override
	public void onOpen() {
		try {
			Database.getInstance().connect();
		} catch (Exception e) {
			view.showError("Cannot connect to database.");
		}
		
		try {
			model.load();
		} catch (Exception e) {
			view.showError("Error loading data from database.");
		}
	}

	@Override
	public void onClose() {
		Database.getInstance().disconnect();
	}
}
