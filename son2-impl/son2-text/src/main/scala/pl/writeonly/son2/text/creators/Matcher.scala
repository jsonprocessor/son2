package pl.writeonly.son2.text.creators

import pl.writeonly.son2.core.config.TConfig
import pl.writeonly.son2.core.core.DString

trait Matcher {

  def apply(p: TConfig): DString
}
