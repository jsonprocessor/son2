package pl.writeonly.son2.path.core

import pl.writeonly.son2.core.config.Config

object ConfigPath {
  def apply(i: Symbol): Config = ConfigPath.apply(i = i)

  def apply(i: String = "$", s: Boolean = true, o: Symbol = Formats.SMART, p: Boolean = false) = new Config(Symbol(i), s, o, p)

}


