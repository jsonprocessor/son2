package pl.writeonly.scallions.path.notation

import com.jayway.jsonpath.{Configuration, JsonPath, ParseContext}
import pl.writeonly.scallions.apis.config.Meta
import pl.writeonly.scallions.apis.config.RPath.{Json, Parse, Read}
import pl.writeonly.scallions.path.core.DefaultsPath
import pl.writeonly.scallions.apis.notation.{NotationReader, Value}

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
