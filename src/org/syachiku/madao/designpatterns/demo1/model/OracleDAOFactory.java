package org.syachiku.madao.designpatterns.demo1.model;

public class OracleDAOFactory extends DAOFactory{

	@Override
	public PersonDAO getPersonDAO() {
		return new OraclePersonDAO();
	}

	@Override
	public LogDAO getLogDAO() {
		return new OracleLogDAO();
	}
	
}
