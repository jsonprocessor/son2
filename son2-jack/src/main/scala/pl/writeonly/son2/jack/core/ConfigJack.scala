package pl.writeonly.son2.jack.core

import pl.writeonly.son2.core.notation.Config


object ConfigJack {
  def apply(o: Symbol): Config = ConfigJack.apply(o = o.name)

  def apply(i: String = Formats.OBJECT.name, s: Boolean = true, o: String, p: Boolean = true) = new Config(i, s, o, p)

  def apply(f: String): Config = ConfigJack.apply(o = f)

  def apply(): Config  = ConfigJack.apply(o = Formats.YAML.name)

}




