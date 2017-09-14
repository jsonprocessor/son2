package pl.writeonly.son2.path.creators

import com.jayway.jsonpath.Configuration.Defaults
import com.jayway.jsonpath.spi.json.{JacksonJsonNodeJsonProvider, JsonSmartJsonProvider}
import com.jayway.jsonpath.spi.mapper.{JacksonMappingProvider, JsonSmartMappingProvider}
import pl.writeonly.son2.core.config.RConfig
import pl.writeonly.son2.core.notation.NotationReader
import pl.writeonly.son2.core.pcreators.PCreatorReader
import pl.writeonly.son2.path.notation.NotationReaderPath

import scala.collection.JavaConverters._

class PCreatorReaderPathMain extends PCreatorReader {

  override def isDefinedAt(c: RConfig): Boolean = isDefinedAt(c.query)

  def isDefinedAt(s: Option[String]): Boolean = s != null && s.isDefined && isDefinedAt(s.get)

  def isDefinedAt(s: String): Boolean = s != null && s.startsWith("$")

  override def apply(c: RConfig): NotationReader = new NotationReaderPath(defaults(c), c.query.get)

  def defaults(c:RConfig) : Defaults = new Defaults {
    override def jsonProvider() = new JsonSmartJsonProvider
    override def mappingProvider() = new JsonSmartMappingProvider
    override def options() : java.util.Set[com.jayway.jsonpath.Option] = new java.util.HashSet(optionCollection)

    private def optionCollection = c.options.map(toOption).asJavaCollection

    private def toOption(name:String): com.jayway.jsonpath.Option = com.jayway.jsonpath.Option.valueOf(name)
  }
}
