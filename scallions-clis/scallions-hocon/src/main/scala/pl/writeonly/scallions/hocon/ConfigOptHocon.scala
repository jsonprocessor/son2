package pl.writeonly.scallions.hocon

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.jasonclawson.jackson.dataformat.hocon.HoconFactory
import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.StrictLogging
import pl.writeonly.scallions.apis.config.RWTConfig
import pl.writeonly.scalaops.pipe.Pipe._

class ConfigOptHocon extends StrictLogging {
  def configOpt(s: String) = Option(config(s))

  def config(s: String): RWTConfig = {
    val config = ConfigFactory.parseString(s)
    val configValue = config.withFallback(son2).root.render()
    hocon
      .readValue(configValue.toString, classOf[RWTConfig])
  }

  def son2(config: Config): Config = config.getConfig("son2")

  def son2: Config = son2(ConfigFactory.load())

  def factory(jsonFactory: JsonFactory): ObjectMapper =
    new ObjectMapper(jsonFactory).registerModule(DefaultScalaModule)

  def hocon: ObjectMapper = new HoconFactory |> factory

}
