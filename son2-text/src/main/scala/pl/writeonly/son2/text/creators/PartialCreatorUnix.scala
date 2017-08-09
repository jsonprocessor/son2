package pl.writeonly.son2.text.creators

import pl.writeonly.son2.core.config.{Config, TConfig}
import pl.writeonly.son2.core.notation.{NotationTranslator, PartialCreator}

class PartialCreatorUnix extends PartialCreator {

  override def isDefinedAt(s: String) = s != null && s.startsWith("s/")

  override def c = (s: String) => new Config(translate = translateConfig(s))

  override def t(s: String) = new NotationTranslator(translatorMatch(translateConfig(s)))

  def translateConfig(s: String): TConfig = ???

  def translatorMatch(p: TConfig) = ???

}
