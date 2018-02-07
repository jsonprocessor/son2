package pl.writeonly.son2.jack.core

import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}

object ConfigJack {
  def apply(s: String): Config = ConfigJack.apply(o = Symbol(s))

  def apply(i: Symbol = FormatsJack.OBJECT,
            s: Boolean = true,
            o: Symbol,
            p: Boolean = true) =
    new Config(read = RConfig(provider = i, format = i, stream = s),
               write = WConfig(provider = o, format = o, style = p))

  def apply(): Config = ConfigJack.apply(FormatsJack.YAML)

  def apply(s: Symbol): Config = ConfigJack.apply(o = s)

}
