package pl.writeonly.son2.drop.vaadin

import com.vaadin.annotations.VaadinServletConfiguration
import com.vaadin.server.VaadinServlet
import pl.writeonly.son2.drop.vaadin.ui.{UIConverter, UIMain, UIPath, UIFormatter}

@VaadinServletConfiguration(ui = classOf[UIMain], productionMode = false)
class Servlet extends VaadinServlet

@VaadinServletConfiguration(ui = classOf[UIFormatter], productionMode = false)
class ServletFormatter extends VaadinServlet

@VaadinServletConfiguration(ui = classOf[UIConverter], productionMode = false)
class ServletConverter extends VaadinServlet

@VaadinServletConfiguration(ui = classOf[UIPath], productionMode = false)
class ServletPath extends VaadinServlet