package pl.writeonly.son2.jack.chain

import com.fasterxml.jackson.databind.JsonNode
import pl.writeonly.son2.core.chain.{ChainImpl, ConfigLift}
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
    new NotationReaderJavaProps) with ConfigLift {

  def configOpt(s:String): Option[Config] = get.lift(s).map(a => ChainReaderJack.config(a.asInstanceOf[JsonNode]))

  def config(s:String): Config = ChainReaderJack.config(parse(s))

  def parse(s: String): JsonNode = apply(s).get.asInstanceOf[JsonNode]

}

object ChainReaderJack {
  def config(n: JsonNode): Config = new Config(
    o=asText(n, ConfigPath.O),
    p=asBoolean(n, ConfigPath.P),
    i=asText(n, ConfigPath.I),
    s=asBoolean(n, ConfigPath.S)
  )

  private def asText(n: JsonNode, s:Symbol) = get(n,s).asText

  private def asBoolean(n: JsonNode, s:Symbol) = get(n,s).asBoolean

  private def get(n: JsonNode, s:Symbol) = n.get(s.name)
}

