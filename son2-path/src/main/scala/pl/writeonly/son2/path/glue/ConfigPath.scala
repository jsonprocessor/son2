package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.glue.Config

object ConfigPath {
  def apply(i:String = "$", s : Boolean = true, o : String = "o", p : Boolean = false) = new Config(i, s, o, p)
}


