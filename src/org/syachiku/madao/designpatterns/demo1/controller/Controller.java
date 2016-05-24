package org.syachiku.madao.designpatterns.demo1.controller;

import org.syachiku.madao.designpatterns.demo1.model.Model;
import org.syachiku.madao.designpatterns.demo1.view.View;

public class Controller {
	
	private View  view;
	private Model model;
	
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}
}
