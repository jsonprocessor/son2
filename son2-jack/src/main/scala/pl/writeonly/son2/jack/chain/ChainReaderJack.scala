package pl.writeonly.son2.jack.chain

import com.fasterxml.jackson.databind.JsonNode
import pl.writeonly.son2.core.chain.ChainImpl
import pl.writeonly.son2.core.notation.{Config, ConfigPath}
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

  def config(n: JsonNode): Config = new Config(
    o=asText(n, ConfigPath.O),
    p=asBoolean(n, ConfigPath.P),
    i=asText(n, ConfigPath.I),
    s=asBoolean(n, ConfigPath.S)
  )

  def asText(n: JsonNode, s:Symbol) = get(n,s).asText

  def asBoolean(n: JsonNode, s:Symbol) = get(n,s).asBoolean

  def get(n: JsonNode, s:Symbol) = n.get(s.name)

  def config(s:String): Config = config(parse(s))
}
