package pl.writeonly.son2.drop

import io.dropwizard.Application
import io.dropwizard.setup.{Bootstrap, Environment}
import pl.writeonly.son2.vaadin.servlets._

class ApplicationSon2 extends Application[ConfigurationSon2] {

  override def run(configuration: ConfigurationSon2,
                   environment: Environment) = {}

  override def initialize(bootstrap: Bootstrap[ConfigurationSon2]) = {
    bootstrap.addBundle(new BundleVaadin(classOf[Servlet], "/ui/*"))
    bootstrap.addBundle(
      new BundleVaadin(classOf[ServletComparator], "/ui/comparator/*"))
    bootstrap.addBundle(
      new BundleVaadin(classOf[ServletConverter], "/ui/converter/*"))
    bootstrap.addBundle(new BundleVaadin(classOf[ServletDiff], "/ui/diff/*"))
    bootstrap.addBundle(
      new BundleVaadin(classOf[ServletFormatter], "/ui/formatter/*"))
    bootstrap.addBundle(new BundleVaadin(classOf[ServletPath], "/ui/path/*"))
    bootstrap.addBundle(new BundleVaadin(classOf[ServletPatch], "/ui/patch/*"))
  }

}
