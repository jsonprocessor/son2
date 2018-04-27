package pl.writeonly.son2.text.creators

import pl.writeonly.son2.apis.config.{Action, Format, RWTConfig, TConfig}
import pl.writeonly.son2.apis.pcreators.PCreatorConfig
import pl.writeonly.son2.text.core.{Actions, FormatsText}
import pl.writeonly.addons.pipe.Pipe._

class PCreatorConfigText extends PCreatorConfig {

  private val matcher = new MatcherStringEscape()

  override def isDefinedAt(s: String): Boolean =
    s &&
      symbolOptionPairOption(s)
        .exists(p => p._1 && p._2)

  private def symbolOptionPairOption(
    s: String
  ): Option[(Option[Action], Option[Format])] =
    "^(\\w+)_(\\w+)$".r
      .findFirstMatchIn(s)
      .map(
        p =>
          Pair(
            find1(p.group(1), Actions.ALL),
            find2(p.group(2), FormatsText.ALL_TEXT)
        )
      )

  private def find1(s: String, l: List[Action]) =
    l.find(it => it.name.toLowerCase.startsWith(s))

  private def find2(s: String, l: List[Format]) =
    l.find(it => it.name.toLowerCase.startsWith(s))

  override def apply(s: String) = RWTConfig(translate = translateConfig(s))

  def translateConfig(s: String): TConfig =
    symbolOptionPairOption(s)
      .map(p => TConfig(p._1.get, p._2.get))
      .get

}
