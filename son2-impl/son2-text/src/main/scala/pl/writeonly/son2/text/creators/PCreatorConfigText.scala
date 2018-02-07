package pl.writeonly.son2.text.creators

import pl.writeonly.son2.core.config.{ Config, TConfig }
import pl.writeonly.son2.core.pcreators.PCreatorConfig
import pl.writeonly.son2.text.core.{ Actions, FormatsText }

class PCreatorConfigText extends PCreatorConfig {

  private val matcher = new MatcherStringEscape()

  override def isDefinedAt(s: String) =
    s != null &&
      symbolOptionPairOption(s)
      .map(p => p._1.isDefined && p._2.isDefined)
      .getOrElse(false)

  private def symbolOptionPairOption(
    s: String): Option[(Option[Symbol], Option[Symbol])] =
    "^(\\w+)_(\\w+)$".r
      .findFirstMatchIn(s)
      .map(p =>
        Pair(
          find(p.group(1), Actions.ALL),
          find(p.group(2), FormatsText.ALL_TEXT)))

  private def find(s: String, l: List[Symbol]) =
    l.find(it => it.name.toLowerCase.startsWith(s))

  override def apply(s: String) = new Config(translate = translateConfig(s))

  def translateConfig(s: String): TConfig =
    symbolOptionPairOption(s)
      .map(p => TConfig(p._1.get, p._2.get))
      .get

}
