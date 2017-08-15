package pl.writeonly.son2.core.notation

import pl.writeonly.son2.core.chain.ChainNotationConfig
import pl.writeonly.son2.core.config.Config

trait PartialCreator extends PartialFunction[String, NotationPair] {

  override def apply(s: String) = NotationPair(c, rwt(c(s)))

  def rwt(c:Config) = NotationRWT(r(c), w(c), t(c))

  def r(c: Config): NotationReader = null

  def w(c: Config): NotationWriter = null

  def t(c: Config): NotationTranslator = null

  def c: String => Config

  def is(s:String) = isDefinedAt(s)

  def sc = new PartialFunction[String, Config]() {
    override def isDefinedAt(s: String): Boolean = is(s)

    override def apply(s: String): Config = c(s)
  }


}
