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
public class MySQLPersonDAO implements PersonDAO {
	
	/* (non-Javadoc)
	 * @see org.syachiku.madao.designpatterns.demo1.model.PersonDAO#addPerson(org.syachiku.madao.designpatterns.demo1.model.Person)
	 */
	@Override
	public void addPerson(Person person) throws SQLException{
		
		Connection conn = Database.getInstance().getConnection();
		
		PreparedStatement p = conn.prepareStatement("insert into people (name, password) values (?, ?)");
		
		p.setString(1, person.getName());
		p.setString(2, person.getPassword());
		
		p.executeUpdate();
		p.close();
		
	}
	
	/* (non-Javadoc)
	 * @see org.syachiku.madao.designpatterns.demo1.model.PersonDAO#getPerson(int)
	 */
	@Override
	public Person getPerson(int id){
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.syachiku.madao.designpatterns.demo1.model.PersonDAO#getPeople()
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see org.syachiku.madao.designpatterns.demo1.model.PersonDAO#updatePerson(org.syachiku.madao.designpatterns.demo1.model.Person)
	 */
	@Override
	public void updatePerson(Person person){
		
	}
	
	/* (non-Javadoc)
	 * @see org.syachiku.madao.designpatterns.demo1.model.PersonDAO#deletePerson(int)
	 */
	@Override
	public int deletePerson(int id) throws SQLException{
		Connection conn = Database.getInstance().getConnection();
		
		PreparedStatement p = conn.prepareStatement("delete from people where id = ?");
		p.setInt(1, id);
		
		int deleted = p.executeUpdate();
		
		p.close();
		
		return deleted;
	}
	
	/* (non-Javadoc)
	 * @see org.syachiku.madao.designpatterns.demo1.model.PersonDAO#deleteAll()
	 */
	@Override
	public int deleteAll() throws SQLException{
		Connection conn = Database.getInstance().getConnection();
		
		PreparedStatement p = conn.prepareStatement("delete from people");
		
		int deleted = p.executeUpdate();
		
		p.close();
		
		return deleted;
	}
}
