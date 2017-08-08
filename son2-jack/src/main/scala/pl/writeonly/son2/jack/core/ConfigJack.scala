package pl.writeonly.son2.jack.core

import pl.writeonly.son2.core.config.{Config, RConfig}

object ConfigJack {
  def apply(s: Symbol): Config = ConfigJack.apply(o = s)

  def apply(s: String): Config = ConfigJack.apply(o = Symbol(s))

  def apply(i: Symbol = Formats.OBJECT, s: Boolean = true, o: Symbol, p: Boolean = true) = new Config(
    read = RConfig(format = i, stream = s), writeFormat= o, writeStyle = p
  )

  def apply(): Config = ConfigJack.apply(Formats.YAML)

}




