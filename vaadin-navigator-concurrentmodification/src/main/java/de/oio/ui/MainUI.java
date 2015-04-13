package de.oio.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import de.oio.ui.views.SecuredView;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Roland Krüger
 */
@SpringUI(path = "")
@Theme("valo")
public class MainUI extends UI implements ViewChangeListener {

    @Autowired
    private SpringViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Navigator navigator = new Navigator(this, this);
        navigator.addProvider(viewProvider);
        setNavigator(navigator);
        navigator.addViewChangeListener(this);
    }

    @Override
    public boolean beforeViewChange(ViewChangeListener.ViewChangeEvent event) {
        if (event.getNewView() instanceof SecuredView) {
            getNavigator().navigateTo("login/" + event.getViewName());
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void afterViewChange(ViewChangeListener.ViewChangeEvent event) {
        // not needed
    }
}
