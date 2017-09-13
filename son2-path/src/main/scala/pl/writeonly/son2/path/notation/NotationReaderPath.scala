package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JsonProvider
import com.jayway.jsonpath.{Configuration, JsonPath}
import java.util.{Set => jSet}

import com.jayway.jsonpath.spi.mapper.MappingProvider
import pl.writeonly.son2.core.notation.NotationReader
import com.jayway.jsonpath.{Option => jOption}

class NotationReaderPath(val path: String) extends NotationReader {

  def apply(content: String): Any = JsonPath
    .using(configuration)
    .parse(content)
    .read(path)

  def configuration = Configuration.defaultConfiguration()

  def build = Configuration.builder
    .jsonProvider(jsonProvider)
    .mappingProvider(mappingProvider)
    .options(options)
    .build

  def jsonProvider : JsonProvider = ???

  def mappingProvider : MappingProvider = ???

  def options : jSet[jOption] = ???
}
