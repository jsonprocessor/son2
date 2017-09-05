package pl.writeonly.son2.drop.vaadin

import io.dropwizard.Application
import io.dropwizard.setup.{Bootstrap, Environment}
import pl.writeonly.son2.drop.vaadin.servlets._

class ApplicationVaadin extends Application[ConfigurationVaadin] {

  override def run(configuration: ConfigurationVaadin, environment: Environment) = {}

  override def initialize(bootstrap: Bootstrap[ConfigurationVaadin]) = {
    bootstrap.addBundle(new BundleVaadin(classOf[Servlet], "/ui/*"))
    bootstrap.addBundle(new BundleVaadin(classOf[ServletComparator], "/ui/comparator/*"))
    bootstrap.addBundle(new BundleVaadin(classOf[ServletConverter], "/ui/converter/*"))
    bootstrap.addBundle(new BundleVaadin(classOf[ServletDiff], "/ui/diff/*"))
    bootstrap.addBundle(new BundleVaadin(classOf[ServletFormatter], "/ui/formatter/*"))
    bootstrap.addBundle(new BundleVaadin(classOf[ServletPath], "/ui/path/*"))
    bootstrap.addBundle(new BundleVaadin(classOf[ServletPatch], "/ui/patch/*"))
  }

}





