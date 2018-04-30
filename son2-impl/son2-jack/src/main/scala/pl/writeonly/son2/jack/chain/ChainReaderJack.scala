package pl.writeonly.son2.jack.chain

import com.fasterxml.jackson.databind.JsonNode
import pl.writeonly.son2.apis.chain.ChainImpl
import pl.writeonly.son2.apis.config._
import pl.writeonly.son2.jack.core.ConfigJack
import pl.writeonly.son2.jack.notation._

class ChainReaderJack
    extends ChainImpl[Any](
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
    with HasConfigOpt {

  def configOpt(s: String): Option[RWTConfig] =
    get.lift(s).map(a => ChainReaderJack.config(a.asInstanceOf[JsonNode]))

  def parse(s: String): JsonNode = get.lift(s) match {
    case Some(n) => n.asInstanceOf[JsonNode]
    case None    => throw new IllegalArgumentException(s)
  }

}

object ChainReaderJack {
  def config(n: JsonNode): RWTConfig = config(n, ConfigJack.apply())

  def config(n: JsonNode, c: RWTConfig): RWTConfig =
    RWTConfig(read = rConfig(n, c.read), write = wConfig(n, c.write))

  def rConfig(n: JsonNode, c: RConfig) =
    RConfig(
      provider =
        asText(n, ConfigField.I).map(ProviderType.apply).getOrElse(c.provider),
      stream = asBoolean(n, ConfigField.S).map(RStyle.get).getOrElse(c.stream)
    )

  def wConfig(n: JsonNode, c: WConfig) =
    WConfig(
      provider =
        asText(n, ConfigField.O).map(ProviderType.apply).getOrElse(c.provider),
      style = asBoolean(n, ConfigField.P).map(WStyle.get).getOrElse(c.style)
    )

  private def asText(n: JsonNode, s: Symbol): Option[Symbol] =
    get(n, s).map(_.asText).map(Symbol.apply)

  private def asBoolean(n: JsonNode, s: Symbol): Option[Boolean] =
    get(n, s).map(_.asBoolean)

  private def get(n: JsonNode, s: Symbol) = Option(n.get(s.name))
}
