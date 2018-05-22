package pl.writeonly.scallions.path.core

import com.jayway.jsonpath.Configuration.Defaults
import com.jayway.jsonpath.spi.json._
import com.jayway.jsonpath.spi.mapper._
import pl.writeonly.scallions.apis.config.RConfig

import scala.collection.JavaConverters._

class DefaultsPath(val config: RConfig,
                   override val jsonProvider: JsonProvider,
                   override val mappingProvider: MappingProvider)
    extends Defaults {

  override def toString: String =
    (this, config, jsonProvider, mappingProvider).toString

  override def options: java.util.Set[com.jayway.jsonpath.Option] =
    new java.util.HashSet(optionCollection)

  private def optionCollection =
    config.options
      .map(toOption)
      .asJavaCollection

  private def toOption(s: Symbol): com.jayway.jsonpath.Option =
    com.jayway.jsonpath.Option.valueOf(s.name)

}
