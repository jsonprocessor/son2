package pl.writeonly.son2.drop.vaadin

import io.dropwizard.assets.AssetsBundle
import io.dropwizard.{Bundle, Configuration}
import io.dropwizard.setup.{Bootstrap, Environment}
import org.eclipse.jetty.server.session.SessionHandler

import scala.collection.mutable

class BundleVaadin(
                    servlet :Class[Servlet],
                    pathSpec: String
                  ) extends Bundle {
  val servlets = new mutable.HashMap[String, Class[Servlet]]()
  servlets.put(pathSpec, servlet)
  val sessionHandler : SessionHandler = new SessionHandler()

  def initialize(bootstrap: Bootstrap[_]): Unit = {
    bootstrap.addBundle(new AssetsBundle("/VAADIN", "/VAADIN", null, "vaadin"))
  }

  override def run(environment: Environment): Unit = {
    environment.servlets().setSessionHandler(sessionHandler)
    val context = environment.getApplicationContext()
    servlets.foreach(it => context.addServlet(it._2, it._1))
  }

}

