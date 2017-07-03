package pl.writeonly.son2.core.chain

import pl.writeonly.son2.core.notation.NotationPair

class ChainNotationPair(chain : PartialFunction[String, NotationPair])
  extends ChainImpl[NotationPair](chain) {
}
