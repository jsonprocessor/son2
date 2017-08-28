package pl.writeonly.son2.drop.vaadin

import com.vaadin.annotations.VaadinServletConfiguration
import com.vaadin.server.VaadinServlet

@VaadinServletConfiguration(ui = classOf[MainUI], productionMode = false)
class Servlet extends VaadinServlet