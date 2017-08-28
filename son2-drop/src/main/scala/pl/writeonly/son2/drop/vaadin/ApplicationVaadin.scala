package pl.writeonly.son2.drop.vaadin

import com.vaadin.annotations.VaadinServletConfiguration
import com.vaadin.server.VaadinServlet
import io.dropwizard.setup.{Bootstrap, Environment}
import io.dropwizard.{Application, Configuration}

class ApplicationVaadin extends Application[ConfigurationVaadin] {

  override def run(configuration :ConfigurationVaadin , environment :Environment) = {}

  override def initialize(bootstrap : Bootstrap[ConfigurationVaadin]) = {
    bootstrap.addBundle(new BundleVaadin(classOf[Servlet], "/ui/*"))
  }

}





