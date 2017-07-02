package pl.writeonly.son2.jack.glue

import com.fasterxml.jackson.databind.JsonNode
import pl.writeonly.son2.core.formats.matchers.{Chain, ChainCreator, MatcherFormat}
import pl.writeonly.son2.jack.notation._

class ChainReaderJack extends Chain[Any] {

  def get : PartialFunction[String, Any] = (
    new NotationReaderObject
      orElse
      new NotationReaderXml
      orElse
      new NotationReaderYaml
      orElse
      new NotationReaderCsv
      orElse
      new NotationReaderJavaProps
    )

  def parse(s:String): JsonNode = apply(s).get.asInstanceOf[JsonNode]

}
