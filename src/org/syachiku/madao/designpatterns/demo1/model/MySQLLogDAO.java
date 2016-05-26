package org.syachiku.madao.designpatterns.demo1.model;

import java.util.List;

public class MySQLLogDAO implements LogDAO {
	
	/* (non-Javadoc)
	 * @see org.syachiku.madao.designpatterns.demo1.model.LogDAO#addEntry(java.lang.String)
	 */
	@Override
	public void addEntry(String message){
		
	}
	
	/* (non-Javadoc)
	 * @see org.syachiku.madao.designpatterns.demo1.model.LogDAO#getEntries(int)
	 */
	@Override
	public List<Log> getEntries(int number){
		
		return null;
	}
}
