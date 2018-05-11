package pl.writeonly.scallions.text.creators

import pl.writeonly.scallions.apis.config._
import pl.writeonly.scallions.apis.notation.NotationTranslator
import pl.writeonly.scallions.apis.pcreators.PCreatorTranslator
import pl.writeonly.scalaops.pipe.Pipe._
import pl.writeonly.scallions.apis.config.ProviderType

import scala.util.control.Exception.catching

class PCreatorTranslatorText extends PCreatorTranslator {
  private val matcher = new MatcherStringEscape()

  override def isDefinedAt(c: RWTConfig): Boolean =
    catching(classOf[Exception])
      .opt(apply(c))
      .isDefined

  //  override def isDefinedAt(c: Config): Boolean = isDefinedAt(c.translate)

  override def apply(c: RWTConfig): NotationTranslator =
    new NotationTranslator(
      Meta(ProviderType(c.translate.action.s), c.translate.format),
      c.write,
      translatorMatch(c.translate)
    )

  def translatorMatch(p: TConfig) = matcher.apply(p)

  def isDefinedAt(c: TConfig): Boolean = c && c.action && c.format.s

  def isDefinedAt(s: Symbol): Boolean = s && s != Symbol("")
}
