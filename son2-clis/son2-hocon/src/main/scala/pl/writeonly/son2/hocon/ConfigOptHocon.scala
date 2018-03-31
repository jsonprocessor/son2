package pl.writeonly.son2.hocon

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.jasonclawson.jackson.dataformat.hocon.HoconFactory
import com.typesafe.config.ConfigFactory
import com.typesafe.scalalogging.StrictLogging
import pl.writeonly.son2.apis.config.RWTConfig

object ConfigOptHocon extends StrictLogging {
  def configOpt(s: String) = Option(config(s))

  def config(s: String): RWTConfig = {
    val config1 = ConfigFactory.load()
    logger.info(s"config1 $config1")
    val config2 = config1.getConfig("son2")
    logger.info(s"config2 $config2")
    val config3 = ConfigFactory.parseString(s)
    logger.info(s"config3 $config3")

    val config = config3.withFallback(config2).root.render()
    logger.info(s"config $config")
    factory()
      .readValue(config.toString, classOf[RWTConfig])

  }

  def factory(jsonFactory: JsonFactory): ObjectMapper =
    new ObjectMapper(jsonFactory).registerModule(DefaultScalaModule)

  def factory(): ObjectMapper =
    factory(new HoconFactory)

}
