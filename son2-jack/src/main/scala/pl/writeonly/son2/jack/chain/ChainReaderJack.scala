package pl.writeonly.son2.jack.chain

import com.fasterxml.jackson.databind.JsonNode
import pl.writeonly.son2.core.chain.ChainImpl
import pl.writeonly.son2.jack.notation._

class ChainReaderJack extends ChainImpl[Any](
  new NotationReaderObject
    orElse
    new NotationReaderXml
    orElse
    new NotationReaderYaml
    orElse
    new NotationReaderCsv
    orElse
    new NotationReaderJavaProps) {

  def parse(s: String): JsonNode = apply(s).get.asInstanceOf[JsonNode]
}
