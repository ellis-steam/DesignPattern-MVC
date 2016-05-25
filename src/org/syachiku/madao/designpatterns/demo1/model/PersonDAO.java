package org.syachiku.madao.designpatterns.demo1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created for practice of DAO pattern.
 * 
 * @author Ellis
 * @since 2016-05-25
 * @see Person
 */
public class PersonDAO {
	
	/**
	 * Inserts a row of person into the people table.
	 * 
	 * @param person the person to insert into the database.
	 * @throws SQLException When the sql goes wrong.
	 */
	public void addPerson(Person person) throws SQLException{
		
		Connection conn = Database.getInstance().getConnection();
		
		PreparedStatement p = conn.prepareStatement("insert into people (name, password) values (?, ?)");
		
		p.setString(1, person.getName());
		p.setString(2, person.getPassword());
		
		p.executeUpdate();
		p.close();
		
	}
	
	/**
	 * Retrieve a person back with the id passed in this method.
	 * 
	 * @param id int number to specify the person which id to retrieve. 
	 * @return the Person with the id passed in or null if not found in the database.
	 */
	public Person getPerson(int id){
		return null;
	}
	
	/**
	 * Retrieve all the people in the database.
	 * 
	 * @return a List of person, which contains all the people in the database.
	 * @throws SQLException When sql is wrong.
	 */
	public List<Person> getPeople() throws SQLException{
		List<Person> people = new ArrayList<>();
		Connection conn = Database.getInstance().getConnection();
		
		String sql = "select id, name, password from people order by id";
		Statement selectStatement = conn.createStatement();
		
		ResultSet results = selectStatement.executeQuery(sql);
		
		while(results.next()){
			int id = results.getInt("id");
			String name = results.getString("name");
			String password = results.getString("password");
			
			Person person = new Person(id, name, password);
			people.add(person);
		}
		
		results.close();
		selectStatement.close();
		
		return people;
	}
	
	/**
	 * Updates the person that is specified by the id passed in.
	 * 
	 * @param person the person bean.
	 */
	public void updatePerson(Person person){
		
	}
	
	/**
	 * Deletes a person from the database with the specified id.
	 * 
	 * @param id the int number to specify the person with which id to delete.
	 */
	public void deletePerson(int id){
		
	}
}
