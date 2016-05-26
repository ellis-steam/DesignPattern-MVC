package org.syachiku.madao.designpatterns.demo1.model;

import java.sql.SQLException;
import java.util.List;

public interface PersonDAO {

	/**
	 * Inserts a row of person into the people table.
	 * 
	 * @param person the person to insert into the database.
	 * @throws SQLException When the sql goes wrong.
	 */
	void addPerson(Person person) throws SQLException;

	/**
	 * Retrieve a person back with the id passed in this method.
	 * 
	 * @param id int number to specify the person which id to retrieve. 
	 * @return the Person with the id passed in or null if not found in the database.
	 */
	Person getPerson(int id);

	/**
	 * Retrieve all the people in the database.
	 * 
	 * @return a List of person, which contains all the people in the database.
	 * @throws SQLException When sql is wrong.
	 */
	List<Person> getPeople() throws SQLException;

	/**
	 * Updates the person that is specified by the id passed in.
	 * 
	 * @param person the person bean.
	 */
	void updatePerson(Person person);

	/**
	 * Deletes a person from the database with the specified id.
	 * 
	 * @param id the int number to specify the person with which id to delete.
	 * @throws SQLException 
	 */
	int deletePerson(int id) throws SQLException;

	/**
	 * Cleans the people table up.
	 * 
	 * @return the number of rows deleted.
	 * @throws SQLException when SQL error happens.
	 */
	int deleteAll() throws SQLException;

}