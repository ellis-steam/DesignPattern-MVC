package org.syachiku.madao.designpatterns.demo1.view;

/**
 * Bean to store information about the login event.
 * 
 * @author Ellis
 * @since 2016-05-24
 */
public class LoginFormEvent {
	private String name;
	private String password;

	public LoginFormEvent(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
