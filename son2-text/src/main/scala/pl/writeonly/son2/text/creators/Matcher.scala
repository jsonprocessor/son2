package pl.writeonly.son2.text.creators

import pl.writeonly.son2.core.config.TConfig

trait Matcher {
  def apply(p: TConfig): String => String
}
