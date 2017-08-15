package pl.writeonly.son2.core.notation

import pl.writeonly.son2.core.config.Config

trait PartialCreatorRWT extends PartialFunction[String, NotationPair] {

  override def apply(s: String) = NotationPair(c, NotationRWT(r(s), w(s), t(s)))

  def r(s: String): NotationReader = null

  def w(s: String): NotationWriter = null

  def t(s: String): NotationTranslator = null

  def c: String => Config

}
