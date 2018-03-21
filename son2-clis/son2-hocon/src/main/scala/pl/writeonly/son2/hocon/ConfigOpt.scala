package pl.writeonly.son2.hocon

import com.fasterxml.jackson.databind.ObjectMapper
import com.jasonclawson.jackson.dataformat.hocon.HoconFactory
import com.typesafe.config.ConfigFactory
import pl.writeonly.son2.apis.config.RWTConfig

object ConfigOpt {
  def configOpt() = Option(config())

  def config(): RWTConfig = {
    val config = ConfigFactory.load()
    val s = config.root().render()
    new ObjectMapper(new HoconFactory).readValue(s, classOf[RWTConfig])
  }
}
