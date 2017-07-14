package pl.writeonly.son2.jack.chain

import pl.writeonly.son2.core.chain.{ChainNotationCreator, ChainNotationPair}
import pl.writeonly.son2.jack.core.Formats
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
  def apply(s : Symbol) = new ChainNotationCreator(new ChainNotationPairJack(true).get).chain(s.name).get
}
