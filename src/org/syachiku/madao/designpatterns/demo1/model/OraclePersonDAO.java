package org.syachiku.madao.designpatterns.demo1.model;

import java.sql.SQLException;
import java.util.List;

public class OraclePersonDAO implements PersonDAO{

	@Override
	public void addPerson(Person person) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getPeople() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deletePerson(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
