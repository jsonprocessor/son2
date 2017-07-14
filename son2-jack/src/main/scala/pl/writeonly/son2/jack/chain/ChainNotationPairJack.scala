package pl.writeonly.son2.jack.chain

import pl.writeonly.son2.core.chain.{ChainNotationCreator, ChainNotationPair}
import pl.writeonly.son2.core.notation.Config
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.creators._

class ChainNotationPairJack(pretty: Boolean) extends ChainNotationPair(
  new PartialCreatorObject(pretty)
    orElse
    new PartialCreatorXml(pretty)
    orElse
    new PartialCreatorYaml(pretty)
    orElse
    new PartialCreatorCsv(pretty)
    orElse
    new PartialCreatorJavaProps(pretty)
    orElse
    new PartialCreatorProperties(pretty)
)

object ChainNotationPairJack {
  def apply(s : Symbol) : Provider = new ChainNotationCreator(new ChainNotationPairJack(true).get).chain(s.name).get

  def apply(c :Config) : Provider = new ChainNotationCreator(new ChainNotationPairJack(false).get).provider(c)
}
