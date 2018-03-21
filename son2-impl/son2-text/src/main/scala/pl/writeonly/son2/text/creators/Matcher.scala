package pl.writeonly.son2.text.creators

import pl.writeonly.son2.apis.config.TConfig
import pl.writeonly.son2.apis.core.core.DString

trait Matcher {

  def apply(p: TConfig): DString
}
