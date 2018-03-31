package pl.writeonly.son2.rison

import com.fasterxml.jackson.core.JsonFactory
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.github.hronom.jackson.dataformat.rison.{
  RisonFactory,
  RisonGenerator,
  RisonParser
}
import pl.writeonly.son2.apis.config.RWTConfig

object ConfigOptRison {

  def configOpt(s: String) = Option(config(s))

  def config(s: String): RWTConfig =
    factory
      .readValue(s, classOf[RWTConfig])

  def factory(jsonFactory: JsonFactory): ObjectMapper =
    new ObjectMapper(jsonFactory).registerModule(DefaultScalaModule)

  def factory(): ObjectMapper =
    factory(
      new RisonFactory()
        .enable(RisonGenerator.Feature.O_RISON)
        .enable(RisonParser.Feature.O_RISON))

}
