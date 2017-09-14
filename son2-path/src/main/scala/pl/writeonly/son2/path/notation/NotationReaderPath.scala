package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.{Configuration, JsonPath, ParseContext}

import com.jayway.jsonpath.Configuration.Defaults
import pl.writeonly.son2.core.notation.NotationReader

class NotationReaderPath(val defaults : Defaults, val path: String) extends NotationReader {

  def apply(content: String): Any = using.parse(content).read(path)

  def using : ParseContext = JsonPath.using(configuration)

  def configuration = Configuration.builder
    .jsonProvider(defaults.jsonProvider)
    .mappingProvider(defaults.mappingProvider)
    .options(defaults.options)
    .build
}
