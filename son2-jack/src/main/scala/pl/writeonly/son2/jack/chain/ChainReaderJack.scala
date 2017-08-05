package pl.writeonly.son2.jack.chain

import com.fasterxml.jackson.databind.JsonNode
import pl.writeonly.son2.core.chain.{ChainImpl, ConfigLift}
import pl.writeonly.son2.core.config.{Config, ConfigPath}
import pl.writeonly.son2.jack.core.ConfigJack
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

  def config(s: String): Config = configOpt(s).get

  def configOpt(s: String): Option[Config] = get.lift(s).map(a => ChainReaderJack.config(a.asInstanceOf[JsonNode]))

  def parse(s: String): JsonNode = apply(s).get.asInstanceOf[JsonNode]

}

object ChainReaderJack {
  def config(n: JsonNode): Config = config(n, ConfigJack.apply())

  def config(n: JsonNode, c: Config): Config = new Config(
    input = asText(n, ConfigPath.I).getOrElse(c.input),
    stream = asBoolean(n, ConfigPath.S).getOrElse(c.stream),
    output = asText(n, ConfigPath.O).getOrElse(c.output),
    pretty = asBoolean(n, ConfigPath.P).getOrElse(c.pretty)
  )

  private def asText(n: JsonNode, s: Symbol) = get(n, s).map(o => o.asText)

  private def asBoolean(n: JsonNode, s: Symbol) = get(n, s).map(o => o.asBoolean)

  private def get(n: JsonNode, s: Symbol) = Option(n.get(s.name))
}

