package pl.writeonly.son2.jack.chain

import pl.writeonly.son2.core.chain.{ChainNotationPair, ProviderCreator}
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

object ChainNotationPairJack extends ProviderCreator(p => new ChainNotationPairJack(p))
