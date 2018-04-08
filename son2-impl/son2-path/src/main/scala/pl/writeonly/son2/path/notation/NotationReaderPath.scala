package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.{Configuration, JsonPath, ParseContext}
import pl.writeonly.son2.apis.config.{Json, MetaLike, Parse, Read}
import pl.writeonly.son2.apis.notation.NotationReader
import pl.writeonly.son2.path.core.DefaultsPath

class NotationReaderPath(meta: MetaLike, val defaults: DefaultsPath)
    extends NotationReader(meta) {

  override def toString: String = (this, defaults).toString

  def apply(content: String): Any = defaults.config.path match {
    case Parse      => parse(content)
    case Json       => json(content)
    case Read(path) => read(content, path)
  }

  def read(content: String, path: String): Any =
    using.parse(content).read(path)

  def json(content: String): Any = using.parse(content).json()

  def parse(content: String): Any = defaults.jsonProvider.parse(content)

  def using: ParseContext = JsonPath.using(configuration)

  def configuration: Configuration =
    Configuration.builder
      .jsonProvider(defaults.jsonProvider)
      .mappingProvider(defaults.mappingProvider)
      .options(defaults.options)
      .build
}
