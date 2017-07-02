package pl.writeonly.son2.path.formats.matchers

import pl.writeonly.son2.core.formats.matchers.MatcherFormat
import pl.writeonly.son2.core.notation.NotationWriter

class MatcherFormatWriter(pretty: Boolean) extends MatcherFormat[NotationWriter] {

  def apply(s: String): Option[NotationWriter] = new ChainCreatorPath(pretty).apply(s).map(_.w)

}
