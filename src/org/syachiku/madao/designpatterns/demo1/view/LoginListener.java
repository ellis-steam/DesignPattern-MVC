package org.syachiku.madao.designpatterns.demo1.view;

/**
 * Custom listener to observe login activities.
 * 
 * @author Ellis
 * @since 2016-05-24
 */
public interface LoginListener {
	/**
	 * Actions to perform when login happens.
	 */
	public void loginPerformed(LoginFormEvent event);
}
