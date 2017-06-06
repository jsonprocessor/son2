package pl.writeonly.son2.jack.core

import pl.writeonly.son2.core.glue.Config

object ConfigJack {
  def apply(i: String = Formats.OBJECT, s: Boolean = true, o: String = Formats.YAML, p: Boolean = true) = new Config(i, s, o, p)
  def path(i:String = "$", s : Boolean = true, o : String = "o", p : Boolean = false) = new Config(i, s, o, p)
}


