package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.Configuration.Defaults
import com.jayway.jsonpath.{Configuration, JsonPath, ParseContext}
import pl.writeonly.son2.core.notation.NotationReader

class NotationReaderPath(val defaults: Defaults, val path: Option[String]) extends NotationReader {

  def apply(content: String): Any = path
    .map(read(content, _))
    .getOrElse(parse(content))

  def read(content: String, it: String): Any = using.parse(content).read(it)

  def json(content: String): Any = using.parse(content).json()

  def parse(content: String): Any = defaults.jsonProvider().parse(content)

  def using: ParseContext = JsonPath.using(configuration)

  def configuration = Configuration.builder
    .jsonProvider(defaults.jsonProvider)
    .mappingProvider(defaults.mappingProvider)
    .options(defaults.options)
    .build
}
