package pl.writeonly.son2.path.core

import com.jayway.jsonpath.Configuration.Defaults
import com.jayway.jsonpath.spi.json._
import com.jayway.jsonpath.spi.mapper._
import pl.writeonly.son2.core.config.RConfig

import scala.collection.JavaConverters._

class DefaultsPath(val config: RConfig, json: JsonProvider, mapping: MappingProvider) extends Defaults {
  override def jsonProvider = json

  override def mappingProvider = mapping

  override def options: java.util.Set[com.jayway.jsonpath.Option] = new java.util.HashSet(optionCollection)

  private def optionCollection = config.options
    .map(toOption)
    .asJavaCollection

  private def toOption(s: Symbol): com.jayway.jsonpath.Option = com.jayway.jsonpath.Option.valueOf(s.name)

}

