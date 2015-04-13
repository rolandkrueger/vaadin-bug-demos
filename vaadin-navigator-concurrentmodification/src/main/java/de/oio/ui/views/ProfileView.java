package de.oio.ui.views;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Panel;

@SpringView(name = "profile")
public class ProfileView extends Panel implements SecuredView {

	public ProfileView() {
		// no UI needed for this example
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}
}
