package pl.writeonly.son2.core.notation

import pl.writeonly.son2.core.config.Config

trait PartialCreator extends PartialFunction[Config, NotationRWT] {

  override def apply(s: Config) = rwt(s)

  def rwt(c: Config) = NotationRWT(r(c), w(c), t(c))

  def r(c: Config): NotationReader

  def w(c: Config): NotationWriter

  def t(c: Config): NotationTranslator

  def is(s: Config): Boolean = isDefinedAt(s)

}
