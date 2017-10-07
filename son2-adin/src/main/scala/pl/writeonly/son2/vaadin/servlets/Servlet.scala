package pl.writeonly.son2.vaadin.servlets

import com.vaadin.annotations.VaadinServletConfiguration
import com.vaadin.server.VaadinServlet
import pl.writeonly.son2.vaadin.ui._

@VaadinServletConfiguration(ui = classOf[UIMain], productionMode = false)
class Servlet extends VaadinServlet

@VaadinServletConfiguration(ui = classOf[UIConverter], productionMode = false)
class ServletConverter extends VaadinServlet

@VaadinServletConfiguration(ui = classOf[UIComparator], productionMode = false)
class ServletComparator extends VaadinServlet

@VaadinServletConfiguration(ui = classOf[UIDiff], productionMode = false)
class ServletDiff extends VaadinServlet

@VaadinServletConfiguration(ui = classOf[UIFormatter], productionMode = false)
class ServletFormatter extends VaadinServlet

@VaadinServletConfiguration(ui = classOf[UIPath], productionMode = false)
class ServletPath extends VaadinServlet

@VaadinServletConfiguration(ui = classOf[UIPatch], productionMode = false)
class ServletPatch extends VaadinServlet