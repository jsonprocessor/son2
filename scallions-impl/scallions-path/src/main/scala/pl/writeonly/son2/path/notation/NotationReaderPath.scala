package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.{Configuration, JsonPath, ParseContext}
import pl.writeonly.son2.apis.config.Meta
import pl.writeonly.son2.apis.config.RPath.{Json, Parse, Read}
import pl.writeonly.son2.apis.notation.{NotationReader, Value}
import pl.writeonly.son2.path.core.DefaultsPath

class NotationReaderPath(meta: Meta, val defaults: DefaultsPath)
    extends NotationReader(meta) {

  override def toString: String = (this, defaults).toString

  def apply(content: String): Value = defaults.config.path match {
    case Parse      => parse(content)
    case Json       => json(content)
    case Read(path) => read(content, path)
  }

  def read(content: String, path: String): Value =
    using.parse(content).read(path)

  def json(content: String): Value = using.parse(content).json()

  def parse(content: String): Value = defaults.jsonProvider.parse(content)

  def using: ParseContext = JsonPath.using(configuration)

  def configuration: Configuration =
    Configuration.builder
      .jsonProvider(defaults.jsonProvider)
      .mappingProvider(defaults.mappingProvider)
      .options(defaults.options)
      .build
}
