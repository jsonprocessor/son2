package pl.writeonly.son2.text.creators

import pl.writeonly.son2.core.config.{Config, TConfig}
import pl.writeonly.son2.core.notation.NotationTranslator
import pl.writeonly.son2.core.pcreators.PCreatorTranslator

import scala.util.control.Exception.catching

class PCreatorTranslatorText extends PCreatorTranslator {
  private val matcher = new MatcherStringEscape()

  override def isDefinedAt(c: Config): Boolean =
    catching(classOf[Exception])
      .opt(apply(c))
      .isDefined

  //  override def isDefinedAt(c: Config): Boolean = isDefinedAt(c.translate)

  override def apply(c: Config): NotationTranslator =
    new NotationTranslator(c.write, translatorMatch(c.translate))

  def translatorMatch(p: TConfig) = matcher.apply(p)

  def isDefinedAt(c: TConfig): Boolean =
    Option(c).isDefined && isDefinedAt(c.action) && isDefinedAt(c.format)

  def isDefinedAt(s: Symbol): Boolean = Option(s).isDefined && s != Symbol("")
}
