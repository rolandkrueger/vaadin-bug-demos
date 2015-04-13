package de.oio.ui.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = "")
public class MainView extends Panel implements View {

	public MainView() {
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(new Label("<h1>Welcome Stranger</h1><hr/>You're currently not logged in.<hr/>", ContentMode.HTML));
		layout.addComponent(new Link("Your Profile", new ExternalResource("#!profile")));
		setContent(layout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}
}
