package pl.writeonly.son2.main

import pl.writeonly.son2.core.chain.ChainNotationCreator
import pl.writeonly.son2.jack.chain.ChainNotationPairJack
import pl.writeonly.son2.path.chain.ChainNotationPairPath

object Chainer extends ChainNotationCreator(
  new ChainNotationPairPath(true).get
    orElse
    new ChainNotationPairJack(true).get
)
