package pl.writeonly.son2.jack.core

import pl.writeonly.son2.core.glue.Config

object ConfigJack {
  def apply(i: String = Formats.OBJECT, s: Boolean = true, o: String, p: Boolean = true) = new Config(i, s, o, p)
}


