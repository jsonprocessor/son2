package pl.writeonly.son2.core.chain

import pl.writeonly.son2.core.config.Config

class ChainNotationConfig(chain: PartialFunction[String, Config])
  extends ChainImpl[Config](chain) {
}
