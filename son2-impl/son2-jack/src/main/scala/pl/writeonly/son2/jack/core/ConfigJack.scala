package pl.writeonly.son2.jack.core

import pl.writeonly.son2.core.config._

object ConfigJack {
  def apply(s: String): Config = ConfigJack.apply(o = Symbol(s))

  def apply(i: Symbol = FormatsJack.OBJECT,
            s: RStyle = RStream,
            o: Symbol,
            p: WStyle = WPretty) =
    new Config(read = RConfig(provider = i, format = i, stream = s),
               write = WConfig(provider = o, format = o, style = p))

  def apply(): Config = ConfigJack.apply(FormatsJack.YAML)

  def apply(s: Symbol): Config = ConfigJack.apply(o = s)

}
