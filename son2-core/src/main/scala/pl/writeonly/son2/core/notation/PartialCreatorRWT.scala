package pl.writeonly.son2.core.notation

import pl.writeonly.son2.core.config.Config

trait PartialCreatorRWT extends PartialFunction[Config, NotationRWT] {

  override def apply(c: Config) = NotationRWT(r(c), w(c), t(c))

  def r(c: Config): NotationReader = null

  def w(c: Config): NotationWriter = null

  def t(c: Config): NotationTranslator = null

}
