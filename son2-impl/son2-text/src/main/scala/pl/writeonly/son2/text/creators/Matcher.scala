package pl.writeonly.son2.text.creators

import pl.writeonly.son2.core.config.TConfig

trait Matcher {
  type CString = String => String
  def apply(p: TConfig): CString
}
