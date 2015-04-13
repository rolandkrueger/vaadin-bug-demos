# ConcurrentModificationException in Navigator when using Spring Boot

When redirecting to a different view in ViewChangeListener.beforeViewChange() through Navigator.navigateTo(), the following ConcurrentModificationException is thrown:

java.util.ConcurrentModificationException: null
	at java.util.LinkedList$ListItr.checkForComodification(LinkedList.java:966)
	at java.util.LinkedList$ListItr.next(LinkedList.java:888)
	at com.vaadin.navigator.Navigator.fireAfterViewChange(Navigator.java:650)
	at com.vaadin.navigator.Navigator.navigateTo(Navigator.java:580)
	at com.vaadin.navigator.Navigator.navigateTo(Navigator.java:526)
	at de.oio.ui.MainUI.beforeViewChange(MainUI.java:34)
	at com.vaadin.navigator.Navigator.fireBeforeViewChange(Navigator.java:601)
	at com.vaadin.navigator.Navigator.navigateTo(Navigator.java:553)
	at com.vaadin.navigator.Navigator.navigateTo(Navigator.java:526)
	at com.vaadin.navigator.Navigator$UriFragmentManager.uriFragmentChanged(Navigator.java:140)
	
This is caused by com.vaadin.spring.internal.DefaultViewCache.ViewBeanStore registering itself as ViewChangeListener during the processing of a ViewChangeEvent:

java.lang.Thread.State: RUNNABLE
	  at com.vaadin.navigator.Navigator.addViewChangeListener(Navigator.java:836)
	  at com.vaadin.spring.internal.DefaultViewCache$ViewBeanStore.<init>(DefaultViewCache.java:193)
	  at com.vaadin.spring.internal.DefaultViewCache.getOrCreateBeanStore(DefaultViewCache.java:143)
	  at com.vaadin.spring.internal.DefaultViewCache.creatingView(DefaultViewCache.java:63)
	  at com.vaadin.spring.navigator.SpringViewProvider.getViewFromApplicationContext(SpringViewProvider.java:294)
	  at com.vaadin.spring.navigator.SpringViewProvider.getView(SpringViewProvider.java:274)
	  at com.vaadin.navigator.Navigator.navigateTo(Navigator.java:512)
	  at com.vaadin.navigator.Navigator$UriFragmentManager.uriFragmentChanged(Navigator.java:140)