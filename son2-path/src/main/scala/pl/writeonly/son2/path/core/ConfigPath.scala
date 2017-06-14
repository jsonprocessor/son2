package pl.writeonly.son2.path.core

import pl.writeonly.son2.core.glue.Config

object ConfigPath {
  def apply(i:String = "$", s : Boolean = true, o : String = Formats.SMART.name, p : Boolean = false) = new Config(i, s, o, p)

  def apply(i:Symbol):Config = ConfigPath.apply(i=i.name)

}


