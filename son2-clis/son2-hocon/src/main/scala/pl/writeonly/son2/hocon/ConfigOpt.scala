package pl.writeonly.son2.hocon

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.jasonclawson.jackson.dataformat.hocon.HoconFactory
import com.typesafe.config.ConfigFactory
import pl.writeonly.son2.apis.config.RWTConfig

object ConfigOpt {
  def configOpt(s: String) = Option(config(s))

  def config(s: String): RWTConfig = {
    val config = ConfigFactory.load()
    val ss = config.root().render()
    factory
      .readValue(s, classOf[RWTConfig])

  }

  def factory(jsonFactory: JsonFactory): ObjectMapper =
    new ObjectMapper(jsonFactory).registerModule(DefaultScalaModule)

  def factory(): ObjectMapper =
    factory(new HoconFactory)

}
