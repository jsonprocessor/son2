package pl.writeonly.son2.jack.core

import pl.writeonly.son2.core.config._

object ConfigJack {
  def apply(s: String): Config = ConfigJack.apply(o = Format(s))

  def apply(i: Format = FormatsJack.OBJECT,
            s: RStyle = RStream,
            o: Format,
            p: WStyle = WPretty) =
    Config(read = RConfig(provider = Provider(i.s), format = i, stream = s),
           write = WConfig(provider = Provider(o.s), format = o, style = p))

  def apply(): Config = ConfigJack.apply(FormatsJack.YAML)

  def apply(s: Format): Config = ConfigJack.apply(o = s)

}
