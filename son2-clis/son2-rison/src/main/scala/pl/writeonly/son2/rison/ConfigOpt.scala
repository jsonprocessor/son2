package pl.writeonly.son2.rison

import com.fasterxml.jackson.databind.ObjectMapper
import com.github.hronom.jackson.dataformat.rison.{RisonFactory, RisonGenerator, RisonParser}
import pl.writeonly.son2.apis.config.RWTConfig


object ConfigOpt {
  def configOpt(s: String) = Option(config(s))

  def config(s: String): RWTConfig = risonFactory
    .readValue(s, classOf[RWTConfig])

  def risonFactory: ObjectMapper = new ObjectMapper(new RisonFactory()
    .enable(RisonGenerator.Feature.O_RISON)
    .enable(RisonParser.Feature.O_RISON))

}
