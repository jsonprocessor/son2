package pl.writeonly.son2.jack.creators

import pl.writeonly.son2.core.notation.PartialCreatorPair
import pl.writeonly.son2.jack.core.ConfigJack

trait PartialCreatorJack extends PartialCreatorPair {
  def c = (s) => ConfigJack(s)
}
