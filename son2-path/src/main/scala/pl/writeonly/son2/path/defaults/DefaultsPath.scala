package pl.writeonly.son2.path.defaults

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import com.jayway.jsonpath.Configuration.Defaults
import com.jayway.jsonpath.spi.json._
import com.jayway.jsonpath.spi.mapper._
import net.minidev.json.writer.JsonReaderI
import pl.writeonly.son2.core.config.RConfig

import scala.collection.JavaConverters._

class DefaultsPath(c:RConfig, json : JsonProvider, mapping : MappingProvider) extends Defaults {
  override def jsonProvider = json

  override def mappingProvider = mapping

  override def options : java.util.Set[com.jayway.jsonpath.Option] = new java.util.HashSet(optionCollection)

  private def optionCollection = c.options
    .map(toOption)
    .asJavaCollection

  private def toOption(name:String): com.jayway.jsonpath.Option = com.jayway.jsonpath.Option.valueOf(name)

}

class DefaultsSmart(c:RConfig, parseMode: Int, mapper: JsonReaderI[_])
  extends DefaultsPath(c, new JsonSmartJsonProvider(parseMode, mapper), new JsonSmartMappingProvider(mapper.base))

class DefaultsJackson(c:RConfig, objectMapper: ObjectMapper)
  extends DefaultsPath(c, new JacksonJsonNodeJsonProvider(objectMapper), new JacksonMappingProvider(objectMapper))

class DefaultsGson(c:RConfig, gson: Gson)
  extends DefaultsPath(c, new GsonJsonProvider(gson), new GsonMappingProvider(gson))

class DefaultsOrg(c:RConfig)
  extends DefaultsPath(c, new JsonOrgJsonProvider(), new JsonOrgMappingProvider())

class DefaultsTapesty(c:RConfig)
  extends DefaultsPath(c, new TapestryJsonProvider(), new TapestryMappingProvider())

class DefaultsJettison(c:RConfig)
  extends DefaultsPath(c, new JettisonProvider(), null)
