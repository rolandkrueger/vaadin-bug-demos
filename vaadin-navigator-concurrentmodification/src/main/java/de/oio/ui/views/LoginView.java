package de.oio.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;

@SpringView(name = "login")
public class LoginView extends Panel implements View {


	public LoginView() {
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(new Label("Please enter your credentials:"));
		TextField nameTF = new TextField();
		nameTF.setRequired(true);

		PasswordField passwordTF = new PasswordField();
		passwordTF.setRequired(true);

		layout.addComponent(nameTF);
		layout.addComponent(passwordTF);

		Button loginButton = new Button("Login");
		layout.addComponent(loginButton);
		setContent(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
