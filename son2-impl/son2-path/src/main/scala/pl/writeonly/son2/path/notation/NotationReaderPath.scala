package pl.writeonly.son2.path.notation

import com.google.common.base.MoreObjects
import com.jayway.jsonpath.{Configuration, JsonPath, ParseContext}
import pl.writeonly.son2.core.config.{Json, Parse, Read}
import pl.writeonly.son2.core.notation.NotationReader
import pl.writeonly.son2.path.core.DefaultsPath

class NotationReaderPath(val defaults: DefaultsPath) extends NotationReader {

  override def toString() =
    MoreObjects.toStringHelper(this).addValue(defaults).toString

  def apply(content: String): Any = defaults.config.path match {
    case Parse      => parse(content)
    case Json       => json(content)
    case Read(path) => read(content, path)
  }

  def read(content: String, path: String): Any =
    using.parse(content).read(path)

  def json(content: String): Any = using.parse(content).json()

  def parse(content: String): Any = defaults.jsonProvider().parse(content)

  def using: ParseContext = JsonPath.using(configuration)

  def configuration =
    Configuration.builder
      .jsonProvider(defaults.jsonProvider)
      .mappingProvider(defaults.mappingProvider)
      .options(defaults.options)
      .build
}
